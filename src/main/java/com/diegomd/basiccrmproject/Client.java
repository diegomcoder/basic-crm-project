package com.diegomd.basiccrmproject;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Client {
    private final UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private final String fullName;
    private long cpf;
    private long phoneNumber;
    private int age;
    private String dateOfBirth;
    private String address;
    private Genders gender;

    public Client(String firstName, String middleName, String lastName, long cpf,
                  long phoneNumber, int age, String dateOfBirth, String address, Genders gender) {
        id = UUID.randomUUID();
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        fullName = this.firstName + this.middleName + this.lastName;
        setCpf(cpf);
        setPhoneNumber(phoneNumber);
        setAge(age);
        setDateOfBirth(dateOfBirth);
        setAddress(address);
        setGender(gender);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", surname='" + lastName + '\'' +
                ", cpf=" + cpf +
                ", phoneNumber=" + phoneNumber +
                ", age=" + age +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}
