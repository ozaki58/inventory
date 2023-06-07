package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.user.UserAddRequest;
import com.example.demo.dto.user.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.service.user.UserService;


@Controller

public class UserController {

  @Autowired
  UserService userService;


  //新規顧客登録画面を表示
  @GetMapping(value = "/user/add")
  public String userAdd(Model model) {
      model.addAttribute("userAddRequest", new UserAddRequest());
      return "user/add";
  }




  //ユーザー新規登録
  @RequestMapping(value = "/user/create", method = RequestMethod.POST)
  public String create(@Validated @ModelAttribute UserAddRequest userRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {
          // 入力チェックエラーの場合
          List<String> errorList = new ArrayList<String>();
          for (ObjectError error : result.getAllErrors()) {
              errorList.add(error.getDefaultMessage());
          }
          model.addAttribute("validationError", errorList);
          return "user/add";
      }
      // ユーザー情報の登録
      userService.userSave(userRequest);
      return "redirect:/user/info";
  }







 //顧客検索画面を表示
  @GetMapping(value = "/user/search")
  public String displaySearch(Model model) {
    return "user/search";
  }






  //会員顧客一覧画面を表示
  @GetMapping(value = "/user/info")
  public String userInfo(Model model) {
	  List<User> userlist = userService.userSearchAll();
	  model.addAttribute("userlist", userlist);
    return "user/info";
  }








  @GetMapping("/user/{id}/delete")
  public String userDelete(@PathVariable Long id, Model model) {
      // ユーザー情報の削除
      userService.userDelete(id);
      return "redirect:/user/info";
  }



  //編集画面を表示
  @GetMapping("/user/{id}/edit")
  public String displayEdit(@PathVariable Long id, Model model) {
      User user = userService.findById(id);
      UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
      userUpdateRequest.setId(user.getId());
      userUpdateRequest.setId(user.getId());
      userUpdateRequest.setPname(user.getPname());
      userUpdateRequest.setPhone(user.getPhone());
      userUpdateRequest.setPhone(user.getAddress());

      model.addAttribute("userUpdateRequest", userUpdateRequest);
      return "user/edit";
  }

  @RequestMapping(value = "/user/update", method = RequestMethod.POST)
  public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {
          List<String> errorList = new ArrayList<String>();
          for (ObjectError error : result.getAllErrors()) {
              errorList.add(error.getDefaultMessage());
          }
          model.addAttribute("validationError", errorList);
          return "user/edit";
      }
      // ユーザー情報の更新
      userService.userUpdate(userUpdateRequest);
      return "redirect:/user/info";
  }


  }

