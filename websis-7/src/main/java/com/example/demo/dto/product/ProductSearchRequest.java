package com.example.demo.dto.product;
import java.io.Serializable;

import lombok.Data;
/**
 * 商品情報 リクエストデータ
 */
@Data
public class ProductSearchRequest implements Serializable {
  /**
   * 商品ID
   */

	  private Long id;
  private String name;
}
