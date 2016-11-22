package com.parkhomenko.enum_validation;

/**
 * @author Dmytro Parkhomenko
 *         Created on 26.10.16.
 */

public class UserInput {
    private String dateOfBirth;
    private String city;
    private boolean isUserValid;

    public boolean isUserValid() {
        return isUserValid;
    }

    public void setUserValid(boolean userValid) {
        isUserValid = userValid;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
