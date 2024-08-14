package controll;

import model.Employee;
import model.service.employeeService.EmployeeService;
import model.service.employeeService.IEmployeeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeControll {
    private IEmployeeService iEmployeeService = new EmployeeService();
    private Scanner scanner = new Scanner(System.in);

    public void displayEmployeeFunctional(){
        int choice;
        do {
            System.out.println("Quản lí nhân viên: \n" +
                    "1.Hiển thị danh sách nhân viên \n" +
                    "2.Thêm mới nhân viên \n" +
                    "3.Chỉnh sửa thông tin nhân viên \n" +
                    "4.Xóa nhân viên \n" +
                    "5.Trở về trang chủ \n" +
                    "Nhập lựa chọn của bạn ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    displayEmployee();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    removeEmployee();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    public void displayEmployee(){
        List<Employee> employees = iEmployeeService.displayEmployee();
        for (Employee e:employees){
            System.out.println(e.toString());
        }
    }

    public void addEmployee(){
        System.out.println("Nhập id nhân viên: ");
        String id = scanner.nextLine();
//        PatternCheck.checkRegex1(id,"^[N][V]-[0-9]+$");
        Pattern pattern = Pattern.compile("^[N][V]-[0-9]+$");
        while (!pattern.matcher(id).find()){
            System.out.println("Bạn đã sai cú pháp:");
            id = scanner.nextLine();
        }
        System.out.println("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày tháng năm sinh nhân viên: ");
        LocalDate birthDay = LocalDate.parse(scanner.nextLine());
        System.out.println("Nhập số điện thoại nhân viên: ");
        String phoneNumber = scanner.nextLine();
//        PatternCheck.checkRegex1(phoneNumber, "^(?:\\+84|0)(3|5|7|8|9)[0-9]{8}$");
        Pattern pattern1 = Pattern.compile("^(?:\\\\+84|0)(3|5|7|8|9)[0-9]{8}$");
        while (!pattern1.matcher(phoneNumber).find()){
            System.out.println("Bạn đã sai cú pháp:");
            phoneNumber = scanner.nextLine();
        }
        System.out.println("Nhập Email nhân viên: ");
        String email = scanner.nextLine();
//        PatternCheck.checkRegex1(email, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Pattern pattern2 = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        while (!pattern2.matcher(email).find()){
            System.out.println("Bạn đã sai cú pháp:");
            email = scanner.nextLine();
        }
        System.out.println("Nhập chức vụ của nhân viên: ");
        String duty = scanner.nextLine();

        Employee employee = new Employee(id,name,birthDay,phoneNumber,email,duty);
        List<Employee> employeeList = iEmployeeService.displayEmployee();
        employeeList.add(employee);
        iEmployeeService.add(employeeList);
        System.out.println("Thêm mới nhân viên thành công: " + employee);
    }

    public void removeEmployee(){
        iEmployeeService.removeEmployee();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID nhân viên muốn xóa: ");
        String id = sc.nextLine();
//        PatternCheck.checkRegex1(id,"^[N][V]-[0-9]+$");
        Pattern pattern = Pattern.compile("^[N][V]-[0-9]+$");
        while (!pattern.matcher(id).find()){
            System.out.println("Bạn đã sai cú pháp:");
            id = scanner.nextLine();
        }
        List<Employee> employeeList = iEmployeeService.displayEmployee();
        for (Employee e:employeeList){
            if (e.getId().equals(id)){
                employeeList.remove(e);
                iEmployeeService.add(employeeList);
                System.out.println("Xóa nhân viên " + e + " thành công!");
                return;
            }
        }
    }

    public void updateEmployee(){
        iEmployeeService.update();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID nhân viên muốn sửa: ");
        String id = sc.nextLine();
//        PatternCheck.checkRegex1(id,"^[N][V]-[0-9]+$");
        Pattern pattern = Pattern.compile("^[N][V]-[0-9]+$");
        while (!pattern.matcher(id).find()){
            System.out.println("Bạn đã sai cú pháp:");
            id = sc.nextLine();
        }
        List<Employee> employeeList = iEmployeeService.displayEmployee();
        for (Employee e:employeeList){
            if (e.getId().equals(id)){
                int index = employeeList.indexOf(e);
                System.out.println("Sửa tên nhân viên: ");
                String name = sc.nextLine();
                System.out.println("Sửa ngày tháng năm sinh nhân viên: ");
                LocalDate birthDay = LocalDate.parse(sc.nextLine());
                System.out.println("Sửa số điện thoại nhân viên: ");
                String phoneNumber = sc.nextLine();
//                PatternCheck.checkRegex1(phoneNumber, "^(?:\\+84|0)(3|5|7|8|9)[0-9]{8}$");
                Pattern pattern1 = Pattern.compile("^(?:\\\\+84|0)(3|5|7|8|9)[0-9]{8}$");
                while (!pattern1.matcher(phoneNumber).find()){
                    System.out.println("Bạn đã sai cú pháp:");
                    phoneNumber = sc.nextLine();
                }
                System.out.println("Sửa Email nhân viên: ");
                String email = sc.nextLine();
//                PatternCheck.checkRegex1(email, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
                Pattern pattern2 = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
                while (!pattern2.matcher(email).find()){
                    System.out.println("Bạn đã sai cú pháp:");
                    email = sc.nextLine();
                }
                System.out.println("Sửa chức vụ nhân viên: ");
                String duty = sc.nextLine();

                Employee employee = new Employee(id,name,birthDay,phoneNumber,email,duty);
                employeeList.set(index,employee);
                iEmployeeService.add(employeeList);
                System.out.println("Cập nhật nhân viên thành công!");
            }
        }
    }
}
