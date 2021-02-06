package br.OrderPad.app.model;

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
@Table(name = "operators")
public class Operator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operatorId")
    private Integer id;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "operator_orderPad",
            joinColumns = @JoinColumn(name = "operatorId"),
            inverseJoinColumns = @JoinColumn(name = "orderPadId"))
    private List<OrderPad> orderPads;
}
