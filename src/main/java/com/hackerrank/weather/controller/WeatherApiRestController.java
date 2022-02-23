package com.hackerrank.weather.controller;

import com.hackerrank.weather.converter.SortEnum;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class WeatherApiRestController {

    @Autowired
    private WeatherRepository repository;

    @GetMapping("weather/{id}")
    public ResponseEntity<Weather> getWeather(@PathVariable Integer id) {
        Optional<Weather> result = repository.findById(id);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/weather")
    public List<Weather> getWeatherWithDate(@RequestParam(name = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                            @RequestParam(name = "city", required = false) List<String> city,
                                            @RequestParam(name = "sort", required = false) SortEnum sort) {
        if(date != null) {
            return repository.findByDate(date);
        } else if(city != null) {
            return repository.findByCityInIgnoreCase(city);
        } else if(sort == SortEnum.asc) {
            return repository.findAllByOrderByDateAsc();
        } else if(sort == SortEnum.desc) {
            return repository.findAllByOrderByDateDesc();
        }
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping("weather")
    @ResponseStatus(HttpStatus.CREATED)
    public Weather createWeatherRecord(@RequestBody Weather weather) {
        return repository.save(weather);
    }



}
