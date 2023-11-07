package com.vti.kshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccessoryDto {
    private Long id;
    private String name;
    private String price;
    private String statusDamaged;
    private String repairStatus;
    // Dùng model mapper lấy thuộc tính
    @JsonProperty("licensePlate")//Đổi tên
    private String carPkLicensePlate;
    @JsonProperty("repairDate")
    private LocalDate carPkRepairDate;

}
