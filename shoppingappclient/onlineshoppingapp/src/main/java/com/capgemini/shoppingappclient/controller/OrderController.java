package com.capgemini.shoppingappclient.controller;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.capgemini.shoppingappclient.entity.LineItem;
import com.capgemini.shoppingappclient.entity.Order;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Controller
public class OrderController {
	
	@Autowired
    private static EurekaClient eurekaClient;

	private Set<LineItem> itemCart = new HashSet<>();
	private static final RestTemplate REST_TEMPLATE = new RestTemplate();
	
	static Application application = eurekaClient.getApplication("");
    static InstanceInfo instanceInfo = application.getInstances().get(0);
    private static final String baseUrl = "http://"+instanceInfo.getIPAddr()+ ":"+instanceInfo.getPort();
	
	Random r = new Random();
	
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}

	@RequestMapping("/addToCart")
	public String addToCart(HttpServletRequest request, HttpSession session) {
		request.getSession();
		int productId = Integer.parseInt(request.getParameter("productId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		LineItem item = new LineItem(quantity, productId, productPrice);
		itemCart.add(item);
		double total = 0;
		for (LineItem i : itemCart) {
			total = total + i.getPrice();
		}
		session.setAttribute("cartsize", itemCart.size());
		session.setAttribute("total", total);
		session.setAttribute("cart", itemCart);
		return "index";
	}

	@RequestMapping("/removeFromCart")
	public void removeFromCart(int productId) {
		for (LineItem i : itemCart) {
			if (i.getProductId() == productId) {
				itemCart.remove(i);
			}
		}

	}

	/*@RequestMapping("/getCart")
	public Set<LineItem> getCart(int customerId) {
		Set<LineItem> tempSet = itemCart.get(customerId);
		return tempSet;
	}*/

	@RequestMapping("/submitorder")
	public String submitOrder(HttpServletRequest request, int customerId) {
		HttpSession session = request.getSession();
		double total = (double) session.getAttribute("total");
		Set<LineItem> items = (Set<LineItem>) session.getAttribute("cart");
		Order order = new Order();
		order.setOrderId(r.nextInt());
		order.setCustomerId(customerId);
		order.setItems(items);
		order.setTotal(total);
		
		order = REST_TEMPLATE.postForObject(baseUrl + "/order", order, Order.class);
		System.out.println(order);
		return "index";
	}

	@RequestMapping("/cancelorder")
	public String cancelOrder() {
		REST_TEMPLATE.delete(baseUrl + "/order");
		return "index";
	}
	
	@RequestMapping()
	public String deleteOrder

	@DeleteMapping("/shop/order/{orderId}")
	public ResponseEntity<Order> deleteOrder(@PathVariable int orderId) {
		orderService.deleteOrder(orderId);
		return new ResponseEntity<Order>(HttpStatus.OK);
	}

	@GetMapping("/shop/order")
	public ResponseEntity<Order> getOrder(@RequestParam int orderId) {
		return new ResponseEntity<Order>(orderService.getOrder(orderId), HttpStatus.OK);
	}

	@GetMapping("/shop/orders")
	public ResponseEntity<List<Order>> getOrder() {
		return new ResponseEntity<List<Order>>(orderService.getOrders(), HttpStatus.OK);
	}*/

}
