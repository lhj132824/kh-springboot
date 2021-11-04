package com.kh.spring.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.spring.food.Food;

@Service
public class OrderService {

	public Map<String, Object> order(List<String> foods) {
		
		Map<String, Object> commandMap = new HashMap<String, Object>();
		
		List<Food> orders = foods.stream().map(e -> Food.createFood(e)).toList();       //아래코드를 한줄로!!
		//List<Food> orders = new ArrayList<>();
		//for (String food : foods) {
		//	orders.add(Food.createFood(food));
		//}
		
		int payPrice = orders.stream().map(e -> e.getPrice()).reduce((a,b) -> a+b).orElse(0);       //아래코드를 한줄로!!
		//int payPrice = 0;
		//for (Food order : orders) {
		//	payPrice += order.getPrice();
		//}
		return Map.of("orders", orders, "payPrice", payPrice);        //아래코드를 한줄로!!
		//commandMap.put("orders", orders);
		//commandMap.put("payPrice", payPrice);
		//return commadMap;
		
	}

}
