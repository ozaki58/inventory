package com.example.demo.service.user;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.user.UserAddRequest;
import com.example.demo.dto.user.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.user.UserMapper;


@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;
  //条件にあったものをとってくる




	public List<User> userSearchAll(){
    return userMapper.userSearchAll();
	}



    public void userSave(UserAddRequest userAddRequest) {
        userMapper.userSave(userAddRequest);
    }


    public void userDelete(Long id) {
        userMapper.userDelete(id);
    }


    public void userUpdate(UserUpdateRequest userUpdateRequest) {
        userMapper.userUpdate(userUpdateRequest);
    }


    public User findById(Long id) {
        return userMapper.findById(id);
    }


}


