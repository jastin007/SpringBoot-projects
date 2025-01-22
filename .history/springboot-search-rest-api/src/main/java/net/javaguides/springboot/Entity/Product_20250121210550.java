package net.javaguides.springboot.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = )
public class Product {
    private Long id;
    private String sku;
    private String name;
    private String description;
    private boolean active;
    private String imageUrl;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
