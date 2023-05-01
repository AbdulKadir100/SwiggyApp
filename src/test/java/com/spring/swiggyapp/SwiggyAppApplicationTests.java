package com.spring.swiggyapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.Spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import food.Food;
import food.FoodRepo;
import food.FoodService;

@RunWith(Runner.class)
@SpringBootTest
class SwiggyAppTests {
	
	@Autowired
	private FoodService foodService;
	@MockBean
	private FoodRepo foodRepo;

	@Test
	public void savefood() {
		Food f = new Food(1,"Pizza","Junk");
		when(foodRepo.save(f)).thenReturn(f);
		assertEquals(f,foodService.saveFood(f));
	}
	
	@Test
	public void getAllFood() {
		when(foodRepo.findAll()).thenReturn(Stream.of(new Food(1,"Pizza","Junk"),
				new Food(2,"Samosa","Desert")).collect(Collectors.toList()));
		assertEquals(2, foodService.getAll().size());
	}

	
}
