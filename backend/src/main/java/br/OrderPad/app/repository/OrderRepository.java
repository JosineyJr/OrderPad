package br.OrderPad.app.repository;

import br.OrderPad.app.model.Order;
import br.OrderPad.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrdersByProductsIn(Product product);
}
