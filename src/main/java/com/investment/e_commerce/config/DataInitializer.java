package com.investment.e_commerce.config;
import com.investment.e_commerce.dao.OrderRepository;
import com.investment.e_commerce.dao.UserRepository;
import com.investment.e_commerce.model.User;
import com.investment.e_commerce.model.UserOrder;
import com.investment.e_commerce.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        populateUsers();
        populateOrders();
    }

    private void populateUsers() {
        List<User> users = Arrays.asList(
                new User("John", "Doe", LocalDate.of(1990, 1, 20), "New York", "password12", "john.doe@example.com", UserRole.CUSTOMER, null, Arrays.asList("Reading", "Hiking"), new HashMap<>(Map.of("Home", "123 Main St", "Work", "456 Business Ave"))),
                new User("Jane", "Doe", LocalDate.of(1992, 5, 15), "Los Angeles", "password34", "jane.doe@example.com", UserRole.CUSTOMER, null, Arrays.asList("Cooking", "Swimming"), new HashMap<>(Map.of("Home", "789 Elm St", "Work", "1011 Hollywood Blvd"))),
                new User("Bob", "Smith", LocalDate.of(1985, 3, 10), "Chicago", "password56", "bob.smith@example.com", UserRole.SELLER, null, Arrays.asList("Gaming", "Cycling"), new HashMap<>(Map.of("Home", "213 Oak St", "Warehouse", "314 Industrial Rd"))),
                new User("Alice", "Johnson", LocalDate.of(1988, 7, 22), "Houston", "password78", "alice.johnson@example.com", UserRole.ADMIN, null, Arrays.asList("Painting", "Traveling"), new HashMap<>(Map.of("Home", "415 Pine St", "Work", "516 Downtown Ave")))
        );

        userRepository.saveAll(users);
    }

    private void populateOrders() {
        // Fetch some users to associate orders with
        User john = userRepository.findByEmail("john.doe@example.com").orElseThrow();
        User jane = userRepository.findByEmail("jane.doe@example.com").orElseThrow();
        User bob = userRepository.findByEmail("bob.smith@example.com").orElseThrow();

        List<UserOrder> orders = Arrays.asList(
                new UserOrder("ORD001", LocalDate.now().minusDays(5), john),
                new UserOrder("ORD002", LocalDate.now().minusDays(10), john),
                new UserOrder("ORD003", LocalDate.now().minusDays(2), jane),
                new UserOrder("ORD004", LocalDate.now().minusDays(20), bob)
        );

        orderRepository.saveAll(orders);
    }
}


