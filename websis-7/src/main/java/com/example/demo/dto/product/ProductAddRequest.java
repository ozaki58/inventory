package com.example.demo.dto.product;
import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
/**
 * 商品情報登録 リクエストデータ
 */
@Data
public class ProductAddRequest implements Serializable {
    /**
     * 商品名
     */
    @NotEmpty(message = "商品名を入力してください")
    @Size(max = 100, message = "名前は100桁以内で入力してください")
    private String name;
    /**
     * 数
     */
    @Size(max = 255, message = "登録数を入力してください")
    private Long num;


}