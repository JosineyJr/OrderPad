package br.OrderPad.app.repository;

import br.OrderPad.app.enums.OrderPadStatus;
import br.OrderPad.app.model.Order;
import br.OrderPad.app.model.OrderPad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPadsRepository extends JpaRepository<OrderPad, Long> {
    OrderPad findOrderPadByOrders(Order order);

    OrderPad findAllBySTATUS(OrderPadStatus status);
}
