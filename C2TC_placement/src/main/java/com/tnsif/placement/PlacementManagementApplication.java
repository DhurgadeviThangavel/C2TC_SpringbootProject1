package com.tnsif.placement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.tnsif.placement",  // Main app
    "com.tnsif.placement.controller",            // REST controllers
    "com.tnsif.placement.service",               // Business logic
    "com.tnsif.placement.repository",            // JPA repositories
    "com.tnsif.placement.entity"                 // JPA entities
})
@EntityScan(basePackages = {"com.tnsif.placement.entity"})
@EnableJpaRepositories(basePackages = {"com.tnsif.placement.repository"})
@ComponentScan(basePackages = {
	    "com.tnsif.placement" // this covers entity, repository, service, controller
	})
public class PlacementManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlacementManagementApplication.class, args);
        System.out.println("🚀 Placement Management System is up and running!");
    }
}
