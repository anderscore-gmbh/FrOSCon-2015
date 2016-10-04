package com.anderscore.springbatchexample.simple.processor;

import java.util.Arrays;

import org.springframework.batch.item.ItemProcessor;

import com.anderscore.springbatchexample.simple.model.Product;

/**
 * Processor that finds existing products and updates a product quantity appropriately
 */
public class ProductItemProcessor2 implements ItemProcessor<Product,Product>
{	
    @Override
    public Product process(Product product) throws Exception
    {        
        // Hinzufügen einer besonderen Beschreibung zu Produkten mit einer bestimmten ID
        if(product.getId() == 8) {
        	product.setDescription("Processor2 sagt Hallo!");
        	System.out.println("Produkt 8 description changed.");
        }
        if(product.getId() == 5) {
        	product.setDescription("Product 5 processed");
        	System.out.println("Product 5 processed");
        }   
        return product;
    }
}
