package controll;

import model.*;
import model.service.employeeService.IEmployeeService;
import storage.IOEmployee;
import storage.IOProduct;
import storage.IOBill;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ShoppingCartControll {
    static CustomerControll customerControll = new CustomerControll();
    public static void orderItem(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            int choice;
            System.out.println("Danh sách sản phẩm trong giỏ hàng: ");
            List<Product> productList = IOProduct.readFromFile();
            for (Product p:productList){
                System.out.println(p.toString());
            }

            System.out.println("1.Thêm vào giỏ hàng \n"+
                    "2.Quay lại trang chủ \n" +
                    "Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    ItemOrder();
                    break;
                case 2:
                    return;
            }

        }
    }

private static void ItemOrder(){
        Scanner scanner = new Scanner(System.in);
        List<ShoppingCart> shoppingCartList = new ArrayList<>();
        while (true){
            System.out.println("Nhập id sản phẩm khách muốn thêm vào giỏ hàng: ");
            String id = scanner.nextLine();
            System.out.println("Nhập số lượng sản phẩm khách muốn mua");
            int amount = Integer.parseInt(scanner.nextLine());
            shoppingCartList.add(new ShoppingCart(id,amount));
            System.out.println("Khách có muốn mua thêm sản phẩm: \n"+
                                "1.Thêm \n"+ "2.Thanh toán \n" +
                                 "3.Tạo hóa đơn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    break;
                case 2:
                    makeBill(shoppingCartList);
                    creatBill();
                    return;
            }
        }
}
private static void makeBill(List<ShoppingCart> shoppingCartList){
    System.out.println("Những sản phẩm khách mua:");
    int total=0;

    List<Product> productList = IOProduct.readFromFile();
    for (ShoppingCart shoppingCart:shoppingCartList){
        for (Product p:productList){
            if (shoppingCart.getIdItem().equals(p.getId())){
                System.out.println("Tên sản phẩm: " + p.getName() + " số lượng sản phẩm: " + shoppingCart.getAmountItem() + " Giá sản phẩm: " + p.getPrice() + " Tổng tiền: " + shoppingCart.getAmountItem() * p.getPrice());
                total += shoppingCart.getAmountItem() * p.getPrice();
            }
        }
    }
    System.out.println("Tổng giá tiền hóa đơn: " + total);
    for (ShoppingCart shoppingCart:shoppingCartList){
        for (Product p:productList){
            if (shoppingCart.getIdItem().equals(p.getId())) {
                int amount = p.getAmount() - shoppingCart.getAmountItem();
                p.setAmount(amount);
            }
        }
    }
    IOProduct.writeToFile(productList);
}
public static void creatBill(){
        Scanner scanner = new Scanner(System.in);
    customerControll.addCustomer();
    System.out.println("Nhập id hóa đơn: ");
    String id = scanner.nextLine();
    LocalDate date = LocalDate.now();
    System.out.println("Ngày tạo hóa đơn: " + date);
    System.out.println("Tên khách hàng: ");
    String nameCustomer = scanner.nextLine();
    System.out.println("Sản phẩm: ");
    List<String> nameProduct = Collections.singletonList(scanner.nextLine());
    System.out.println("Số lượng: ");
    List<String> quantity = Collections.singletonList(scanner.nextLine());
    System.out.println("Thành tiền: ");
    int allPrice = Integer.parseInt(scanner.nextLine());
    System.out.println("Nhân viên tạo hóa đơn: ");
    String nameEmployee = scanner.nextLine();
     while (!checkEmployee(nameEmployee)){
         nameEmployee = scanner.nextLine();
     }

    Bill bill = new Bill(id,date,nameCustomer,nameProduct,quantity,allPrice,nameEmployee);
          List<Bill> billList = IOBill.readFromFile();
          billList.add(bill);
          IOBill.writeToFile(billList);
    System.out.println("In ra hóa đơn " + bill);
}
public static boolean checkEmployee(String name){
    List<Employee> employeeList = IOEmployee.readFromFile();
    for (Employee e : employeeList) {
        if (name.equals(e.getName())) {
            return true;
        }
    }
    System.out.println("Không tồn tại nhân viên " + name);
    return false;
}
}
