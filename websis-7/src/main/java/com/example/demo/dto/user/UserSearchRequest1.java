package com.example.demo.dto.user;
import java.io.Serializable;

import lombok.Data;
/**
 * ユーザー情報 検索用リクエストデータ
 */
@Data
public class UserSearchRequest1 implements Serializable {
  /**
   * ユーザーID
   */


  private String name;
  private Long id;
}