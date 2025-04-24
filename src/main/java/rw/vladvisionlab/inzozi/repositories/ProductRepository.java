package rw.vladvisionlab.inzozi.repositories;

import rw.vladvisionlab.inzozi.models.Products;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long>{    
}
