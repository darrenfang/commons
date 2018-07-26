package com.darrenfang.commons.validation.validators;

import com.darrenfang.commons.validation.constraints.NotEqualsTo;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

public class NotEqualsToValidator implements ConstraintValidator<NotEqualsTo, Object> {

    private String fieldName;
    private String dependFieldName;

    @Override
    public void initialize(NotEqualsTo constraintAnnotation) {
        this.fieldName = constraintAnnotation.filedName();
        this.dependFieldName = constraintAnnotation.dependFieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        try {
            String fieldValue = BeanUtils.getProperty(value, fieldName);
            String dependFieldValue = BeanUtils.getProperty(value, dependFieldName);
            if (fieldValue != null) {
                return !fieldValue.equals(dependFieldValue);
            } else {
                return dependFieldValue != null;
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
