package model;

public class PartTimeEmployee extends Employee {
    private int workTime;
    private int hourlyMoney;

    public PartTimeEmployee() {

    }

    public PartTimeEmployee(int workTime, int hourlyMoney) {
        this.workTime = workTime;
        this.hourlyMoney = hourlyMoney;
    }

    public PartTimeEmployee(String name, int age, String address, String phoneNumber, String code, boolean status, int workTime, int hourlyMoney) {
        super(name, age, address, phoneNumber, code, status);
        this.workTime = workTime;
        this.hourlyMoney = hourlyMoney;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public int getHourlyMoney() {
        return hourlyMoney;
    }

    public void setHourlyMoney(int hourlyMoney) {
        this.hourlyMoney = hourlyMoney;
    }

    @Override
    public int getAmountMoney() {
        return workTime * hourlyMoney;
    }

//    @Override
//    public String toString() {
//        return toString(super) +"PartTimeEmployee{" +
//                "workTime=" + workTime +
//                ", hourlyMoney=" + hourlyMoney +
//                '}';
//    }

    @Override
    public String toString() {
        return super.toString()+ "\n" +" Nhân Viên Part Time : " +
                " - Thời Gian Làm : " + workTime +
                " - Giá Theo Giờ : " + hourlyMoney + "\n";
    }
}
