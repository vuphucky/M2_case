package storage;

import model.Bill;
import model.ShoppingCart;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IOBill {
private static final String BILL_Path = "Data/bill.csv";
    public static void writeToFile(List<Bill> billList){
        try (FileWriter fileWriter = new FileWriter(BILL_Path);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
        {
            for (Bill b:billList){
                bufferedWriter.write(b.getId());
                bufferedWriter.write(",");
                bufferedWriter.write(String.valueOf(b.getDate()));
                bufferedWriter.write(",");
                bufferedWriter.write(b.getNameCustomer());
                bufferedWriter.write(",");
                bufferedWriter.write(String.valueOf(b.getNameProduct()));
                bufferedWriter.write(",");
                bufferedWriter.write(String.valueOf(b.getQuantity()));
                bufferedWriter.write(",");
                bufferedWriter.write(String.valueOf(b.getAllPrice()));
                bufferedWriter.write(",");
                bufferedWriter.write(b.getNameEmployee());
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Bill> readFromFile(){
        List<String> stringList = new ArrayList<>();
        try(FileReader fileReader = new FileReader(BILL_Path);
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

    public static List<Bill> converStringToObject(List<String> list){
        List<Bill> billList = new ArrayList<>();
        for (String e:list){
            String[] temp = e.split(",");
            Bill bill = new Bill();
            bill.setId(temp[0]);
            bill.setDate(LocalDate.parse(temp[1]));
            bill.setNameCustomer(temp[2]);
            bill.setNameProduct(Collections.singletonList(temp[3]));
            bill.setQuantity(Collections.singletonList(temp[4]));
            bill.setAllPrice(Integer.parseInt(temp[5]));
            bill.setNameEmployee(temp[6]);
            billList.add(bill);
        }
        return billList;
    }
}
