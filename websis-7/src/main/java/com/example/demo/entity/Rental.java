package com.example.demo.entity;
import java.util.Date;

import lombok.Data;


@Data
public class Rental {

   private Long id;
   /**
    * 	レンタルid
    */
   private String name;
   /**
    * 商品名
    */
   private String address;
   /**
    * 電話番号
    */
   private String phone;


   private String pname;
   /**
    *　顧客名
    */
   private Date updateDate;
   /**
    * 登録日時
    */


   private int num;
   /**
    * 削除日時
    */
   private Date deleteDate;
}