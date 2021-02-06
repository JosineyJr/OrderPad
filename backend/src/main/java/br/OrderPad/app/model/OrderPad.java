package br.OrderPad.app.model;


import br.OrderPad.app.enums.OrderPadStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderPads")
public class OrderPad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderPadId")
    private Integer id;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "orderPad_order",
            joinColumns = @JoinColumn(name = "orderPadId"),
            inverseJoinColumns = @JoinColumn(name = "orderId"))
    private List<Order> orders;

    @Column(name = "orderStatus")
    private OrderPadStatus STATUS;
}