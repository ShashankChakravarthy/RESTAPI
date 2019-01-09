package com.example.RESTAPI.ReafactoredRESTAPI.Repository;

import com.example.RESTAPI.ReafactoredRESTAPI.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    Product findByName(String name);

}
