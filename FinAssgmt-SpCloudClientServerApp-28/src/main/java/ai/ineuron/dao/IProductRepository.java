package ai.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ai.ineuron.model.Product_FA27;

public interface IProductRepository extends JpaRepository<Product_FA27, Long> {

}
