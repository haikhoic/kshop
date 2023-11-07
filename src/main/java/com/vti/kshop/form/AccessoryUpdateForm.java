package com.vti.kshop.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
//Update Form không cần khóa pk của car
public class AccessoryUpdateForm {
    //Map sang accessory
    @NotBlank
    @Length(max = 255)
    private String name;
    @NotNull
    @PositiveOrZero
    private String price;
    @NotBlank
    @Length(max = 255)
    private String statusDamaged;
    @NotBlank
    @Length(max = 255)
    private String repairStatus;

}
