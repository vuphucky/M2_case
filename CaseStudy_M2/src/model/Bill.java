package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Bill {
    private String id;
    private LocalDate date;
    private String nameCustomer;
    private List <String> nameProduct;
    private List<String> quantity;
    private int allPrice;
    private String nameEmployee;

    public Bill() {
    }

    public Bill(String id, LocalDate date, String nameCustomer, List<String> nameProduct, List<String> quantity, int allPrice,String nameEmployee) {
        this.id = id;
        this.date = LocalDate.now();
        this.nameCustomer = nameCustomer;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.allPrice = allPrice;
this.nameEmployee = nameEmployee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public List<String> getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(List<String> nameProduct) {
        this.nameProduct = nameProduct;
    }

    public List<String> getQuantity() {
        return quantity;
    }

    public void setQuantity(List<String> quantity) {
        this.quantity = quantity;
    }

    public int getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(int allPrice) {
        this.allPrice = allPrice;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    @Override
    public String toString() {
        return "Hóa đơn{" +
                "id:'" + id + '\'' +
                ", ngày:" + date +
                ", Tên khách hàng='" + nameCustomer + '\'' +
                ", tên sản phẩm:'" + nameProduct + '\'' +
                ", số lượng: '" + quantity +
                ", thành tiền: '" + allPrice +
                ", nhân viên tạo hóa đơn: '" + nameEmployee + '\'' +
                '}';
    }
}
