package com.diegomd.basiccrmproject;

import java.util.UUID;

public class Client {
    private UUID id;
    private String firstName;
    private String middleName;
    private String surname;
    private long cpf;
    private long phoneNumber;
    private int age;
    private String dateOfBirth;
    private String address;
    private Genders gender;

    public Client(String firstName, String middleName, String surname, long cpf,
                  long phoneNumber, int age, String dateOfBirth, String address, Genders gender) {
        id = UUID.randomUUID();
        setFirstName(firstName);
        setMiddleName(middleName);
        setSurname(surname);
        setCpf(cpf);
        setPhoneNumber(phoneNumber);
        setAge(age);
        setDateOfBirth(dateOfBirth);
        setAddress(address);
        setGender(gender);
    }
    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Genders getGender() {
        return gender;
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
                ", surname='" + surname + '\'' +
                ", cpf=" + cpf +
                ", phoneNumber=" + phoneNumber +
                ", age=" + age +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}
