package com.packt.cardatabase.domain;

import com.packt.cardatabase.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car,Long> {

    ///Fetch card by brand
    List<Car> findByBrand(String brand);

    //Fetch cars by color
    List<Car> findByColor(String color);

    //Fetch cars by year
    List<Car> findByYear(int year);

    //Fetch car by brand and model
    List<Car> findByBrandOrModel(String brand, String model);

    //Fetch car by brand and color
    List<Car> findByBrandOrColor(String brand, String color);

    //Fetch cars by brand and sort by year
    List<Car> findByBrandOrderByYearAsc(String brand);

    //Fetch cars by brand using SQL
  /*  @Query("select c from Car c where c.brand = ?1")
    List<Car> findByBrands(String brand);*/

    //Fetch cars by brand using SQL
    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndsWith(String brand);

}
