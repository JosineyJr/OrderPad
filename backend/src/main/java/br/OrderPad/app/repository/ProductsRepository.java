package br.OrderPad.app.repository;

import br.OrderPad.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
    Product findByNameStartingWith(String search);
    Product findByName(String productName);

    Optional<Product> findById(Integer productId);
}
