package storage;

import model.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IOEmployee {
    private static final String EMPLOYEE_PATH = "Data/employee.csv";
    public static List<Employee> readFromFile(){
        List<String> listString = new ArrayList<String>();
        try(FileReader fileReader = new FileReader(EMPLOYEE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
           String line = "";
           while ((line = bufferedReader.readLine()) != null){
               listString.add(line);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return converStringToObject(listString);
    }

    public static List<Employee> converStringToObject(List<String> list){
        List<Employee> employeeList = new ArrayList<>();
        for (String e:list){
            String[] temp = e.split(",");
            Employee employee = new Employee();
            employee.setId(temp[0]);
            employee.setName(temp[1]);
            employee.setBirthDay(LocalDate.parse(temp[2]));
            employee.setPhoneNumber(temp[3]);
            employee.setEmail(temp[4]);
            employee.setDuty(temp[5]);
            employeeList.add(employee);
        }
        return employeeList;
    }

    public static void writeToFile(List<Employee> employeeList){
        try (FileWriter fileWriter = new FileWriter(EMPLOYEE_PATH);
              BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
        {
            for (Employee e:employeeList){
                bufferedWriter.write(e.getId());
                bufferedWriter.write(",");
                bufferedWriter.write(e.getName());
                bufferedWriter.write(",");
                bufferedWriter.write(String.valueOf(e.getBirthDay()));
                bufferedWriter.write(",");
                bufferedWriter.write(e.getPhoneNumber());
                bufferedWriter.write(",");
                bufferedWriter.write(e.getEmail());
                bufferedWriter.write(",");
                bufferedWriter.write(e.getDuty());
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
