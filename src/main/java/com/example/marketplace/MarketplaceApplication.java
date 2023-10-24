package com.example.marketplace;

import com.example.marketplace.entity.Brand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MarketplaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketplaceApplication.class, args);
    }

}
