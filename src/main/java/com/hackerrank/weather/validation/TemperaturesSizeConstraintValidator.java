package com.hackerrank.weather.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class TemperaturesSizeConstraintValidator implements ConstraintValidator<TemperaturesSizeConstraint, List<Double>> {
    @Override
    public boolean isValid(List<Double> values, ConstraintValidatorContext context) {
        return values.size() == 24;
    }
}
