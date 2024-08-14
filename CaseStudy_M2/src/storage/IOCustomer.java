package storage;

import model.Customer;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IOCustomer {
    private static final String CUSTOMER_PATH = "Data/customer.csv";
    public static List<Customer> readFromFile(){
        List<String> listString = new ArrayList<String>();
        try(FileReader fileReader = new FileReader(CUSTOMER_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
          String line = "";
          while ((line = bufferedReader.readLine())!= null){
              listString.add(line);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return converStringToObject(listString);
    }


    public static List<Customer> converStringToObject(List<String> list){
        List<Customer> customerList = new ArrayList<>();
        for (String c:list){
            String[] temp = c.split(",");
            Customer customer = new Customer();
//            id, name, birthDay, gender, phoneNumber, email
            customer.setId(temp[0]);
            customer.setName(temp[1]);
            customer.setBirthDay(LocalDate.parse(temp[2]));
            customer.setPhoneNumber(temp[3]);
            customer.setEmail(temp[4]);
            customerList.add(customer);
        }
        return customerList;
    }

    public static void writeToFile(List<Customer> customerList){
        try(FileWriter fileWriter = new FileWriter(CUSTOMER_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
        {
           for (Customer c:customerList){
               bufferedWriter.write(c.getId());
               bufferedWriter.write(",");
               bufferedWriter.write(c.getName());
               bufferedWriter.write(",");
               bufferedWriter.write(String.valueOf(c.getBirthDay()));
               bufferedWriter.write(",");
               bufferedWriter.write(c.getPhoneNumber());
               bufferedWriter.write(",");
               bufferedWriter.write(c.getEmail());
               bufferedWriter.newLine();
           }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
