package qwekas.springbootrestapi;

import qwekas.springbootrestapi.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	// This is just needed for the JpaRepository
}