package com.diegomd.basiccrmproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientBuilderTest extends ClientBuilder {

    ClientBuilder clientBuilderNoArgs;
    ClientBuilder clientBuilderFull;
    ClientBuilder clientBuilderWithIdentification;
    ClientBuilder clientBuilderWithContactInfo;

    @BeforeEach
    void setUp() {
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
    void testSetFirstName() {
        clientBuilderNoArgs.setFirstName("Clara");
        assertEquals("Clara", clientBuilderNoArgs.getFirstName());

        clientBuilderFull.setFirstName("Andre");
        assertEquals("Andre", clientBuilderFull.getFirstName());
    }

    @Test
    void testSetMiddleName() {
        clientBuilderNoArgs.setFirstName("Clara");
        clientBuilderNoArgs.setMiddleName("Antunes");
        assertEquals("Antunes", clientBuilderNoArgs.getMiddleName());
    }

    @Test
    void testSetLastName() {
        clientBuilderNoArgs.setFirstName("Clara");
        clientBuilderNoArgs.setLastName("Borges");
        assertEquals("Borges", clientBuilderNoArgs.getLastName());
    }

    @Test
    void testGetFullName() {
        clientBuilderNoArgs.setFirstName("Alex");
        clientBuilderNoArgs.setLastName("Marcus");
        assertEquals("Alex Marcus", clientBuilderNoArgs.getFullName());
    }

    @Test
    void testGetCpf() {
        assertNull(clientBuilderNoArgs.getCpf());
        assertEquals("789.678.543-21", clientBuilderFull.getCpf());
        assertEquals("123.456.789-10", clientBuilderWithIdentification.getCpf());
        assertNull(clientBuilderWithContactInfo.getCpf());
    }

    @Test
    void testSetCpf() {
        clientBuilderNoArgs.setCpf("101.010.101-01");
        assertEquals("101.010.101-01", clientBuilderNoArgs.getCpf());

        clientBuilderFull.setCpf("987.654.321-23");
        assertEquals("987.654.321-23", clientBuilderFull.getCpf());

        clientBuilderWithIdentification.setCpf("345.678.999-11");
        assertEquals("345.678.999-11", clientBuilderWithIdentification.getCpf());

        clientBuilderWithContactInfo.setCpf("140.160.234-80");
        assertEquals("140.160.234-80", clientBuilderWithContactInfo.getCpf());
    }

    @Test
    void testGetGenderTreatment() {
        assertEquals("", clientBuilderNoArgs.getGenderTreatment());
        assertEquals("Mrs.", clientBuilderFull.getGenderTreatment());
        assertEquals("Mr.", clientBuilderWithIdentification.getGenderTreatment());
        assertEquals("", clientBuilderWithContactInfo.getGenderTreatment());
    }

    @Test
    void testGetEmail() {
        assertNull(clientBuilderNoArgs.getEmail());
        assertEquals("marie.carey27@fakemail.com", clientBuilderFull.getEmail());
        assertNull(clientBuilderWithIdentification.getEmail());
        assertEquals("davidosborne@some.com", clientBuilderWithContactInfo.getEmail());
    }

    @Test
    void testSetEmail() {
        clientBuilderNoArgs.setEmail("noargs.cb@fakemail.com");
        assertEquals("noargs.cb@fakemail.com", clientBuilderNoArgs.getEmail());

        clientBuilderFull.setEmail("full.cb@fakemail.com");
        assertEquals("full.cb@fakemail.com", clientBuilderFull.getEmail());

        clientBuilderWithIdentification.setEmail("identification.cb@fakemail.com");
        assertEquals("identification.cb@fakemail.com", clientBuilderWithIdentification.getEmail());

        clientBuilderWithContactInfo.setEmail("contact.cb@fakemail.com");
        assertEquals("contact.cb@fakemail.com", clientBuilderWithContactInfo.getEmail());
    }

    @Test
    void testGetPhoneNumber() {
        assertNull(clientBuilderNoArgs.getPhoneNumber());
        assertEquals("(970) 884-8728", clientBuilderFull.getPhoneNumber());
        assertNull(clientBuilderWithIdentification.getPhoneNumber());
        assertEquals("(62) 233 4567", clientBuilderWithContactInfo.getPhoneNumber());
    }

    @Test
    void testSetPhoneNumber() {
        clientBuilderNoArgs.setPhoneNumber("(52) 436 34567");
        assertEquals("(52) 436 34567", clientBuilderNoArgs.getPhoneNumber());

        clientBuilderFull.setPhoneNumber("(14) 863 2345 23423");
        assertEquals("(14) 863 2345 23423", clientBuilderFull.getPhoneNumber());

        clientBuilderWithIdentification.setPhoneNumber("(55) 98227 8903");
        assertEquals("(55) 98227 8903", clientBuilderWithIdentification.getPhoneNumber());

        clientBuilderWithContactInfo.setPhoneNumber(null);
        assertNull(clientBuilderWithContactInfo.getPhoneNumber());
    }

    @Test
    void testGetAge() {
        clientBuilderNoArgs.setDateOfBirth("02/01/2004");
        assertEquals(19, clientBuilderNoArgs.getAge());

        assertEquals(25, clientBuilderFull.getAge());
        assertEquals(36, clientBuilderWithIdentification.getAge());

        clientBuilderWithContactInfo.setDateOfBirth("15/11/1954");
        assertEquals(69, clientBuilderWithContactInfo.getAge());
    }

    @Test
    void testGetDateOfBirth() {
        assertNull(clientBuilderNoArgs.getDateOfBirth());
        assertEquals("22/05/1998", clientBuilderFull.getDateOfBirth());
        assertEquals("13/08/1987", clientBuilderWithIdentification.getDateOfBirth());
        assertNull(clientBuilderWithContactInfo.getDateOfBirth());
    }

    @Test
    void testSetDateOfBirth() {
        clientBuilderNoArgs.setDateOfBirth("28/12/1995");
        assertEquals("28/12/1995", clientBuilderNoArgs.getDateOfBirth());

        clientBuilderFull.setDateOfBirth("14/07/1987");
        assertEquals("14/07/1987", clientBuilderFull.getDateOfBirth());

        clientBuilderWithIdentification.setDateOfBirth("03/11/2005");
        assertEquals("03/11/2005", clientBuilderWithIdentification.getDateOfBirth());

        clientBuilderWithContactInfo.setDateOfBirth("12/04/1948");
        assertEquals("12/04/1948", clientBuilderWithContactInfo.getDateOfBirth());
    }

    @Test
    void testGetAddress() {
        assertNull(clientBuilderNoArgs.getAddress());
        assertEquals("1560 Pennsylvania Avenue", clientBuilderFull.getAddress());
        assertNull(clientBuilderWithIdentification.getAddress());
        assertEquals("States avn 127st", clientBuilderWithContactInfo.getAddress());
    }

    @Test
    void testSetAddress() {
        clientBuilderNoArgs.setAddress("1974 Maple Lane");
        assertEquals("1974 Maple Lane", clientBuilderNoArgs.getAddress());

        clientBuilderFull.setAddress("2634 Mayo Street");
        assertEquals("2634 Mayo Street", clientBuilderFull.getAddress());

        clientBuilderWithIdentification.setAddress("3650 Hickman Street");
        assertEquals("3650 Hickman Street", clientBuilderWithIdentification.getAddress());

        clientBuilderWithContactInfo.setAddress("4458 Tully Street");
        assertEquals("4458 Tully Street", clientBuilderWithContactInfo.getAddress());
    }

    @Test
    void testExceptionThrowing() {
        IllegalArgumentException thrown1 = assertThrows(
                IllegalArgumentException.class,
                () -> clientBuilderNoArgs.setFirstName(null)
        );
        assertTrue(thrown1.getMessage().contains("First name can't be empty or null"));

        IllegalArgumentException thrown2 = assertThrows(
                IllegalArgumentException.class,
                () -> clientBuilderNoArgs.getAge()
        );
        assertTrue(thrown2.getMessage().contains("Date of birth can't be null"));
    }

    @AfterEach
    void tearDown() {
        clientBuilderNoArgs = null;
        clientBuilderFull = null;
        clientBuilderWithIdentification = null;
        clientBuilderWithContactInfo = null;

    }
}