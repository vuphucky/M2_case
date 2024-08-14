package controll;

import model.Bill;
import storage.IOBill;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuControll {
    public static void displayMenu() {
            try {
                FileReader Reader = new FileReader("Data/view.txt");
                int data = Reader.read();
                while (data != -1) {
                    System.out.print((char) data);
                    data = Reader.read();
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        Scanner scanner = new Scanner(System.in);
            CustomerControll customerControll = new CustomerControll();
            EmployeeControll employeeControll = new EmployeeControll();
            ProductControll productControll = new ProductControll();
            ShoppingCartControll shoppingCartControll = new ShoppingCartControll();
            int choice;
            do {
                System.out.println( "\n" + "The New Box Shop: \n" +
                        "1.Quản lý nhân viên. \n" +
                        "2.Quản lý khách hàng. \n" +
                        "3.Quản lý sản phẩm. \n" +
                        "4.Giỏ hàng. \n" +
                        "5.Hiển thị hóa đơn. \n" +
                        "6.Thoát chương trình. \n" +
                        "Nhập lựa chọn của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        employeeControll.displayEmployeeFunctional();
                        break;
                    case 2:
                        customerControll.displayCustomerFunctional();
                        break;
                    case 3:
                        productControll.displayProductFunctional();
                        break;
                    case 4:
                        shoppingCartControll.orderItem();
                        break;
                    case 5:
                        displayBill();
                        break;
                    case 6:
                        System.exit(1);
                }
            }while (true);
        }
        public static void displayBill(){
            List<Bill> billList = IOBill.readFromFile();
            for (Bill b:billList){
                System.out.println(b.toString());
            }
        }
    }

