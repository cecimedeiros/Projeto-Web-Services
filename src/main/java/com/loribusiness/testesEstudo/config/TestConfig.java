package com.loribusiness.testesEstudo.config;

import com.loribusiness.testesEstudo.entities.Category;
import com.loribusiness.testesEstudo.entities.Order;
import com.loribusiness.testesEstudo.entities.User;
import com.loribusiness.testesEstudo.entities.enums.OrderStatus;
import com.loribusiness.testesEstudo.repositories.CategoryRepository;
import com.loribusiness.testesEstudo.repositories.OrderRepository;
import com.loribusiness.testesEstudo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    //o nome dessas funções que iniciam as db's são seedings
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User u1 = new User(null, "Yves", "yves@leromail.com", "988888888", "123456");
        User u2 = new User(null, "Pedro", "pedro@leromail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2024-05-12T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2024-05-12T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2024-05-13T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }



}
