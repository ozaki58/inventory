package com.example.demo.repository.rental;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.rental.RentalAddRequest;
import com.example.demo.dto.rental.RentalUpdateRequest;
import com.example.demo.dto.user.UserSearchRequest;
import com.example.demo.dto.user.UserSearchRequest1;
import com.example.demo.entity.Rental;



@Mapper
public interface RentalMapper {


	@Select("SELECT * FROM Rental WHERE id=#{id} ")
	Rental rentalFindById(Long id);


	 @Select("SELECT * FROM Rental")
	    List<Rental> searchAll();

	 @Select("SELECT * FROM Rental WHERE DATEDIFF(CURDATE(), updateDate) > 30")
	 List<Rental> overSearchAll();

	 @Select("SELECT * FROM Rental WHERE pname = #{pname}")
		List<Rental> userSearch(UserSearchRequest userSearchRequest);


	 @Select("SELECT * FROM Rental WHERE name = #{name}")
		List<Rental> userSearch1(UserSearchRequest1 uesrSearchRequest1);

	@Insert("INSERT INTO Rental (pname, name, phone)	VALUES (#{pname}, #{name}, #{phone})")
	void rentalSave(RentalAddRequest rentalRequest);
	;

	@Delete("DELETE FROM Rental WHERE id = #{id}")
	public void rentalDelete(Long id);


	@Update("UPDATE rental SET pname=#{pname}, name=#{name} WHERE id=#{id}")
    void rentalUpdate(RentalUpdateRequest rental);



}