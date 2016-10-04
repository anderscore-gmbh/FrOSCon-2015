package com.anderscore.springbatchexample.simple.processor;

import java.util.Arrays;

import org.springframework.batch.item.ItemProcessor;

import com.anderscore.springbatchexample.simple.model.Product;

/**
 * Processor that finds existing products and updates a product quantity appropriately
 */
public class ProductItemProcessor3 implements ItemProcessor<Product,Product>
{
//	static final int[] FILTER_ID_ARRAY = new int[] {7, 8}; 
	
    @Override
    public Product process(Product product) throws Exception
    {        
        // Filtern eines Eintrags mit einer bestimmten ID
        if(product.getId() == 5) {
        	return null;
        }
        return product;
    }
}
