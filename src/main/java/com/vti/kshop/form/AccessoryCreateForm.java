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

public class AccessoryCreateForm {
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

    //Map sang khóa chính pk của car
    //2 Thuộc tính này tạo thành khóa pk của car, sau đó dùng findById để tìm xem có xe đó không
    @NotBlank
    @Length(max = 255)
    private String licensePlate;
    @NotNull
    @PastOrPresent
    private LocalDate repairDate;

}
