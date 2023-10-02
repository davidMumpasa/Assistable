package com.example.assistable.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    private Integer id;
    private String firstname;
    private String lastname;

    private String emails;

    private String password;
    private String confirmPassWord;
    private String IdNumber;
    private String gender;
    private boolean isProvider;
    private boolean isCustomer;
    private String citizenship;

    private String dob;


//    private String faceFeatures;

    public UserEntity() {
    }


//

    public UserEntity(Integer id,
                String firstname,
                String lastname,
                String emails,
                String password,
                String confirmPassWord,
                String homeAddress,
                String idNumber,
                String gender,
                boolean isDriver,
                boolean isCustomer,
                String citizenship,
                      String dob)
    {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emails = emails;
        this.password = password;
        this.confirmPassWord = confirmPassWord;
        this.dob = dob;
        this.IdNumber = idNumber;
        this.gender = gender;
        this.isProvider = isDriver;
        this.isCustomer = isCustomer;
        this.citizenship = citizenship;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassWord() {
        return confirmPassWord;
    }

    public void setConfirmPassWord(String confirmPassWord) {
        this.confirmPassWord = confirmPassWord;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {

        this.gender = gender;
    }

    public boolean isProvider() {

        return isProvider;
    }

    public void setProvider(boolean driver) {
        isProvider = driver;
    }

    public boolean isCustomer() {
        return isCustomer;
    }

    public void setCustomer(boolean customer) {
        isCustomer = customer;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getIdNumber() {
        return IdNumber;
    }

    public void setIdNumber(String idNumber) {

        IdNumber = idNumber;
    }
}
