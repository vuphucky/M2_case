package model.service.productService;

import model.Product;
import model.repo.IProductRepo;
import model.repo.ProductRepo;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepo iProductRepo = new ProductRepo();

    @Override
    public List<Product> displayProduct() {
        return iProductRepo.displayProduct();
    }

    @Override
    public void add(List<Product> productList) {
        iProductRepo.add(productList);
    }

    @Override
    public void removeProduct() {
        iProductRepo.removeProduct();
    }

    @Override
    public void update() {
        iProductRepo.update();
    }
}
