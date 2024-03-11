package com.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.consumer.CartConsumerFeign;
import com.app.demo.entity.Cart;

@RestController
@RequestMapping("/order")
public class OrderRestController {

	@Autowired
	private CartConsumerFeign consumer;
	@GetMapping("/place")
	public ResponseEntity<String> placeOrder(){
		
		String cartResponse=consumer.showMessage().getBody();
		return ResponseEntity.ok("RESPONSE COMES FROM CART-SERVICE :"+cartResponse);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<String> getOrderById(@PathVariable("id") Integer id){
		
		Cart cart=consumer.getCartById(id).getBody();
		return ResponseEntity.ok("Got Response :"+cart);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createCart(@RequestBody Cart cart){
		String cartValue =consumer.addToCart(cart).getBody();
		return ResponseEntity.ok("RESPONSE COMES FROM CART-SERVICE :"+cartValue);
	}
}
