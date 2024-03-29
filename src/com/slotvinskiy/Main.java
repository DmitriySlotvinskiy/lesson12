package com.slotvinskiy;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Person person1 = new Person("Сало Петро Васыльовыч");

        LocalDate birthday = LocalDate.of(1985, 8, 8);
        person1.setBirthday(birthday);
        System.out.println(person1);
        System.out.println(person1.getFullName());
        System.out.println(person1.getSecondNameAndInitials());
        System.out.println(person1.getAgeInYears());

        Person person2 = new Person("Кулич", "Оксана", "Александровна", "12-09-1985");
        System.out.println(person2);
        System.out.println(person2.getFullName());
        System.out.println(person2.getSecondNameAndInitials());
        System.out.println(person2.getAgeInYears());
    }
}
