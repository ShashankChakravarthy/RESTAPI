package com.example.RESTAPI.ReafactoredRESTAPI.Service;

import com.example.RESTAPI.ReafactoredRESTAPI.Controller.ProductsController;
import com.example.RESTAPI.ReafactoredRESTAPI.Model.Product;
import com.example.RESTAPI.ReafactoredRESTAPI.Repository.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductService {

    private Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepo productRepo;

    public Optional<Product> getProductById(Integer id){
        try{
            return productRepo.findById(id);
        }
        catch(Exception e){
            log.error(e.getMessage());
        }
        return Optional.of(new Product());
    }

    public Product saveProduct(Product product){
        try{
            return productRepo.save(product);
        }
        catch (Exception e){
            log.error("Failed while Saving " +e.getMessage());
        }
        return new Product();
    }

    public boolean updateProduct(Product product,String name){
        Product foundProduct = productRepo.findByName(name);
        try {
            foundProduct.setName(product.getName());
            foundProduct.setDesc(product.getDesc());
            productRepo.save(foundProduct);
            productRepo.save(foundProduct);
            return true;
        }
        catch(Exception e){
            log.error("Error while updating " +e.getMessage());
        }
        return false;
    }

    public void deleteProduct(String name) {
        try{
        Product foundProduct = productRepo.findByName(name);
        productRepo.delete(foundProduct);
    }
        catch(Exception e){

            log.error("Error while Deleting");
        }

    }

}
