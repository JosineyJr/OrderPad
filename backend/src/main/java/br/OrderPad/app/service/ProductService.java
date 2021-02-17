package br.OrderPad.app.service;

import br.OrderPad.app.model.Product;
import br.OrderPad.app.repository.ProductsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductsRepository productsRepository;

    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public ProductService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAllList(){
        return this.productsRepository.findAll();
    }

    public Optional<Product> findOne(Integer productId) {
        log.debug("REST request to get product: {}", productId);
        return this.productsRepository.findById(productId);
    }

    public Product saveProduct(Product product) {
        log.debug("REST request to save product: {}", product);
        product = this.productsRepository.save(product);
        return product;
    }
}
