package com.app.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class CartConsumer {
//	@Autowired
 private LoadBalancerClient client;

	public String getResponse() {
		
		ServiceInstance si=client.choose("CART-SERVICE");
		String url=si.getUri()+"/cart/info";
		RestTemplate rt=new RestTemplate();
		ResponseEntity<String> response=rt.getForEntity(url,String.class);
		return response.getBody();
	}
}
