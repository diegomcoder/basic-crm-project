package com.diegomd.basiccrmproject;

import com.diegomd.basiccrmproject.domain.entities.ClientBuilder;
import com.diegomd.basiccrmproject.shared.enums.Genders;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class ClientBuilderTest {

    ClientBuilder clientBuilderNoArgs;
    ClientBuilder clientBuilderFull;
    ClientBuilder clientBuilderWithIdentification;
    ClientBuilder clientBuilderWithContactInfo;

    @Before
    public void setUp() {
        clientBuilderNoArgs = new ClientBuilder();

        clientBuilderFull = new ClientBuilder("Marie", "Carey", "Jones",
                "789.678.543-21", "marie.carey27@fakemail.com", "22/05/1998",
                Genders.F, "1560 Pennsylvania Avenue", "(970) 884-8728");

        clientBuilderWithIdentification = new ClientBuilder().withIdentification("David","Osborne",
                "Junior", "123.456.789-10", "13/08/1987",Genders.M);

        clientBuilderWithContactInfo = new ClientBuilder().withContactInfo("davidosborne@some.com",
                "States avn 127st", "(62) 233 4567");
    }

    @Test
    public void testSetFirstName() {
        clientBuilderNoArgs.setFirstName("Clara");
        Assertions.assertEquals("Clara", clientBuilderNoArgs.getFirstName());

        clientBuilderFull.setFirstName("Andre");
        Assert.assertEquals("Andre", clientBuilderFull.getFirstName());
    }

    @Test
    public void testSetMiddleName() {
        clientBuilderNoArgs.setFirstName("Clara");
        clientBuilderNoArgs.setMiddleName("Antunes");
        Assertions.assertEquals("Antunes", clientBuilderNoArgs.getMiddleName());
    }

    @Test
    public void testSetLastName() {
        clientBuilderNoArgs.setFirstName("Clara");
        clientBuilderNoArgs.setLastName("Borges");
        Assertions.assertEquals("Borges", clientBuilderNoArgs.getLastName());
    }

    @Test
    public void testGetFullName() {
        clientBuilderNoArgs.setFirstName("Alex");
        clientBuilderNoArgs.setLastName("Marcus");
        Assertions.assertEquals("Alex Marcus", clientBuilderNoArgs.getFullName());
    }

    @Test
    public void testGetCpf() {
        Assertions.assertNull(clientBuilderNoArgs.getCpf());
        Assertions.assertEquals("789.678.543-21", clientBuilderFull.getCpf());
        Assertions.assertEquals("123.456.789-10", clientBuilderWithIdentification.getCpf());
        Assertions.assertNull(clientBuilderWithContactInfo.getCpf());
    }

    @Test
    public void testSetCpf() {
        clientBuilderNoArgs.setCpf("101.010.101-01");
        Assertions.assertEquals("101.010.101-01", clientBuilderNoArgs.getCpf());

        clientBuilderFull.setCpf("987.654.321-23");
        Assertions.assertEquals("987.654.321-23", clientBuilderFull.getCpf());

        clientBuilderWithIdentification.setCpf("345.678.999-11");
        Assertions.assertEquals("345.678.999-11", clientBuilderWithIdentification.getCpf());

        clientBuilderWithContactInfo.setCpf("140.160.234-80");
        Assertions.assertEquals("140.160.234-80", clientBuilderWithContactInfo.getCpf());
    }

    @Test
    public void testGetGenderTreatment() {
        Assertions.assertEquals("", clientBuilderNoArgs.getGenderTreatment());
        Assertions.assertEquals("Mrs.", clientBuilderFull.getGenderTreatment());
        Assertions.assertEquals("Mr.", clientBuilderWithIdentification.getGenderTreatment());
        Assertions.assertEquals("", clientBuilderWithContactInfo.getGenderTreatment());
    }

    @Test
    public void testGetEmail() {
        Assertions.assertNull(clientBuilderNoArgs.getEmail());
        Assertions.assertEquals("marie.carey27@fakemail.com", clientBuilderFull.getEmail());
        Assertions.assertNull(clientBuilderWithIdentification.getEmail());
        Assertions.assertEquals("davidosborne@some.com", clientBuilderWithContactInfo.getEmail());
    }

    @Test
    public void testSetEmail() {
        clientBuilderNoArgs.setEmail("noargs.cb@fakemail.com");
        Assertions.assertEquals("noargs.cb@fakemail.com", clientBuilderNoArgs.getEmail());

        clientBuilderFull.setEmail("full.cb@fakemail.com");
        Assertions.assertEquals("full.cb@fakemail.com", clientBuilderFull.getEmail());

        clientBuilderWithIdentification.setEmail("identification.cb@fakemail.com");
        Assertions.assertEquals("identification.cb@fakemail.com", clientBuilderWithIdentification.getEmail());

        clientBuilderWithContactInfo.setEmail("contact.cb@fakemail.com");
        Assertions.assertEquals("contact.cb@fakemail.com", clientBuilderWithContactInfo.getEmail());
    }

    @Test
    public void testGetPhoneNumber() {
        Assertions.assertNull(clientBuilderNoArgs.getPhoneNumber());
        Assertions.assertEquals("(970) 884-8728", clientBuilderFull.getPhoneNumber());
        Assertions.assertNull(clientBuilderWithIdentification.getPhoneNumber());
        Assertions.assertEquals("(62) 233 4567", clientBuilderWithContactInfo.getPhoneNumber());
    }

    @Test
    public void testSetPhoneNumber() {
        clientBuilderNoArgs.setPhoneNumber("(52) 436 34567");
        Assertions.assertEquals("(52) 436 34567", clientBuilderNoArgs.getPhoneNumber());

        clientBuilderFull.setPhoneNumber("(14) 863 2345 23423");
        Assertions.assertEquals("(14) 863 2345 23423", clientBuilderFull.getPhoneNumber());

        clientBuilderWithIdentification.setPhoneNumber("(55) 98227 8903");
        Assertions.assertEquals("(55) 98227 8903", clientBuilderWithIdentification.getPhoneNumber());

        clientBuilderWithContactInfo.setPhoneNumber(null);
        Assertions.assertNull(clientBuilderWithContactInfo.getPhoneNumber());
    }

    @Test
    public void testGetAge() {
        clientBuilderNoArgs.setDateOfBirth("02/01/2004");
        Assertions.assertEquals(19, clientBuilderNoArgs.getAge());

        Assertions.assertEquals(25, clientBuilderFull.getAge());
        Assertions.assertEquals(36, clientBuilderWithIdentification.getAge());

        clientBuilderWithContactInfo.setDateOfBirth("15/11/1954");
        Assertions.assertEquals(69, clientBuilderWithContactInfo.getAge());
    }

    @Test
    public void testGetDateOfBirth() {
        Assertions.assertNull(clientBuilderNoArgs.getDateOfBirth());
        Assertions.assertEquals("22/05/1998", clientBuilderFull.getDateOfBirth());
        Assertions.assertEquals("13/08/1987", clientBuilderWithIdentification.getDateOfBirth());
        Assertions.assertNull(clientBuilderWithContactInfo.getDateOfBirth());
    }

    @Test
    public void testSetDateOfBirth() {
        clientBuilderNoArgs.setDateOfBirth("28/12/1995");
        Assertions.assertEquals("28/12/1995", clientBuilderNoArgs.getDateOfBirth());

        clientBuilderFull.setDateOfBirth("14/07/1987");
        Assertions.assertEquals("14/07/1987", clientBuilderFull.getDateOfBirth());

        clientBuilderWithIdentification.setDateOfBirth("03/11/2005");
        Assertions.assertEquals("03/11/2005", clientBuilderWithIdentification.getDateOfBirth());

        clientBuilderWithContactInfo.setDateOfBirth("12/04/1948");
        Assertions.assertEquals("12/04/1948", clientBuilderWithContactInfo.getDateOfBirth());
    }

    @Test
    public void testGetAddress() {
        Assertions.assertNull(clientBuilderNoArgs.getAddress());
        Assertions.assertEquals("1560 Pennsylvania Avenue", clientBuilderFull.getAddress());
        Assertions.assertNull(clientBuilderWithIdentification.getAddress());
        Assertions.assertEquals("States avn 127st", clientBuilderWithContactInfo.getAddress());
    }

    @Test
    public void testSetAddress() {
        clientBuilderNoArgs.setAddress("1974 Maple Lane");
        Assertions.assertEquals("1974 Maple Lane", clientBuilderNoArgs.getAddress());

        clientBuilderFull.setAddress("2634 Mayo Street");
        Assertions.assertEquals("2634 Mayo Street", clientBuilderFull.getAddress());

        clientBuilderWithIdentification.setAddress("3650 Hickman Street");
        Assertions.assertEquals("3650 Hickman Street", clientBuilderWithIdentification.getAddress());

        clientBuilderWithContactInfo.setAddress("4458 Tully Street");
        Assertions.assertEquals("4458 Tully Street", clientBuilderWithContactInfo.getAddress());
    }

    @Test
    public void testExceptionThrowing() {
        IllegalArgumentException thrown1 = assertThrows(
                IllegalArgumentException.class,
                () -> clientBuilderNoArgs.setFirstName(null)
        );
        Assertions.assertTrue(thrown1.getMessage().contains("First name can't be empty or null"));

        IllegalArgumentException thrown2 = assertThrows(
                IllegalArgumentException.class,
                () -> clientBuilderNoArgs.getAge()
        );
        Assertions.assertTrue(thrown2.getMessage().contains("Date of birth can't be null"));
    }

    @After
    public void tearDown() {
        clientBuilderNoArgs = null;
        clientBuilderFull = null;
        clientBuilderWithIdentification = null;
        clientBuilderWithContactInfo = null;

    }
}