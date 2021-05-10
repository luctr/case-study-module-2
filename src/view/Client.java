package view;

import controller.EmployeeManager;
import controller.LoginManager;
import model.Employee;
import model.FullTimeEmployee;
import model.LogIn;
import model.PartTimeEmployee;
import storage.FileManager;

import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        //lấy ra đối tượng của manager
        EmployeeManager employeeManager = EmployeeManager.getINSTANCE();
        List<Employee> employees = (List<Employee>) FileManager.readFile("Employee.dat");

        LoginManager loginManager = LoginManager.getINSTANCE();
        List<LogIn> listLogIn = (List<LogIn>) FileManager.readFile("LogIn.dat");

        if (employees != null) {
            employeeManager.setEmployees(employees);
        }
        if (listLogIn != null) {
            loginManager.setListLogIn(listLogIn);
        }
        MenuLogIn(loginManager);


        menu(employeeManager,loginManager);
    }

    private static void MenuLogIn(LoginManager loginManager) {
        do {
            System.out.println("----- Hệ Thống Đăng Nhập -----");
            System.out.println("1. Đăng Nhập");
            System.out.println("2. Đăng Ký");
            System.out.println("3. Thoát");
            int choise;
            try {
                choise = new Scanner(System.in).nextInt();

            } catch (Exception e) {
                System.out.println("Vui Lòng Nhập Lựa Chọn Theo Menu");
                choise = 0;
            }

            switch (choise) {
                case 1:
                    System.out.println("----- Đăng Nhập -----");
                    while (true) {
                        System.out.println("-----------------------");
                        System.out.println("Nhập Tên Đăng Nhập");
                        String name = inputString();
                        System.out.println("Nhập Password");
                        String password = inputString();

                        //check user và password
                        boolean checkUser = loginManager.checkUser(name, password);
                        if (checkUser == true) {
                            System.out.println("----- Đăng Nhập Thành Công -----");
                            System.out.println(" Xin Chào " + name);
                            choise = 3;
                            break;
                        } else {
                            System.out.println("Sai Tên Đăng Nhập Hoặc Mật Khẩu, Vui Lòng Nhập Lại");
//                            System.out.println("Nhập vào những lựa chọn phía trên, Mời bạn nhập lại");
//                            try {
//                                int number = new Scanner(System.in).nextInt();
//                                if (number == 0) {
//                                    break;
//                                }
//                            } catch (Exception e) {
//                                ;
//                            }
                        }
                    }
                    break;
                case 2:
                    LogIn logIn = createLogIn();
                    loginManager.addList(logIn);
                    break;

            }
            if (choise == 3) {
                break;
            }
        } while (true);
    }


    //Đăng ký
    private static LogIn createLogIn() {
        System.out.println("----- Đăng Ký -----");
        System.out.println("Nhập Tên Đăng Ký");
        String user = "";
        LoginManager loginManager = LoginManager.getINSTANCE();

        while (true) {
            int check = 0;
            user = inputString();
            if (user != null && user.length() > 0) {
                for (int i = 0; i < loginManager.getListLogIn().size(); i++) {
                    if (loginManager.getListLogIn().get(i).getUser().equals(user)) {
                        check++;
                    }
                }
                if (check == 0) {
                    break;
                } else {
                    System.out.println("Tên Đã Tồn Tại Vui Lòng Nhập Lại");
                    System.out.println("Nhập Lại Tên Đăng Nhập");
                }
            } else {
                System.out.println("Tên Đăng Nhập Không Thể Để Trống");
            }
        }

        System.out.println("Nhập Mật Khẩu");
        String password = inputString();
        LogIn logIn = new LogIn(user, password);

        return logIn;

    }

    public static void menu(EmployeeManager employeeManager, LoginManager loginManager) {
        do {
            System.out.println("1. Thêm Nhân Viên");
            System.out.println("2. Hiển Thị Thông Tin Nhân Viên");
            System.out.println("3. Tìm Kiếm Và Sửa Nhân Viên");
            System.out.println("4. Tìm Kiếm Và Xóa Nhân Viên");
            System.out.println("5. Tìm Nhân Viên Và Hiển Thị");
            System.out.println("6. Kiểm Tra Trạng Thái Của Nhân Viên");
            System.out.println("7. Hiển Thị Lương Phải Trả Của Nhân viên");
            System.out.println("8. Thông Tin Tài Khoản");
            System.out.println("9. Xóa Tài Khoản ");
            System.out.println("10. Thoát");
            int choise;
            while (true) {
                try {
                    choise = new Scanner(System.in).nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Vui Lòng Nhập Lựa Chọn Tương Tự ở Menu");
                }
            }
            switch (choise) {
                case 1:
                    chooseTypeEmployee(employeeManager);
                    break;
                case 2:
                    employeeManager.display();
                    break;
                case 3:
                    System.out.println("Nhập Mã Cần Tìm");
                    searchEdit(employeeManager);
                    break;
                case 4:
                    inputString();
                    deleteEmployee(employeeManager);

                    break;
                case 5:
                    System.out.println("Nhập Tên Cần Tìm");
                    System.out.println(employeeManager.searchEmployee(inputString()));
                    break;
                case 6:
                    System.out.println("------ Chọn trạng thái hiển thị ------");
                    System.out.println("1. Đang Làm Việc");
                    System.out.println("2. Đã Nghỉ Việc");
                    int selection = new Scanner(System.in).nextInt();
                    switch (selection) {
                        case 1:
                            employeeManager.displayByStatus(true);
                            break;
                        case 2:
                            employeeManager.displayByStatus(false);
                            break;
                    }

                    break;
                case 7:
                    employeeManager.caculateSalary();
                    break;
                case 8:
                    loginManager.showUser();
                    break;
                case 9:
                    String name = inputString();
                    loginManager.deleteUser(loginManager.check(name));
                    break;
                case 10:
                    break;
            }
            if (choise == 10) {
                break;
            }
        } while (true);
    }

    private static void deleteEmployee(EmployeeManager employeeManager) {
        System.out.println("Nhập Mã Cần Tìm");
        String code = new Scanner(System.in).nextLine();
        Object input = employeeManager.searchEmployee(code);
        if (input != null) {
            employeeManager.getStaff().remove(input);
            System.out.println("Xóa Thành Công");
        } else {
            System.out.println("Không Có Mã Tương Ứng");
        }
    }

    private static void searchEdit(EmployeeManager employeeManager) {
        Employee employee = (Employee) employeeManager.searchEmployee(inputString());
        System.out.println(employee);
        if (employee instanceof FullTimeEmployee) {
            System.out.println("------ Sửa Thông Tin Nhân Viên ------");
            System.out.println("1. Sửa Tên ");
            System.out.println("2. Sửa Tuổi ");
            System.out.println("3. Sửa Địa Chỉ ");
            System.out.println("4. Sửa Số Điện Thoại ");
            System.out.println("5. Sửa Mã Nhân Viên");
            System.out.println("6. Thay đổi Trạng Thái");
            System.out.println("7. Sửa Lương Cơ Bản");
            System.out.println("8. Sửa Tiền Thưởng");
            System.out.println("9. Sửa Tiền Phạt");
            System.out.println("10. Quay Lại");
            int choise = new Scanner(System.in).nextInt();
            switch (choise) {
                case 1:
                    System.out.println("Vui lòng Nhập Tên");
                    employee.setName(inputString());
                    break;
                case 2:
                    System.out.println("Vui lòng Nhập Tuổi");
                    employee.setAge(inputInt());
                    break;
                case 3:
                    System.out.println("Vui lòng Nhập Địa Chỉ");
                    employee.setAddress(inputString());
                    break;
                case 4:
                    System.out.println("Vui lòng Nhập Số Điện Thoại");
                    employee.setPhoneNumber(inputString());
                    break;
                case 5:
                    System.out.println("Vui Lòng Nhập Mã Nhân Viên");
                    employee.setPhoneNumber(inputString());
                    break;
                case 6:
                    System.out.println("Vui lòng Nhập Trạng Thái");
                    employee.setStatus(status());
                    break;
                case 7:
                    System.out.println("Vui lòng Nhập Lương");
                    ((FullTimeEmployee) employee).setBasicSalary(inputInt());
                    break;
                case 8:
                    System.out.println("Vui lòng Nhập Tiền Thưởng");
                    ((FullTimeEmployee) employee).setBonus(inputInt());
                    break;
                case 9:
                    System.out.println("Vui lòng Nhập Tiền Phạt");
                    ((FullTimeEmployee) employee).setFine(inputInt());
                    break;
                case 10:
                    break;


            }
        } else {
            System.out.println("------ Sửa Thông Tin Nhân Viên ------");
            System.out.println("1. Sửa Tên ");
            System.out.println("2. Sửa Tuổi ");
            System.out.println("3. Sửa Địa Chỉ ");
            System.out.println("4. Sửa Số Điện Thoại ");
            System.out.println("5. Thay Đổi Trạng Thái");
            System.out.println("6. Sửa Giờ Làm");
            System.out.println("7. Sửa Tiền Theo Tiếng");
            System.out.println("8. Quay Lại");
        }
    }

    //Lựa Chọn Loại Nhân Viên
    public static void chooseTypeEmployee(EmployeeManager employeeManager) {
        System.out.println("---------------");
        System.out.println("Thêm Nhân Viên ");
        System.out.println("1. Nhân Viên FullTime");
        System.out.println("2. Nhân Viên PartTime");
        System.out.println("3. Quay Lại");
        int choise = new Scanner(System.in).nextInt();
        switch (choise) {
            case 1:
                System.out.println("------Thêm Nhân Viên FullTime-----");
                employeeManager.addList(createFullTimeEmployee());
                break;
            case 2:
                System.out.println("------Thêm Nhân Viên PartTime-----");
                employeeManager.addList(createPartTimeEmployee());
                break;
            case 3:
                break;
        }
    }

    private static String inputString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String response = scanner.nextLine();
            if (response.length() > 0) {
                return response;
            } else {
                System.out.println("Vui Lòng Nhập Lại");
            }
        }

    }

    private static int inputInt() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                int response = scanner.nextInt();
                return response;
            } catch (Exception e) {
                System.out.println("Vui Lòng Nhập Lại");
            }
        }
    }

    private static boolean status() {
        System.out.println("---------------------");
        System.out.println("1. Đang Làm Việc : True");
        System.out.println("2. Nghỉ Việc Ghi : False");
        System.out.println("Nhập Trạng Thái");
        while (true) {
            int status = new Scanner(System.in).nextInt();
            if (status == 1) {
                return true;
            } else if (status == 2) {
                return false;
            } else {
                System.out.println("Vui Lòng Nhập Lại");
            }
        }
    }

    public static FullTimeEmployee createFullTimeEmployee() {
        System.out.println("Nhập tên");
        String name = inputString();

        System.out.println("Nhập Tuổi");
        int age = inputInt();

        System.out.println("Địa Chỉ ");
        String address = inputString();

        System.out.println("Nhập Số Điện Thoại");
        String phoneNumber = inputString();

        System.out.println("Nhập Mã Nhân Viên");
        String code;

        while (true) {
            code = inputString();
            boolean check = EmployeeManager.getINSTANCE().checkCode(code);
            if (check == true) {
                System.out.println("Mã code không được lặp lại vui lòng nhập lại :");
            } else {
                break;
            }
        }
        System.out.println("Nhập Trạng Thái Của Nhân Viên");
        boolean status = status();

        System.out.println("Lương Cứng");
        int basicSalary = new Scanner(System.in).nextInt();

        System.out.println("Nhập Số Ngày Làm Việc");
        int day = new Scanner(System.in).nextInt();

        System.out.println("Tiền Thưởng");
        int bonus = new Scanner(System.in).nextInt();

        System.out.println("Tiền Phạt");
        int fine = new Scanner(System.in).nextInt();

        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(name, age, address, phoneNumber, code, status, basicSalary, day, bonus, fine);
        return fullTimeEmployee;
    }

    public static PartTimeEmployee createPartTimeEmployee() {
        System.out.println("Nhập tên");
        String name = inputString();

        System.out.println("Nhập Tuổi");
        int age = inputInt();

        System.out.println("Nhập Địa Chỉ");
        String address = inputString();

        System.out.println("Nhập Số Điện Thoại");
        String phoneNumber = inputString();

        System.out.println("Nhập Mã Code");
        String code = inputString();

        System.out.println("Nhập Trạng Thái Của Nhân Viên");
        boolean status = status();

        System.out.println("Nhập Giờ Làm");
        int workTime = new Scanner(System.in).nextInt();

        System.out.println("Nhập Giá Giờ Làm");
        int hourlyMoney = new Scanner(System.in).nextInt();

        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(name, age, address, phoneNumber, code, status, workTime, hourlyMoney);
        return partTimeEmployee;
    }

}


