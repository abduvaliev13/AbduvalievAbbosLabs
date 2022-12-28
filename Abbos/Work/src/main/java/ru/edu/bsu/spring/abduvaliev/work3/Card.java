package ru.edu.bsu.spring.abduvaliev.work3;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CardValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Card {
    String message() default "Card type should be DEBIT or CREDIT";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}