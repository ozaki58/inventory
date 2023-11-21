package com.example.demo.service.product;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.product.ProductAddRequest;
import com.example.demo.dto.product.ProductSearchRequest;
import com.example.demo.dto.product.ProductUpdateRequest;
import com.example.demo.entity.Syouhin1;
import com.example.demo.repository.product.ProductMapper;
@Service
public class ProductService {


    @Autowired
    private ProductMapper productMapper;
  //条件にあったものをとってくる




	public List<Syouhin1> productSearch(ProductSearchRequest productSearchRequest) {
	    return productMapper.productSearch(productSearchRequest);
		}

	public List<Syouhin1> productSearchAll(){
	    return productMapper.productSearchAll();
		}

        public List<Syouhin1> rentalRanking(){
	    return productMapper.rentalRanking();
		}


	 public void productSave(ProductAddRequest productAddRequest) {
	 	productMapper.productSave(productAddRequest);
	        }


	 public void productDelete(Long id) {
	        productMapper.productDelete(id);
	    }

	public void productUpdate(ProductUpdateRequest productUpdateRequest) {
	       productMapper.productUpdate(productUpdateRequest);
	    }

	 public Syouhin1 productFindById(Long id) {
	        return productMapper.productFindById(id);
	    }


}
