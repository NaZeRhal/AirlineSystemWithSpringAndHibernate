package com.rzhe.max.airlines.validation.crewman;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CrewManBirthDateValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CrewManBirthDateConstraint {
    String pattern();
    String message() default "Invalid crewman date of birth format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
