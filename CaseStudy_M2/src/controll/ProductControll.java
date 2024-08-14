package controll;

import model.Product;
import model.service.productService.IProductService;
import model.service.productService.ProductService;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ProductControll {
    private IProductService iProductService = new ProductService();
    private Scanner scanner = new Scanner(System.in);

    public void displayProductFunctional(){
        int choice;
        do {
            System.out.println("Quản lí sản phẩm: \n" +
                    "1.Hiển thị danh sách sản phẩm \n" +
                    "2.Thêm mới sản phẩm \n" +
                    "3.Chỉnh sửa thông tin sản phẩm \n" +
                    "4.Xóa sản phẩm \n" +
                    "5.Trở về trang chủ \n" +
                    "Nhập lựa chọn của bạn ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    displayProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                   removeProduct();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    public void displayProduct(){
        List<Product> productList = iProductService.displayProduct();
        for (Product p:productList){
            System.out.println(p.toString());
        }
    }

    public void addProduct(){
//        String id, String name, String genre, double price, double amount
        System.out.println("Nhập id sản phẩm: ");
        String id = scanner.nextLine();
//        PatternCheck.checkRegex1(id,"^[S][P]-[0-9]+$");
        Pattern pattern = Pattern.compile("^[S][P]-[0-9]+$");
        while (!pattern.matcher(id).find()){
            System.out.println("Bạn đã sai cú pháp:");
            id = scanner.nextLine();
        }
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập thể loại sản phẩm: ");
        String genre = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập số lượng sản phẩm: ");
        String amount = scanner.nextLine();


        Product product = new Product(id,name,genre,price,Integer.parseInt(amount));
        List<Product> productList = iProductService.displayProduct();
        productList.add(product);
        iProductService.add(productList);
        System.out.println("Thêm mới sản phẩm thành công: " + product);
    }

    public void removeProduct(){
        iProductService.removeProduct();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID sản phẩm muốn xóa: ");
        String id = sc.nextLine();
//        PatternCheck.checkRegex1(id,"^[S][P]-[0-9]+$");
        Pattern pattern = Pattern.compile("^[S][P]-[0-9]+$");
        while (!pattern.matcher(id).find()){
            System.out.println("Bạn đã sai cú pháp:");
            id = sc.nextLine();
        }
        List<Product> productList = iProductService.displayProduct();
        for (Product p:productList){
            if (p.getId().equals(id)){
                productList.remove(p);
                iProductService.add(productList);
                System.out.println("Xóa sản phẩm " + p + " thành công!");
                return;
            }
        }
    }

    public void updateProduct(){
        iProductService.update();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID sản phẩm muốn sửa: ");
        String id = sc.nextLine();
//        PatternCheck.checkRegex1(id,"^[S][P]-[0-9]+$");
        Pattern pattern = Pattern.compile("^[S][P]-[0-9]+$");
        while (!pattern.matcher(id).find()){
            System.out.println("Bạn đã sai cú pháp:");
            id = sc.nextLine();
        }
        List<Product> productList = iProductService.displayProduct();
        for (Product p:productList){
            if (p.getId().equals(id)){
                int index = productList.indexOf(p);
                System.out.println("Sửa tên sản phẩm: ");
                String name = sc.nextLine();
                System.out.println("Sửa laoị sản phẩm: ");
                String genre = sc.nextLine();
                System.out.println("Sửa giá sản phẩm: ");
                int price = sc.nextInt();
                sc.nextLine();
                System.out.println("Sửa số lượng sản phẩm: ");
                int amount = sc.nextInt();
                sc.nextLine();

                Product product = new Product(id,name,genre,price,amount);
                productList.set(index,product);
                iProductService.add(productList);
                System.out.println("Cập nhật nhân viên thành công!");
            }
        }
    }
}
