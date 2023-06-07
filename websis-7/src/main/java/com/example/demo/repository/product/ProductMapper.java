package com.example.demo.repository.product;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.product.ProductAddRequest;
import com.example.demo.dto.product.ProductSearchRequest;
import com.example.demo.dto.product.ProductUpdateRequest;
import com.example.demo.entity.Syouhin1;


@Mapper
public interface ProductMapper {
@Insert("INSERT INTO Syouhin1 (name, num)	VALUES (#{name}, #{num})")
	void productSave(ProductAddRequest productRequest);
@Select("SELECT * FROM Syouhin1 WHERE name = #{name}")
List<Syouhin1> productSearch(ProductSearchRequest productSearchRequest);
@Select("SELECT * FROM Syouhin1")
List<Syouhin1> productSearchAll();
@Select("SELECT * FROM Syouhin1 WHERE id=#{id} ")
Syouhin1 productFindById(Long id);

@Update("UPDATE Syouhin1 SET name=#{name}, num=#{num} WHERE id=#{id}")
void productUpdate(ProductUpdateRequest product);

@Delete("DELETE FROM Syouhin1 WHERE id = #{id}")
public void productDelete(Long id);
}