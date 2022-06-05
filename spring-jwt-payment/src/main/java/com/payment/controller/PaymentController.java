package com.payment.controller;

import com.payment.application.Books;
import com.payment.model.Account;
import com.payment.payload.OrderDTO;
import com.payment.payload.OrderWithProductVO;
import com.payment.payload.request.LoginRequest;
import com.payment.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {

    private Map<String, LoginRequest> users = new HashMap<String, LoginRequest>();
    private String orderUrl = "http://localhost:9002/order";

    @Autowired
    private AccountRepository accountRepository;

    RestTemplate restTemplate = new RestTemplate();

    OrderWithProductVO order;


    @GetMapping("/payment/placeorder/{orderId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> placeOrder(@PathVariable Integer orderId) {
         order = restTemplate.getForObject(orderUrl + "/" + orderId, OrderWithProductVO.class);
        System.out.println("ORDER PLACED " + order);
        return new ResponseEntity<String>("ORDER PLACED ",HttpStatus.OK);
    }

    @GetMapping("/payment/doPayment")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> transaction() {
        //Order order = restTemplate.getForObject(serverUrl, Order.class);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        Account account = accountRepository.findByUsername(username).get();
        double balance = account.getBalance();

        System.out.println("username is "+ username + " Balance is " + balance);
        System.out.println("doPayment");
        String msg="";
        if(balance > order.getOrder().getTotalPrice()) {
            account.setBalance(balance - order.getOrder().getTotalPrice() );
            accountRepository.save(account);
            msg = "Transaction Completed";
        }else{
            msg = "insufficient fund";

        }

        System.out.println(msg);
        return new ResponseEntity<String>(msg,HttpStatus.OK);
    }


    @GetMapping("/payment/shiporder")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> shipOrder() {
        //Order order = restTemplate.getForObject(serverUrl, Books.class);
        System.out.println("Order shipped");
        return new ResponseEntity<String>("Order shipped",HttpStatus.OK);
    }


//
//    @GetMapping("/payment")
//    public ResponseEntity<?> shipOrder(@RequestBody Order order, @RequestParam double accountBalance) {
//
//        return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
//    }
//
//    @GetMapping("/payment/{orderNo}")
//    public ResponseEntity<?> createTransaction(@PathVariable String orderNo) {  // pay for the order
//
//        return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
//    }


}
