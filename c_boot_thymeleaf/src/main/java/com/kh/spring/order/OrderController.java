package com.kh.spring.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;
	
	@GetMapping("order-form")
	public void orderForm() {}
	
	@PostMapping("order")
	public String order(@RequestParam(required = false, name = "food") Optional<List<String>> foods, Model model) {
		
		Map<String, Object> commandMap = orderService.order(foods.orElseGet(() -> List.of()));  //.orElse(List.of()) 연산할 값 없이 빈 리스트만 보낼 때
		model.addAllAttributes(commandMap);
		return "order/receipt";
	}
	
}
