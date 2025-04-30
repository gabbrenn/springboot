package rw.vladvisionlab.inzozi.models;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String description;
    private int quantity;
    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;


    @CreationTimestamp
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime createdAt;
    
}
