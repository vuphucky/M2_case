package model;

import java.time.LocalDate;

public class Customer extends Person{
    public Customer() {}

    public Customer(String id, String name, LocalDate birthDay, String phoneNumber, String email) {
        super(id, name, birthDay, phoneNumber, email);
    }

    public String convertToLine(){
        return super.getId() + "," + super.getName() + "," + super.getBirthDay() + "," +
                 super.getPhoneNumber() + "," + super.getEmail();
    }

    @Override
    public String toString() {
        return "Khách hàng: " + super.toString();
    }
}
