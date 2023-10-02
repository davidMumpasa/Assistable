package com.example.assistable.models;

import jakarta.persistence.Entity;

import java.util.List;

public class User {

    private String status;
    private IdProfile idProfile;

    private String errorMessage;

    public User() {

    }
    public User(String status,IdProfile idProfile) {
        this.idProfile = idProfile;
        this.status = status;
    }


    //getters and setters


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public IdProfile getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(IdProfile idProfile) {
        this.idProfile = idProfile;
    }


    public static class IdProfile {
        private int traceId;
        private String idNumber;
        private String firstNames;
        private String surName;
        private String dob;
        private int age;
        private String gender;
        private String citizenship;
        private String status;
        private String dateOfIssue;
        private List<String> deathDate;
        private String deathPlace;

        // Getters and setters


        public int getTraceId() {
            return traceId;
        }

        public void setTraceId(int traceId) {
            this.traceId = traceId;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        public String getFirstNames() {
            return firstNames;
        }

        public void setFirstNames(String firstNames) {
            this.firstNames = firstNames;
        }

        public String getSurName() {
            return surName;
        }

        public void setSurName(String surName) {
            this.surName = surName;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getCitizenship() {
            return citizenship;
        }

        public void setCitizenship(String citizenship) {
            this.citizenship = citizenship;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDateOfIssue() {
            return dateOfIssue;
        }

        public void setDateOfIssue(String dateOfIssue) {
            this.dateOfIssue = dateOfIssue;
        }

        public List<String> getDeathDate() {
            return deathDate;
        }

        public void setDeathDate(List<String> deathDate) {
            this.deathDate = deathDate;
        }

        public String getDeathPlace() {
            return deathPlace;
        }

        public void setDeathPlace(String deathPlace) {
            this.deathPlace = deathPlace;
        }

        @Override
        public String toString() {
            return "IdProfile{" +
                    "traceId=" + traceId +
                    ", idNumber='" + idNumber + '\'' +
                    ", firstNames='" + firstNames + '\'' +
                    ", surName='" + surName + '\'' +
                    ", dob='" + dob + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    ", citizenship='" + citizenship + '\'' +
                    ", status='" + status + '\'' +
                    ", dateOfIssue='" + dateOfIssue + '\'' +
                    ", deathDate=" + deathDate +
                    ", deathPlace='" + deathPlace + '\'' +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "Person{" +
                "status='" + status + '\'' +
                ", idProfile=" + idProfile +
                '}';
    }
}
