package ai.ineuron.dao;


import org.springframework.data.repository.CrudRepository;

import ai.ineuron.bo.Product;

public interface IProductRepository extends CrudRepository<Product, Integer> {

}
