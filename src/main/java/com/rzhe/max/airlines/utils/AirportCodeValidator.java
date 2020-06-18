package com.rzhe.max.airlines.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AirportCodeValidator implements ConstraintValidator<AirportCodeConstraint, String> {

   public void initialize(AirportCodeConstraint constraint) {
   }

   public boolean isValid(String code, ConstraintValidatorContext context) {

      return code != null && code.matches("[A-Z]") && code.length() <= 3;
   }
}
