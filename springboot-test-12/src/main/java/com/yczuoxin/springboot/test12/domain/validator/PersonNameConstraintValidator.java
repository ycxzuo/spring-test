package com.yczuoxin.springboot.test12.domain.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PersonNameConstraintValidator implements ConstraintValidator<PersonNamePrefix, String> {

    private String prefix;

    @Override
    public void initialize(PersonNamePrefix constraintAnnotation) {
        this.prefix = constraintAnnotation.prefix();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!value.startsWith(prefix)) {
            context.disableDefaultConstraintViolation();
            ConstraintValidatorContext.ConstraintViolationBuilder builder = context.buildConstraintViolationWithTemplate(
                    "必须用 {prefix} 开头");
            builder.addConstraintViolation();

            return false;
        }
        return true;
    }
}
