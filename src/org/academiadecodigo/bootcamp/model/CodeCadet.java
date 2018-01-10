package org.academiadecodigo.bootcamp.model;

import java.util.Date;

public class CodeCadet {
    private String name;
    private User user;
    private Gender gender;
    private String adress;
    private String city;
    private String phone;
    private Bootcamp bootcamp;
    private Date birthdate;

    public CodeCadet(String name,User user, Gender gender, String adress, String city, String phone, Bootcamp bootcamp, Date birthdate){
        this.name = name;
        this.user = user;
        this.gender = gender;
        this.gender = gender;
        this.adress = adress;
        this.phone = phone;
        this.bootcamp = bootcamp;
        this.birthdate = birthdate;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeCadet codeCadet = (CodeCadet) o;

        return user != null ? user.equals(codeCadet.user) : codeCadet.user == null;
    }

    @Override
    public int hashCode() {
        return user != null ? user.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CodeCadet{" +
                "user=" + user +
                ", gender=" + gender +
                ", adress='" + adress + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", bootcamp=" + bootcamp +
                ", birthdate=" + birthdate +
                '}';
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public Gender getGender() {
        return gender;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public Date getBirthdate() {
        return birthdate;
    }
}
