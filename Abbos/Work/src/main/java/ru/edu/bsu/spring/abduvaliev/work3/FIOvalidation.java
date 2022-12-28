package ru.edu.bsu.spring.abduvaliev.work3;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FIOvalidation implements ConstraintValidator<FIO, String> {

    @Override
    public boolean isValid(String fio, ConstraintValidatorContext context) {
        String[] str = fio.split(" ");
        return (str.length >= 2 && str.length <= 3)
                && Character.isUpperCase(str[0].charAt(0))
                && Character.isUpperCase(str[1].charAt(0))
                && (str.length <= 2 || Character.isUpperCase(str[2].charAt(0)));
    }
}