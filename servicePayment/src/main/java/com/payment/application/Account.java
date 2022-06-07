//package com.payment.application;
//
//import com.payment.model.Address;
//
//import java.util.List;
//
//public class Account {
//    private int id;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private Address shippingAddress;
//    private List<PaymentX> paymentXMethod;
//
//    public Account(int id, String firstName, String lastName, String email, Address shippingAddress, List<PaymentX> paymentXMethod) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.shippingAddress = shippingAddress;
//        this.paymentXMethod = paymentXMethod;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Address getShippingAddress() {
//        return shippingAddress;
//    }
//
//    public void setShippingAddress(Address shippingAddress) {
//        this.shippingAddress = shippingAddress;
//    }
//
//    public List<PaymentX> getPaymentMethod() {
//        return paymentXMethod;
//    }
//
//    public void setPaymentMethod(List<PaymentX> paymentXMethod) {
//        this.paymentXMethod = paymentXMethod;
//    }
//
//    @Override
//    public String toString() {
//        return "Account{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", shippingAddress=" + shippingAddress +
//                ", paymentMethod=" + paymentXMethod +
//                '}';
//    }
//}
