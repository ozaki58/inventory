package com.example.demo.dto.product;
import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 商品情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductUpdateRequest extends ProductAddRequest implements Serializable {
    /**
     * ユーザーID
     */
    @NotNull
    private Long id;
}