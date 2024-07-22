package com.digistore.ecommerce.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate;
    @NotNull
    @Min(value = 0)
    private BigDecimal totalAmount;
    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name ="order-product",
            joinColumns = @JoinColumn(name= "order_id"),
            inverseJoinColumns = @JoinColumn(name= "product_id")
    )
    private List<Product> products = new ArrayList<>();

}
