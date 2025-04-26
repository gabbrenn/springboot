package rw.vladvisionlab.inzozi.models;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    private String description;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private float price;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public Products(){}
    
}
