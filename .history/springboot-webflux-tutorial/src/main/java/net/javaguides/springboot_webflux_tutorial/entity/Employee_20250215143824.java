package net.javaguides.springboot_webflux_tutorial.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employees")
public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
