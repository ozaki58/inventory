package com.example.demo.repository.user;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.rental.RentalAddRequest;
import com.example.demo.dto.rental.RentalUpdateRequest;
import com.example.demo.dto.user.UserAddRequest;
import com.example.demo.dto.user.UserSearchRequest;
import com.example.demo.dto.user.UserSearchRequest1;
import com.example.demo.dto.user.UserUpdateRequest;
import com.example.demo.entity.Rental;
import com.example.demo.entity.User;



@Mapper
public interface UserMapper {

	@Select("SELECT * FROM User WHERE id=#{id} ")
	User findById(Long id);

	

	@Select("SELECT * FROM Rental WHERE id=#{id} ")
	Rental rentalFindById(Long id);


	 @Select("SELECT * FROM User")
	    List<User> userSearchAll();
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

	;
	@Insert("INSERT INTO User (pname, phone,address)	VALUES (#{pname}, #{phone},#{address})")
	void userSave(UserAddRequest userRequest);
	;

	@Delete("DELETE FROM User WHERE id = #{id}")
	public void userDelete(Long id);

	@Delete("DELETE FROM Rental WHERE id = #{id}")
	public void rentalDelete(Long id);

	
	@Update("UPDATE user SET pname=#{pname}, phone=#{phone}, address=#{address} WHERE id=#{id}")
    void userUpdate(UserUpdateRequest user);

	@Update("UPDATE rental SET pname=#{pname}, name=#{name} WHERE id=#{id}")
    void rentalUpdate(RentalUpdateRequest rental);

	

}
