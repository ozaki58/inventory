package com.example.demo.dto.rental;
import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 *rental情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RentalUpdateRequest extends RentalAddRequest implements Serializable {
    /**
     * ユーザーID
     */
    @NotNull
    private Long id;
}