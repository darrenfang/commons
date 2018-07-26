package com.darrenfang.commons.validation.constraints;

import com.darrenfang.commons.validation.validators.EqualsToValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EqualsToValidator.class)
@Documented
public @interface EqualsTo {

    String filedName();

    String dependFieldName();

    String message() default "{com.darrenfang.commons.validation.constraints.EqualsTo}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
