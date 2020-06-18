package com.rzhe.max.airlines.utils;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AirportCodeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AirportCodeConstraint {
    String pattern();
    String message() default "Invalid airport code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
