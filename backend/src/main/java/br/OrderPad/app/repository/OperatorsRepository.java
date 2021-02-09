package br.OrderPad.app.repository;

import br.OrderPad.app.model.Operator;
import br.OrderPad.app.model.OrderPad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorsRepository extends JpaRepository<Operator, Long> {
    Operator findOperatorByOrderPads(OrderPad orderPad);

    Operator findOperatorByUserName(String userName);

    Operator findByActiveTrueAndUserName(String userName);
}
