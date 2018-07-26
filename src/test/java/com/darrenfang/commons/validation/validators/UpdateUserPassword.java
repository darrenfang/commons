package com.darrenfang.commons.validation.validators;

import com.darrenfang.commons.validation.constraints.NotEqualsTo;

@NotEqualsTo(filedName = "newPassword", dependFieldName = "oldPassword")
public class UpdateUserPassword {

    public UpdateUserPassword(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    private String oldPassword;
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
