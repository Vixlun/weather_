package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    List<Weather> findAllByOrderByIdAsc();
    List<Weather> findByDate(Date date);
    List<Weather> findByCityInIgnoreCase(List<String> city);
    List<Weather>  findAllByOrderByDateAsc();
    List<Weather>  findAllByOrderByDateDesc();
}
