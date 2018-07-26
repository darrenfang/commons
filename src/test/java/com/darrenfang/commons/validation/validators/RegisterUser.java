package com.darrenfang.commons.validation.validators;

import com.darrenfang.commons.validation.constraints.EqualsTo;

@EqualsTo(filedName = "confirmPassword", dependFieldName = "password")
public class RegisterUser {

    public RegisterUser(String password, String confirmPassword) {
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    private String password;
    private String confirmPassword;

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
