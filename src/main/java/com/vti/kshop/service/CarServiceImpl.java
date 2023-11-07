package com.vti.kshop.service;


import com.vti.kshop.dto.CarDto;
import com.vti.kshop.entity.Car;
import com.vti.kshop.form.CarCreateForm;
import com.vti.kshop.form.CarUpdateForm;
import com.vti.kshop.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor //Tạo tất cả constructor
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    @Override
    public CarDto create(CarCreateForm form) {
        var car = modelMapper.map(form, Car.class);
        var pk = modelMapper.map(form,Car.PrimaryKey.class);// Map 2 thuộc tính còn lại
        car.setPk(pk);
        var savedCar=carRepository.save(car);
        return modelMapper.map(savedCar,CarDto.class);
    }

    @Override
    public Page<CarDto> findAll(Pageable pageable) {
        return carRepository.findAll(pageable)
        .map(car->modelMapper.map(car,CarDto.class));
    }

    @Override
    public CarDto update(CarUpdateForm form) {
        var pk=modelMapper.map(form,Car.PrimaryKey.class);
        var car = carRepository.findById(pk).get();
        modelMapper.map(form,car);
        var savedCar=carRepository.save(car);
        return modelMapper.map(savedCar, CarDto.class);
    }

    @Override
    public void deleteById(Car.PrimaryKey pk) {
        carRepository.deleteById(pk);
    }
}
