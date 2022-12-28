package ru.edu.bsu.spring.abduvaliev.work3;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardValidation implements ConstraintValidator<Card, String> {

    @Override
    public boolean isValid(String type, ConstraintValidatorContext constraintValidatorContext) {
        return type.equals("DEBIT") || type.equals("CREDIT");
    }
}
