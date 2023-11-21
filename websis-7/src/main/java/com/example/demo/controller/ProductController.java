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

import com.example.demo.dto.product.ProductAddRequest;
import com.example.demo.dto.product.ProductSearchRequest;
import com.example.demo.dto.product.ProductUpdateRequest;
import com.example.demo.dto.user.UserUpdateRequest;
import com.example.demo.entity.Syouhin1;
import com.example.demo.service.product.ProductService;


@Controller

public class ProductController {

  @Autowired
  ProductService productService;

//新規商品登録画面を表示
  @GetMapping(value = "/product/add")
  public String productAdd(Model model) {
      model.addAttribute("productAddRequest", new ProductAddRequest());
      return "product/add";
  }

  //登録
  @RequestMapping(value = "/product/create", method = RequestMethod.POST)
  public String productCreate(@Validated @ModelAttribute ProductAddRequest productRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {
          // 入力チェックエラーの場合
          List<String> errorList = new ArrayList<String>();
          for (ObjectError error : result.getAllErrors()) {
              errorList.add(error.getDefaultMessage());
          }
          model.addAttribute("validationError", errorList);
          return "user/add";
      }
      // 商品情報の登録
      productService.productSave(productRequest);
      return "redirect:/product/menyu";
  }

//商品検索画面を表示
  @GetMapping(value = "/product/search")
  public String displaySearch1(Model model) {
    return "product/search";
  }


  //商品検索
  @RequestMapping(value = "/product/id_search", method = RequestMethod.POST)
  public String productSearch(@ModelAttribute ProductSearchRequest productSearchRequest, Model model) {
	  List<Syouhin1> product = productService.productSearch(productSearchRequest);
	    model.addAttribute("product", product);
	    return "product/search";
	  }



//rentalranking画面を表示
  @GetMapping(value = "/rental/ranking")
  public String rentalRanking(Model model) {
	  List<Syouhin1> rankinglist = productService.rentalRanking();
	  for (Syouhin1 item : rankinglist) {
          double rentalRate = (double) item.getRentalnum() / (item.getNum() + item.getRentalnum());
          item.setRentalRate(rentalRate);
      }
	  model.addAttribute("rankinglist", rankinglist);
    return "rental/ranking";
  }



  //在庫商品一覧画面を表示
  @GetMapping(value = "/product/menyu")
  public String productMenyu(Model model) {
	  List<Syouhin1> productlist = productService.productSearchAll();
	  model.addAttribute("productlist", productlist);
    return "product/menyu";
  }

  @GetMapping("/product/{id}/delete")
  public String productDelete(@PathVariable Long id, Model model) {
      //商品情報の削除
      productService.productDelete(id);
      return "redirect:/product/menyu";
  }
//編集画面を表示
  @GetMapping("/product/{id}/edit")
  public String productEdit(@PathVariable Long id, Model model) {
      Syouhin1 product = productService.productFindById(id);
      ProductUpdateRequest productUpdateRequest = new ProductUpdateRequest();
      productUpdateRequest.setId(product.getId());
      productUpdateRequest.setId(product.getId());
      productUpdateRequest.setName(product.getName());
      productUpdateRequest.setNum(product.getNum());



      model.addAttribute("productUpdateRequest", productUpdateRequest);
      return "user/edit";
  }

  @RequestMapping(value = "/product/update", method = RequestMethod.POST)
  public String update(@Validated @ModelAttribute ProductUpdateRequest productUpdateRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {
          List<String> errorList = new ArrayList<String>();
          for (ObjectError error : result.getAllErrors()) {
              errorList.add(error.getDefaultMessage());
          }
          model.addAttribute("validationError", errorList);
          return "product/edit";
      }
      // ユーザー情報の更新
      productService.productUpdate(productUpdateRequest);
      return "redirect:/product/menyu";
  }
  @GetMapping(value = "/product/edit")
  public String userUpdate(Model model) {
      model.addAttribute("userUpdateRequest", new UserUpdateRequest());
      return "product/edit";
  }

};
