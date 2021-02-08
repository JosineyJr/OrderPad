package br.OrderPad.app.aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages={"br.OrderPad.app.model"})
@EnableJpaRepositories(basePackages={"br.OrderPad.app.repository"})
@ComponentScan(basePackages = {"br"})

public class OrderPadApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderPadApplication.class, args);
	}

}
