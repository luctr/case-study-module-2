package model;

public class FullTimeEmployee extends Employee {
    private int basicSalary;
    private int day;
    private int bonus;
    private int fine;

    public FullTimeEmployee(int basicSalary, int day) {
        this.basicSalary = basicSalary;
        this.day = day;
    }

    public FullTimeEmployee(String name, String age, String address, String phoneNumber, String code, boolean status, int basicSalary, int day, int bonus, int fine) {
        super(name, age, address, phoneNumber, code, status);
        this.basicSalary = basicSalary;
        this.day = day;
        this.bonus = bonus;
        this.fine = fine;
    }
    public FullTimeEmployee(){

    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    @Override
    public int getAmountMoney() {
        int total = basicSalary * day + bonus - fine;
        return total;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+" Nhân Viên FullTime : " +
                "Lương Theo Ngày : " + basicSalary +"\n" +
                " - Ngày Làm Việc : " + day +"\n" +
                " - Tiền Thưởng : " + bonus +"\n" +
                " - Tiền Phạt :" + fine +
                "\n" + "-------------------------";
    }
}
