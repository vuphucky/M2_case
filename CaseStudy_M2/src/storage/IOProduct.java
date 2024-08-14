package storage;

import model.Employee;
import model.Product;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IOProduct {
    private static final String PRODUCT_PATH = "Data/product.csv";
    public static List<Product> readFromFile(){
        List<String> stringList = new ArrayList<String>();
        try (FileReader fileReader = new FileReader(PRODUCT_PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                stringList.add(line);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return converStringToObject(stringList);
    }
    public static List<Product> converStringToObject(List<String> list){
        List<Product> products = new ArrayList<>();
        for (String e:list){
//            String id, String name, String genre, double price, double amount
            String[] temp = e.split(",");
            Product product = new Product();
            product.setId(temp[0]);
            product.setName(temp[1]);
            product.setGenre(temp[2]);
            product.setPrice(Integer.parseInt(temp[3]));
            product.setAmount(Integer.parseInt(temp[4]));
            products.add(product);
        }
        return products;
    }

    public static void writeToFile(List<Product> productList){
        try (FileWriter fileWriter = new FileWriter(PRODUCT_PATH);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
        {
            for (Product e:productList){
                bufferedWriter.write(e.getId());
                bufferedWriter.write(",");
                bufferedWriter.write(e.getName());
                bufferedWriter.write(",");
                bufferedWriter.write(e.getGenre());
                bufferedWriter.write(",");
                bufferedWriter.write(String.valueOf(e.getPrice()));
                bufferedWriter.write(",");
                bufferedWriter.write(String.valueOf(e.getAmount()));
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
