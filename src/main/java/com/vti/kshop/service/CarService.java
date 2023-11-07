package com.vti.kshop.service;

import com.vti.kshop.dto.CarDto;
import com.vti.kshop.entity.Car;
import com.vti.kshop.form.CarCreateForm;
import com.vti.kshop.form.CarUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    CarDto create(CarCreateForm form);
    Page<CarDto> findAll(Pageable pageable);
    CarDto update(CarUpdateForm form);
    void deleteById(Car.PrimaryKey pk);
}
