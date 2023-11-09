package com.diegomd.basiccrmproject;

import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Getter
public class ClientBuilder {
    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private long cpf;
    private String email;
    private String dateOfBirth;
    private int age;
    private Genders gender;
    private String address;
    private String phoneNumber;

    public ClientBuilder withIdentification(String firstName, String middleName, String lastName, long cpf, String dateOfBirth, Genders gender) {
        id = UUID.randomUUID();
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setFullName();
        setCpf(cpf);
        setDateOfBirth(dateOfBirth);
        setAge();
        setGender(gender);
        return this;
    }

    public ClientBuilder withContactInfo(String email, String address, String phoneNumber) {
        setEmail(email);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        return this;
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

    private void setFullName() { this.fullName = this.firstName + " " + this.middleName + " " + this.lastName; }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) { this.email = email; }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private void setAge() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(this.dateOfBirth, dateFormat);
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears();
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
        return "\nClient {" +
                "\n\tid = " + id +
                "\n\tfullName = " + fullName +
                "\n\tfirstName = '" + firstName + '\'' +
                "\n\tmiddleName = '" + middleName + '\'' +
                "\n\tsurname = '" + lastName + '\'' +
                "\n\tcpf = " + cpf +
                "\n\tage = " + age +
                "\n\tdateOfBirth = '" + dateOfBirth + '\'' +
                "\n\tgender = " + gender +
                "\n\taddress = '" + address + '\'' +
                "\n\tphoneNumber = " + phoneNumber +
                "\n\temail = " + email +
                "\n}";
    }

    public String toStringPersonalData() {
        return "\nClient {" +
                "\n\tid = " + id +
                "\n\tfullName = " + fullName +
                "\n\tcpf = " + cpf +
                "\n\tage = " + age +
                "\n\tdateOfBirth = '" + dateOfBirth + '\'' +
                "\n\tgender = " + gender +
                "\n}";
    }

    public String toStringContactInfo() {
        return "\nClient {" +
                "\n\tid = " + id +
                "\n\taddress = '" + address + '\'' +
                "\n\tphoneNumber = " + phoneNumber +
                "\n\temail = " + email +
                "\n}";
    }
}
