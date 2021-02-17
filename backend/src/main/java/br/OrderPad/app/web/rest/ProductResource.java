package br.OrderPad.app.web.rest;

import br.OrderPad.app.model.Product;
import br.OrderPad.app.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public/product")
public class ProductResource {
    private final Logger log = LoggerFactory.getLogger(ProductResource.class);

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = this.productService.findAllList();
        if (products.size() > 0) {
            return ResponseEntity.ok().body(products);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@Valid @PathVariable Integer productId) {
        log.debug("REST request to get product: {}", productId);
        Optional<Product> product = this.productService.findOne(productId);
        return product.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createRole(@Valid @RequestBody Product product) throws URISyntaxException {
        log.debug("REST request to save product: {}", product);
        if (this.productService.findOne(product.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Um produto com o mesmo nome já esta cadastrado");
        }
        Product result = this.productService.saveProduct(product);
        return  ResponseEntity.created(new URI("/api/products" + result.getName())).body(result);
    }
}
