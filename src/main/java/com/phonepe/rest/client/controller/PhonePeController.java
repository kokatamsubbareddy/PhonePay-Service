package com.phonepe.rest.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonepe.rest.client.dto.Payment;
import com.phonepe.rest.client.dto.PaymentResponse;
import com.phonepe.rest.client.service.PhonePeService;

@RestController
@RequestMapping("/PhonePe")
public class PhonePeController {
	@Autowired
	private PhonePeService service;
	//http://localhost:9091/PhonePe-client/PhonePe/payment
	
	@PostMapping("/payment")
	public PaymentResponse pay(@RequestBody Payment payment){
		return service.quickPay(payment);
	}
	//http://localhost:9091/PhonePe-client/PhonePe/findTransactions/Phonepay
	@GetMapping("/findTransactions/{vendor}")
	public PaymentResponse getPayments(@PathVariable String vendor){
		return service.getPaymentsByVendor(vendor);
	}

}
