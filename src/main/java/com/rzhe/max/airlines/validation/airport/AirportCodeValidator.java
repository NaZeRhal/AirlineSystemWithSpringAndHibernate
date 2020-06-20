package com.rzhe.max.airlines.validation.airport;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AirportCodeValidator implements ConstraintValidator<AirportCodeConstraint, String> {
    private String pattern;

    public void initialize(AirportCodeConstraint constraint) {
        this.pattern = constraint.pattern();
    }

    public boolean isValid(String code, ConstraintValidatorContext context) {
        return code != null && code.matches(pattern);
    }
}
