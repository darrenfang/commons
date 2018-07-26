package com.darrenfang.commons.validation.validators;

import org.junit.Before;
import org.junit.Test;

import javax.validation.*;
import java.util.Locale;
import java.util.Set;

import static org.junit.Assert.*;

public class NotEqualsToValidatorTest {

    private static final Locale defaultLocale = Locale.getDefault();

    private static Validator validator;
    private static Validator chineseValidator;

    @Before
    @SuppressWarnings("Duplicates")
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        MessageInterpolator interpolator = new LocalizedMessageInterpolator(Locale.US);
        validator = factory.usingContext().messageInterpolator(interpolator).getValidator();

        ValidatorFactory factory2 = Validation.buildDefaultValidatorFactory();
        MessageInterpolator interpolator2 = new LocalizedMessageInterpolator(Locale.SIMPLIFIED_CHINESE);
        chineseValidator = factory2.usingContext().messageInterpolator(interpolator2).getValidator();
    }

    @Test
    public void testSuccess() {
        UpdateUserPassword updateUserPassword = new UpdateUserPassword("oldPassword", "newPassword");
        Set<ConstraintViolation<UpdateUserPassword>> violations = validator.validate(updateUserPassword);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testOldPasswordIsEmpty() {
        UpdateUserPassword updateUserPassword = new UpdateUserPassword("", "password");
        Set<ConstraintViolation<UpdateUserPassword>> violations = validator.validate(updateUserPassword);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testNewPasswordIsEmpty() {
        UpdateUserPassword updateUserPassword = new UpdateUserPassword("password", "");
        Set<ConstraintViolation<UpdateUserPassword>> violations = validator.validate(updateUserPassword);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testEquals() {
        UpdateUserPassword updateUserPassword = new UpdateUserPassword("password", "password");
        Set<ConstraintViolation<UpdateUserPassword>> violations = validator.validate(updateUserPassword);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    public void testDefaultMessage() {

        Locale.setDefault(Locale.US);

        UpdateUserPassword updateUserPassword = new UpdateUserPassword("password", "password");
        Set<ConstraintViolation<UpdateUserPassword>> violations = validator.validate(updateUserPassword);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        ConstraintViolation<UpdateUserPassword> violation = violations.iterator().next();
        assertEquals("The value of field 'newPassword' is equals to the value of field 'oldPassword'.", violation.getMessage());

        Locale.setDefault(defaultLocale);
    }

    @Test
    public void testChineseMessage() {
        Locale.setDefault(Locale.SIMPLIFIED_CHINESE);

        UpdateUserPassword updateUserPassword = new UpdateUserPassword("password", "password");
        Set<ConstraintViolation<UpdateUserPassword>> violations = chineseValidator.validate(updateUserPassword);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        ConstraintViolation<UpdateUserPassword> violation = violations.iterator().next();
        assertEquals("字段 “newPassword” 的值和字段 “oldPassword” 的值相同。", violation.getMessage());

        Locale.setDefault(defaultLocale);
    }

}
