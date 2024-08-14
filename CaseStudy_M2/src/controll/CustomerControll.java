package controll;

import model.Customer;
import model.service.customerService.CustomerService;
import model.service.customerService.ICustomerService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerControll {

    private ICustomerService iCustomerService = new CustomerService();
    private Scanner scanner = new Scanner(System.in);

    public void displayCustomerFunctional() {
        int choice;
        do {
            System.out.println("Quản lí khách hàng: \n" +
                    "1.Hiển thị danh sách khách hàng \n" +
                    "2.Thêm mới khách hàng \n" +
                    "3.Chỉnh sửa thông tin khách hàng \n" +
                    "4.Xóa khách hàng \n" +
                    "5.Trở về trang chủ \n" +
                    "Nhập lựa chọn của bạn ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayCustomer();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    removeCustomer();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    public void displayCustomer() {
        List<Customer> customers = iCustomerService.displayCustomer();
        for (Customer c : customers) {
            System.out.println(c.toString());
        }
    }

    public void addCustomer() {
//        String id, String name, LocalDate birthDay, String gender, String phoneNumber, String email
        System.out.println("Nhập id khách hàng(KH-...): ");
        String id = scanner.nextLine();
//        PatternCheck.checkRegex1(id, "^[K][H]-[0-9]+$");
        Pattern pattern = Pattern.compile("^[K][H]-[0-9]+$");
        while (!pattern.matcher(id).find()){
            System.out.println("Bạn đã sai cú pháp:");
            id = scanner.nextLine();
        }
        System.out.println("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày tháng năm sinh khách hàng(yyyy-mm-dd): ");
        LocalDate birthDay = LocalDate.parse(scanner.nextLine());
        System.out.println("Nhập số điện thoại khách hàng: ");
        String phoneNumber = scanner.nextLine();
//        "^(?:\\+84|0)(3|5|7|8|9)[0-9]{8}$");
        Pattern pattern1 = Pattern.compile("^(?:\\\\+84|0)(3|5|7|8|9)[0-9]{8}$");
        while (!pattern1.matcher(phoneNumber).find()){
            System.out.println("Bạn đã sai cú pháp:");
            phoneNumber = scanner.nextLine();
        }
        System.out.println("Nhập Email khách hàng: ");
        String email = scanner.nextLine();
//        (email, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Pattern pattern2 = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        while (!pattern2.matcher(email).find()){
            System.out.println("Bạn đã sai cú pháp:");
            email = scanner.nextLine();
        }
        Customer customer = new Customer(id, name, birthDay, phoneNumber, email);
        List<Customer> customerList = iCustomerService.displayCustomer();
        customerList.add(customer);
        iCustomerService.add(customerList);
        System.out.println("Thêm mới thành công: " + customer);
    }

    public void removeCustomer() {
        iCustomerService.remove();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập ID khách hàng muốn xóa: ");
        String id = scanner1.nextLine();
        Pattern pattern = Pattern.compile("^[K][H]-[0-9]+$");
        while (!pattern.matcher(id).find()){
            System.out.println("Bạn đã sai cú pháp:");
            id = scanner1.nextLine();
        }
        List<Customer> customerList = iCustomerService.displayCustomer();
        for (Customer c : customerList) {
            if (c.getId().equals(id)) {
                customerList.remove(c);
                iCustomerService.add(customerList);
                System.out.println("Xóa nhân viên: " + c + " thành công!");
                return;
            }
        }
    }

    public void updateCustomer() {
        iCustomerService.update();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID khách hàng muốn sửa: ");
        String id = sc.nextLine();
//        PatternCheck.checkRegex1(id, "^[K][H]-[0-9]+$");
        Pattern pattern = Pattern.compile("^[K][H]-[0-9]+$");
        while (!pattern.matcher(id).find()){
            System.out.println("Bạn đã sai cú pháp:");
            id = sc.nextLine();
        }
        List<Customer> customerList = iCustomerService.displayCustomer();
        for (Customer c : customerList) {
            if (c.getId().equals(id)) {
                int index = customerList.indexOf(c);
                System.out.println("Sửa tên khách hàng: ");
                String name = sc.nextLine();
                System.out.println("Sửa ngày tháng năm sinh khách hàng: ");
                LocalDate birthDay = LocalDate.parse(sc.nextLine());
                System.out.println("Sửa số điện thoại khách hàng: ");
                String phoneNumber = sc.nextLine();
//                PatternCheck.checkRegex1(phoneNumber, "^(?:\\+84|0)(3|5|7|8|9)[0-9]{8}$");
                Pattern pattern1 = Pattern.compile("^(?:\\\\+84|0)(3|5|7|8|9)[0-9]{8}$");
                while (!pattern1.matcher(phoneNumber).find()){
                    System.out.println("Bạn đã sai cú pháp:");
                    phoneNumber = scanner.nextLine();
                }
                System.out.println("Sửa Email khách hàng: ");
                String email = sc.nextLine();
//                PatternCheck.checkRegex1(email, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
//                (email, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
                Pattern pattern2 = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
                while (!pattern2.matcher(email).find()){
                    System.out.println("Bạn đã sai cú pháp:");
                    email = scanner.nextLine();
                }
                Customer customer = new Customer(id, name, birthDay, phoneNumber, email);
                customerList.set(index, customer);
                iCustomerService.add(customerList);
                System.out.println("Cập nhật thành công khách hàng: " + c);
            }
        }
    }
}
