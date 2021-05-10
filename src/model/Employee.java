package model;

import java.io.Serializable;

public abstract class Employee implements Serializable {

    private String name;
    private String age;
    private String address;
    private String phoneNumber;
    private String code;
    private boolean status;

    public Employee() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract int getAmountMoney();

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Employee(String name, String age, String address, String phoneNumber, String code, boolean status ) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.code = code;
        this.status = status;

    }

    @Override
    public String toString() {
        return "Thông Tin Nhân Viên" +
                " - Tên : " + name +
                " - Tuổi : " + age +
                " - Địa Chỉ : " + address +
                " - Số Điện Thoại : " + phoneNumber +
                " - Mã Nhân Viên : " + code +
                " - Trạng Thái Nhân Viên : " + status +
                "\n";
    }
}
