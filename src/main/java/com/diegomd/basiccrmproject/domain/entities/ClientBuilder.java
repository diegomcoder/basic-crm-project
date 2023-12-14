package com.diegomd.basiccrmproject.domain.entities;

import com.diegomd.basiccrmproject.shared.enums.Genders;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClientBuilder {
    private String firstName;
    private String middleName;
    private String lastName;
    private String cpf;
    private String email;
    private String dateOfBirth;
    private Genders gender;
    private String address;
    private String phoneNumber;

    public ClientBuilder withIdentification(String firstName, String middleName, String lastName, String cpf, String dateOfBirth, Genders gender) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setCpf(cpf);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
        return this;
    }

    public ClientBuilder withContactInfo(String email, String address, String phoneNumber) {
        setEmail(email);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        return this;
    }

    public String getFullName() {
        if (firstName == null)
            throw new IllegalArgumentException("First name can't be null");
        String fullName = firstName;
        if (middleName != null)
            fullName += " " + middleName;
        if (lastName != null)
            fullName += " " + lastName;
        return fullName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("First name can't be empty or null");
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        if (firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("First name can't be empty or null");
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        if (firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("First name can't be empty or null");
        this.lastName = lastName;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenderTreatment() {
        if (gender == Genders.F)
            return "Mrs.";
        if (gender == Genders.M)
            return "Mr.";
        return "";
    }

    public void setEmail(String email) { this.email = email; }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        if (this.dateOfBirth == null)
            throw new IllegalArgumentException("Date of birth can't be null.");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(this.dateOfBirth, dateFormat);
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
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

    public String toStringPersonalData() {
        return "\nClient {" +
                "\n\tfirstName = " + firstName +
                "\n\tmiddleName = " + middleName +
                "\n\tlastName = " + lastName +
                "\n\tcpf = " + cpf +
                "\n\tage = " + getAge() +
                "\n\tdateOfBirth = '" + dateOfBirth + '\'' +
                "\n\tgender = " + gender +
                "\n}";
    }

    public String toStringContactInfo() {
        return "\nClient {" +
                "\n\taddress = '" + address + '\'' +
                "\n\tphoneNumber = " + phoneNumber +
                "\n\temail = " + email +
                "\n}";
    }
}
