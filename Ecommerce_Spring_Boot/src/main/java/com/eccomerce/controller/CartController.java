package com.eccomerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eccomerce.entities.Cart;
import com.eccomerce.entities.Customer;
import com.eccomerce.entities.Product;
import com.eccomerce.service.CartService;
import com.eccomerce.service.CustomerService;
import com.eccomerce.service.ProductService;

@RestController
@RequestMapping("/cart")
public class CartController {
		@Autowired
		CartService cartService;
		
		@Autowired
		CustomerService customerService;
		
		@Autowired
		ProductService productService;
		@GetMapping("")
		public ResponseEntity<List<Cart>> getAllOrder()
		{
			List<Cart> cartList=cartService.getOrders();
			if(cartList.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.ok(cartList);
		}
		
		@PostMapping("/new")
		public ResponseEntity<Cart> addToCart(@Valid @RequestBody Cart cart)
		{
			cartService.addToCart(cart);
			return ResponseEntity.status(HttpStatus.CREATED).body(cart);
		}
		@GetMapping("/{cartId}")
		public ResponseEntity<Cart> getCartById(@PathVariable int cartId)
		{
			Cart cart=cartService.findById(cartId);
			if(cart==null)
			{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.ok(cart);
		}
		@GetMapping("/user/{customerId}")
		public ResponseEntity<List<Cart>> getCartByUserId(@PathVariable int customerId)
		{
			Customer customer=customerService.getCustomerById(customerId);
			if(customer==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			List<Cart> cartList=cartService.findByCustomer(customer);
			if(cartList.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.ok(cartList);
		}
		
		@GetMapping("/product/{productId}")
		public ResponseEntity<List<Cart>> getCartByProductId(@PathVariable int productId)
		{
			Product product=productService.getProduct(productId);
			if(product==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			List<Cart> cartList=cartService.findByProduct(product);
			if(cartList.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.ok(cartList);
		}
		@PutMapping("/{cartId}")
		public ResponseEntity<Cart> updateCartById(@Valid @RequestBody Cart cart,@PathVariable int cartId)
		{
			Cart cart1=cartService.findById(cartId);
			cart.setOrderId(cartId);
			cartService.update(cart);
			return ResponseEntity.ok(cart);
		}
		
}
