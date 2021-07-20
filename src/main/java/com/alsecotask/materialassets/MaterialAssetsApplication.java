package com.alsecotask.materialassets;

import com.alsecotask.materialassets.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class MaterialAssetsApplication {
	public static void main(String[] args) {
		SpringApplication.run(MaterialAssetsApplication.class, args);

		Employee employee = new Employee("Ulan", "Duisek");
		System.out.println(employee);
	}
}
