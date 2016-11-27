package com.parkhomenko.validation;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Dmytro Parkhomenko
 *         Created on 27.11.16.
 */

public class CommentEntity {

    @NotBlank
    private String text;

    @Phone
    private String phone;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
