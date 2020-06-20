package com.rzhe.max.airlines.validation.crewman;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class CrewManBirthDateValidator implements ConstraintValidator<CrewManBirthDateConstraint, LocalDate> {
    private String pattern;

    @Override
    public void initialize(CrewManBirthDateConstraint constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {


        return false;
    }


}
