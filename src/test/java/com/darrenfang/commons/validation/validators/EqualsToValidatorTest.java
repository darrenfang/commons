package com.darrenfang.commons.validation.validators;

import org.junit.Before;
import org.junit.Test;

import javax.validation.*;
import java.util.Locale;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EqualsToValidatorTest {

    private static final Locale defaultLocale = Locale.getDefault();

    private static Validator validator;
    private static Validator chineseValidator;

    @Before
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
        RegisterUser registerUser = new RegisterUser("password", "password");
        Set<ConstraintViolation<RegisterUser>> violations = validator.validate(registerUser);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testPasswordIsEmpty() {
        RegisterUser registerUser = new RegisterUser("", "password");
        Set<ConstraintViolation<RegisterUser>> violations = validator.validate(registerUser);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    public void testConfirmPasswordIsEmpty() {
        RegisterUser registerUser = new RegisterUser("password", "");
        Set<ConstraintViolation<RegisterUser>> violations = validator.validate(registerUser);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    public void testNotEquals() {
        RegisterUser registerUser = new RegisterUser("password", "confirmPassword");
        Set<ConstraintViolation<RegisterUser>> violations = validator.validate(registerUser);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    public void testDefaultMessage() {

        Locale.setDefault(Locale.US);

        RegisterUser registerUser = new RegisterUser("password", "confirmPassword");
        Set<ConstraintViolation<RegisterUser>> violations = validator.validate(registerUser);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        ConstraintViolation<RegisterUser> violation = violations.iterator().next();
        assertEquals("The value of field 'confirmPassword' is not equals to the value of field 'password'.", violation.getMessage());

        Locale.setDefault(defaultLocale);
    }

    @Test
    public void testChineseMessage() {
        Locale.setDefault(Locale.SIMPLIFIED_CHINESE);

        RegisterUser registerUser = new RegisterUser("password", "confirmPassword");
        Set<ConstraintViolation<RegisterUser>> violations = chineseValidator.validate(registerUser);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        ConstraintViolation<RegisterUser> violation = violations.iterator().next();
        assertEquals("字段 “confirmPassword” 的值和字段 “password” 的值不同。", violation.getMessage());

        Locale.setDefault(defaultLocale);
    }

}
