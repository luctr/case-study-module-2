package controller;

import model.Employee;
import model.FullTimeEmployee;
import storage.FileManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager implements Serializable {
    private static EmployeeManager INSTANCE = new EmployeeManager();
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private EmployeeManager() {
    }

    public List<Employee> getStaff() {
        return employees;
    }

    public void setStaff(List<Employee> employees) {
        this.employees = employees;
    }

    public static EmployeeManager getINSTANCE() {
        return INSTANCE;
    }

    public void addList(Employee employee) {
        this.employees.add(employee);
        FileManager.writeFile("Employee.dat", employees);
    }

    public void display() {
        if (employees != null && employees.size() > 0) {
            for (int i = 0; i < employees.size(); i++) {
                System.out.println("index: " + i + "\n" + employees.get(i));
            }
        } else {
            System.out.println("Không có phần tử trong mảng");
        }
    }

    public Object searchEmployee(String code) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getCode().equals(code)) {
                return employees.get(i);
            }
        }
        return null;
    }
    public void show(Object obiect){
        if (obiect != null){
            System.out.println(obiect);
        }
        System.out.println("Không Tìm Thấy ");
    }

    public void displayByStatus(boolean status) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getStatus() == (status)) {
                System.out.println("Tên Nhân Viên : " + employees.get(i).getName() +"\n" +
                        "Trạng Thái Nhân Viên :" + (employees.get(i).getStatus()?"Đang Làm Việc":"Đã Nghỉ") + "\n");
            }else {
                System.out.println("Không Có Nhân Viên Phù Hợp");
            }
        }
    }
    public boolean checkCode(String code){
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getCode().equals(code)){
                return true;
            }
        }return false;
    }
    public void caculateSalary(){
        for (Employee employee:employees
             ) {
            System.out.println("Tên Nhân Viên : " +employee.getName()+ "\n" +"Tiền phải trả là :" + employee.getAmountMoney() + "\n");
        }
    }
}



