package com.yczuoxin.springboot.test12.domain.validator;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = PersonNameConstraintValidator.class)
public @interface PersonNamePrefix {

    String message() default "{person.validator.prefix.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	String prefix() default "casstime-";
}
