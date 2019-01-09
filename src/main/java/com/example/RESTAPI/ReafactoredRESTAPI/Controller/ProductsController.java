package com.example.RESTAPI.ReafactoredRESTAPI.Controller;

import com.example.RESTAPI.ReafactoredRESTAPI.Model.Product;
import com.example.RESTAPI.ReafactoredRESTAPI.Repository.ProductRepo;
import com.example.RESTAPI.ReafactoredRESTAPI.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/products")
public class ProductsController {

    private Logger log = LoggerFactory.getLogger(ProductsController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(path="{id}", method = RequestMethod.GET)
    public Optional<Product> getProductById(@PathVariable(value = "id") Integer Id){
        return productService.getProductById(Id);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @RequestMapping(path = "{name}", method=RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable(value = "name") String name ){
        boolean b = productService.updateProduct(product,name);
        if (b)
            return new ResponseEntity<Product>(HttpStatus.CREATED);
        else
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path="{name}",method=RequestMethod.DELETE)
    public void deleteProduct(@PathVariable (value = "name") String name){
        productService.deleteProduct(name);
    }


}
