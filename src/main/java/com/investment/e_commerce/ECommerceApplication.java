package com.investment.e_commerce;

import com.investment.e_commerce.dao.OrderRepository;
import com.investment.e_commerce.dao.UserRepository;
import com.investment.e_commerce.model.UserOrder;
import com.investment.e_commerce.model.User;
import com.investment.e_commerce.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Hello");
	}





}
