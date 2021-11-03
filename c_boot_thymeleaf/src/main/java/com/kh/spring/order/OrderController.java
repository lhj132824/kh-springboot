package com.kh.spring.order;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.food.Food;

@Controller
public class OrderController {

	@GetMapping("order/order-form")
	public void orderForm() {}
	
	@PostMapping("order/receipt")
	public void receipt(@RequestParam Map<String,Object> foodMap ,Model model) {
		Map<String,Object> orders = new LinkedHashMap<>();
		orders.put("피자", 30000);
		orders.put("햄버거",5000);
		orders.put("회",20000);
		orders.put("치킨", 18000);
		
		model.addAttribute("foodMap",foodMap);
	}
	
}
