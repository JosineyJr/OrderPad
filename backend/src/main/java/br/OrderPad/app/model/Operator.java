package br.OrderPad.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

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

    @Column(name = "operator_name")
    @Length(min = 5, message = "*Seu Nome de Usuário deve ter pelo menos 5 characteres")
    @NotEmpty(message = "*Por favor digite um Nome de Usuário")
    private String userName;

    @Column(name = "name")
    @NotEmpty(message = "*Por favor digite seu nome")
    private String name;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "password")
    @Length(min = 5, message = "*Sua password deve ter mais de 5 characteres")
    @NotEmpty(message = "*Por favor digite sua password")
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "operator_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
