package com.hackerrank.weather.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = TemperaturesSizeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface TemperaturesSizeConstraint {
    String message() default "The temperatures list must contains 24 values";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
