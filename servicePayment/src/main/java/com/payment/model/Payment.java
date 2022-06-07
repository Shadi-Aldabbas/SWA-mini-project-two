package com.payment.model;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private PaymentEnum name;

	public Payment() {

	}

	public Payment(PaymentEnum name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaymentEnum getName() {
		return name;
	}

	public void setName(PaymentEnum name) {
		this.name = name;
	}
}