package model.repo;

import model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> displayProduct();
    void add(List<Product> productList);
    void removeProduct();
    void update();
}
