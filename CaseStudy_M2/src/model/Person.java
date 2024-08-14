package model;

import java.time.LocalDate;

public abstract class Person {
    private String id;
    private String name;
    private LocalDate birthDay;

    private String phoneNumber;
    private String Email;

    public Person() {
    }

    public Person(String id, String name, LocalDate birthDay, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        Email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return
                "id: " + id + "," +
                "tên: " + name + "," +
                "ngày sinh: " + birthDay + "," +
                "số điện thoại " + phoneNumber + "," +
                "Email= " + Email;
    }
}
