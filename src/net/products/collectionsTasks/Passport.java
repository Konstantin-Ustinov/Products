package net.products.collectionsTasks;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.zip.DataFormatException;

public class Passport {
    private int passNumber;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDay;

    public Passport(int passNumber, String lastName, String firstName, String middleName, String birthDay) {
        this.passNumber = passNumber;
        if (lastName != null && firstName != null) {
            this.lastName = lastName;
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Имя и фамилия не могут быть пустыми");
        }
        this.middleName = middleName;
        try {
            this.birthDay = birthDay != null ? LocalDate.parse(birthDay) : LocalDate.now();
        } catch (DateTimeParseException e) {
            System.out.println("Укажите дату в правильном формате (2001-05-31)");
        }
    }

    public int getPassNumber() {
        return passNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "\npassNumber=" + passNumber +
                ",\n lastName='" + lastName + '\'' +
                ",\n firstName='" + firstName + '\'' +
                ",\n middleName='" + middleName + '\'' +
                ",\n birthDay=" + birthDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return passNumber == passport.passNumber && lastName.equals(passport.lastName) && firstName.equals(passport.firstName) && Objects.equals(middleName, passport.middleName) && birthDay.equals(passport.birthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passNumber, lastName, firstName, middleName, birthDay);
    }
}
