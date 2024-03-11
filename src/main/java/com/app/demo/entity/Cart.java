package com.app.demo.entity;

public class Cart {


	private Integer cartId;
	private String cartCode;
	private Double cartCost;
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public String getCartCode() {
		return cartCode;
	}
	public void setCartCode(String cartCode) {
		this.cartCode = cartCode;
	}
	public Double getCartCost() {
		return cartCost;
	}
	public void setCartCost(Double cartCost) {
		this.cartCost = cartCost;
	}
	public Cart(Integer cartId, String cartCode, Double cartCost) {
		super();
		this.cartId = cartId;
		this.cartCode = cartCode;
		this.cartCost = cartCost;
	}
	public Cart() {
		super();
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartCode=" + cartCode + ", cartCost=" + cartCost + "]";
	}
}
