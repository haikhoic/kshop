package com.vti.kshop.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "car")
public class Car {
    @EmbeddedId
    private PrimaryKey pk; //Tạo khóa chính từ nhiều cột

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "catalog", nullable = false)
    private String catalog;

    @Column(name = "car_maker", nullable = false)
    private String carMaker;

    @OneToMany(mappedBy = "car") //Liên kết 1 nhiều
    private List<Accessory> accesories; //Một xe có nhiều Accessory

    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    public static class PrimaryKey // Khóa chính này tạo từ 2 cột
            implements Serializable {
        @Column(name = "license_plate")
        private String licensePlate;
        @Column(name = "repair_date")
        private LocalDate repairDate;
    }
}
