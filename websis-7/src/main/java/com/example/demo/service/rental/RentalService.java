package com.example.demo.service.rental;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.rental.RentalAddRequest;
import com.example.demo.dto.rental.RentalUpdateRequest;
import com.example.demo.dto.user.UserSearchRequest;
import com.example.demo.dto.user.UserSearchRequest1;
import com.example.demo.entity.Rental;
import com.example.demo.repository.rental.RentalMapper;
@Service
public class RentalService {


    @Autowired
    private RentalMapper rentalMapper;
  //条件にあったものをとってくる



    public List<Rental> userSearch(UserSearchRequest userSearchRequest) {
    return rentalMapper.userSearch(userSearchRequest);
    }

	public List<Rental> userSearch1(UserSearchRequest1 userSearchRequest1) {
    return rentalMapper.userSearch1(userSearchRequest1);
	}



	public List<Rental> searchAll(){
	    return rentalMapper.searchAll();
		}

	public List<Rental> overSearchAll(){
    return rentalMapper.overSearchAll();
	}

	 public void rentalSave(RentalAddRequest rentalAddRequest) {
	        rentalMapper.rentalSave(rentalAddRequest);
	    }

	    public void rentalDelete(Long id) {
	        rentalMapper.rentalDelete(id);
	    }


	    public void rentalUpdate(RentalUpdateRequest rentalUpdateRequest) {
	        rentalMapper.rentalUpdate(rentalUpdateRequest);
	    }



	    public Rental rentalFindById(Long id) {
	        return rentalMapper.rentalFindById(id);
	    }
}