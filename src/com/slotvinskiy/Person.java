//1) Написать класс Person, у которого если следующие поля:
//- Фамилия, Имя, Отчество, дата рождения.
//Написать конструкторы:
//- на все поля,
// - только на ФИО
// - который принимает 1 параметр
// - строку с полным именем "Иванов Иван Иванович", и задает отдельные значения в поля Фамилия, Имя, Отчество.
//Написать методы:
//- который возвращает полное ФИО типа "Иванов Иван Иванович"
//- краткое ФИО типа "Иванов И. И."
//- который на основе даты рождения выводит количество полных лет.

package com.slotvinskiy;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Person {

    private static final DateTimeFormatter FORMATTER =DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private String firstName;
    private String secondName;
    private String patronymic;
    private LocalDate birthday;

    public Person(String secondName, String firstName,  String patronymic, LocalDate birthday) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.birthday = birthday;
    }

    public Person(String secondName, String firstName, String patronymic, String birthday) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.birthday = LocalDate.parse(birthday, FORMATTER);
    }

    public Person(String secondName, String firstName, String patronymic) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
    }

    public Person(String fullName) {
        String[] personData = fullName.split("\\s");
        this.secondName = personData[0];
        this.firstName = personData[1];
        this.patronymic = personData[2];
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String toGetFullName() {
        return secondName + " " + firstName + " " + patronymic;
    }

    public String toGetSecondNameAndInitials() {
        return secondName + " " + firstName.charAt(0) + "." + " " + patronymic.charAt(0) + ".";
    }

    public int toGetAgeInYears() {
        Period age = Period.between(birthday, LocalDate.now());
        return age.getYears();
    }

    @Override
    public String toString() {
        return "Person{" +
                "secondName='" + secondName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
