package qwekas.springbootrestapi;

import qwekas.springbootrestapi.Product;
import qwekas.springbootrestapi.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
// controller implementation for REST API endpoints 
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping // GET /products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}") // GET /products/{id}
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    @PostMapping // POST /products
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}") // PUT /products/{id}
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id);
            return productRepository.save(updatedProduct);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}") // DELETE /products/{id}
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}