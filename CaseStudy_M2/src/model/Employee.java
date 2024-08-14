package model;

import java.time.LocalDate;

public class Employee extends Person{
    private String duty;

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public Employee(){}

    public Employee(String id, String name, LocalDate birthDay, String phoneNumber, String email,String duty) {
        super(id, name, birthDay, phoneNumber, email);
        this.duty = duty;
    }

    public String convertToLine(){
        return super.getId() + "," + super.getName() + "," + super.getBirthDay()
                + "," +  getPhoneNumber() + "," + super.getEmail()
                + "," + duty;
    }

    @Override
    public String toString() {
        return "Nhân viên: " + super.toString() + "," + "chức vụ: " + duty;
    }
}
