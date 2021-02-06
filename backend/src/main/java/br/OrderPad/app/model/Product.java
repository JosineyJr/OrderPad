package br.OrderPad.app.model;

import br.OrderPad.app.enums.ProductStockStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Integer id;

    @Column(name = "productName")
    @NotEmpty(message = "*Por favor digite um nome para o produto")
    private String name;

    @Column(name = "productStock")
    private Integer stock;

    @Column(name = "productStockStatus")
    private ProductStockStatus productStockStatus;
}
