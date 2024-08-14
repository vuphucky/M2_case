package model.repo;

import model.Employee;
import model.Product;
import storage.IOEmployee;
import storage.IOProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo {
    private final static List<Product> listProduct;

    static {
        listProduct = new ArrayList<>();
    }

    @Override
    public List<Product> displayProduct() {
        return IOProduct.readFromFile();
    }

    @Override
    public void add(List<Product> productList) {
        IOProduct.writeToFile(productList);
    }

    @Override
    public void removeProduct() {
        displayProduct();
    }

    @Override
    public void update() {
        displayProduct();
    }
}
