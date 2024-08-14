package model.service.productService;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> displayProduct();
    void add(List<Product> productList);
    void removeProduct();
    void update();
}
