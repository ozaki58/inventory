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

import com.example.demo.dto.rental.RentalAddRequest;
import com.example.demo.dto.rental.RentalUpdateRequest;
import com.example.demo.dto.user.UserSearchRequest;
import com.example.demo.entity.Rental;
import com.example.demo.service.rental.RentalService;


@Controller

public class RentalController {

  @Autowired
  RentalService rentalService;





//レンタル登録画面を表示
  @GetMapping(value = "/rental/add")
  public String rentalAdd(Model model) {
      model.addAttribute("rentalAddRequest", new RentalAddRequest());
      return "rental/add";
  }


//レンタル新規登録
  @RequestMapping(value = "/rental/create", method = RequestMethod.POST)
  public String create(@Validated @ModelAttribute RentalAddRequest rentalRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {
          // 入力チェックエラーの場合
          List<String> errorList = new ArrayList<String>();
          for (ObjectError error : result.getAllErrors()) {
              errorList.add(error.getDefaultMessage());
          }
          model.addAttribute("validationError", errorList);
          return "rental/add";
      }
      // ユーザー情報の登録
      rentalService.rentalSave(rentalRequest);
      return "redirect:/user/menyu";
  }







 //メニュー画面を表示
  @GetMapping(value = "/user/menyu")
  public String displayMenyu(Model model) {
	  List<Rental> rentallist = rentalService.searchAll();
	  model.addAttribute("rentallist", rentallist);
    return "user/menyu";
  }






  //顧客検索
  @RequestMapping(value = "/user/id_search", method = RequestMethod.POST)
  public String userSearch(@ModelAttribute UserSearchRequest userSearchRequest, Model model) {
    List<Rental> userinfo = rentalService.userSearch(userSearchRequest);
    model.addAttribute("userinfo", userinfo);
    return "user/search";
  }

//貸し出し期限超過者を表示
  @GetMapping(value = "/user/oversearch")
  public String displaySearch3(Model model) {
	  List<Rental> overuserlist = rentalService.overSearchAll();
	  model.addAttribute("overuserlist", overuserlist);
    return "user/oversearch";
  }





//編集画面を表示
  @GetMapping("/rental/{id}/edit")
  public String rentalEdit(@PathVariable Long id, Model model) {
      Rental rental = rentalService.rentalFindById(id);
      RentalUpdateRequest rentalUpdateRequest = new RentalUpdateRequest();
      rentalUpdateRequest.setId(rental.getId());
      rentalUpdateRequest.setId(rental.getId());
      rentalUpdateRequest.setName(rental.getName());
      rentalUpdateRequest.setPname(rental.getPname());


      model.addAttribute("rentalUpdateRequest", rentalUpdateRequest);
      return "rental/edit";
  }

  @RequestMapping(value = "/rental/update", method = RequestMethod.POST)
  public String update(@Validated @ModelAttribute RentalUpdateRequest rentalUpdateRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {
          List<String> errorList = new ArrayList<String>();
          for (ObjectError error : result.getAllErrors()) {
              errorList.add(error.getDefaultMessage());
          }
          model.addAttribute("validationError", errorList);
          return "rental/edit";
      }
      // ユーザー情報の更新
      rentalService.rentalUpdate(rentalUpdateRequest);
      return "redirect:/user/menyu";
  }


  }

