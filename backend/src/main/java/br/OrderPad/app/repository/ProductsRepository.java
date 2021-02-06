package br.OrderPad.app.repository;

import br.OrderPad.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
    Product findByNameStartingWith(String search);
    Product findByName(String productName);

    Product findByStockGreaterThan(Integer quantity);
}
