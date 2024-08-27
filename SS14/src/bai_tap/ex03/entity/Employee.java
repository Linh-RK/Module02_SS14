package bai_tap.ex03.entity;

import java.rmi.ServerError;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Employee {
    public static List<Employee> employeeList = new ArrayList<>();
    public Department departmentA = new Department();
    private String employeeId;
    private String employeeName;
    private static LocalDate birthday;
    private boolean sex;
    private double salary;
    private Employee manager;
    private Department department;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, LocalDate birthday, boolean sex, double salary, Employee manager, Department department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.sex = sex;
        this.salary = salary;
        this.manager = manager;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    public void inputData(Scanner sc, ArrayList<Employee> employeeList, ArrayList<Department> department){
        this.employeeId = inputEmployeeId(sc, employeeList);
        this.employeeName = inputEmployeeName(sc);
        birthday = inputBirthday(sc);
        this.sex = inputSex(sc);
        this.salary = inputSalary(sc);
//        this.manager = inputManager(sc, employeeList);
        this.department = inputDepartment(sc,department);
    }
    public  void displayEmployee(){
        System.out.printf("| %-10s | %-20s |",this.employeeId,this.employeeName);
        System.out.println("---------------------------------------------------");
    }
    public  void displayEmployeeDetail(){
        System.out.printf("| %-10s | % -20s | %-12s | %-8s | %-10.2f | %-10s |",
                this.employeeId,this.employeeName, birthday, this.sex? "male" :"female", this.salary,this.department.getDepartmentName());
        System.out.println("-----------------------------------------------------------------------------");}

    private Department inputDepartment(Scanner sc, ArrayList<Department> departmentList) {
        System.out.println("Department in company");
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.printf("| STT: %-10s | Dep: %-15s |", i+1, departmentList.get(i).getDepartmentName());
        }
        while(true){
            System.out.println("Enter ordinal number of Department: ");
            int ordinal = inputNum(sc);
            if(ordinal< 0 || ordinal >= departmentList.size()){
                System.out.println("Invalid Input");
            } else{
                Department departmentSelected = departmentList.get(ordinal-1);
                departmentSelected.setTotalMembers(departmentSelected.getTotalMembers() + 1);
                return departmentSelected;
            }
        }
    }

    private int inputNum(Scanner sc) {
        String num = "";
        while(true){
            System.out.println("Enter number: ");
             num = sc.nextLine();
            if(num.isEmpty()){
                System.err.println("Data  cannot be empty");
            } else {
                try{
                    int input = Integer.parseInt(num);
                    if(input < 0 ){
                        System.err.println("Data cannot be negative");
                    } else
                        return input;
                }catch (Exception e){
                    System.err.println("Please input a integer");
                }
            }

        }
    }

    private Employee inputManager(Scanner sc,ArrayList<Employee> employeeList) {
        System.out.println("Enter manager's id:");
        String managerId = sc.nextLine();
        if (managerId.isEmpty()) {
            return null;
        }else {

                boolean isExist = employeeList.stream().anyMatch(employee -> employee.getEmployeeId().equals(managerId));
                if (isExist){
                    return employeeList.stream().filter(employee -> employee.getEmployeeId().equals(managerId)).findFirst().get();
                }
            }

        return null;
    }

    private double inputSalary(Scanner sc) {
        System.out.println("Employee Salary:");
        String salaryStr = inputString(sc);
       do{
           try{
               return Double.parseDouble(salaryStr);
           }
           catch(Exception e){
               System.err.println("Salary must be double");
           }

       }while (true);
    }

    private static boolean inputSex(Scanner sc) {
        System.out.println("Enter employee's gender(true: male, false: female):");
        do {
            String gender = sc.nextLine();
            if((gender.equals("true") || gender.equals("false"))) {
                return Boolean.parseBoolean(gender);
            } else
                System.out.println("Gender must be either 'male' or 'female'");
        }while(true);
    }

    private static LocalDate inputBirthday(Scanner sc) {
        System.out.println("Enter birthday: ");
        String date = inputString(sc);
        return LocalDate.parse(date);
    }

    private static String inputString(Scanner sc) {
        String string = "";
        do {
            string = sc.nextLine();
            if(string.isEmpty()){
                System.out.println("Data can't be empty!");
            } else
                return string;
        }while(true);
    }

    private static String inputEmployeeName(Scanner sc) {
        String employeeName ="";
        do {
            System.out.println("Enter employee name: ");
             employeeName = sc.nextLine();
            if (employeeName.isEmpty()) {
                System.out.println("Employee name can not be empty!");
                break;
            } else
                return employeeName;
        }while(true);
        return employeeName;
    }

    //    ----------------
    private static String inputEmployeeId(Scanner sc, ArrayList<Employee> employeeList) {
        System.out.println("Enter employee ID (Exxxx)");
        Pattern pattern = Pattern.compile("^E\\w{4}");
        String employeeId = "";
        do {
            employeeId = sc.nextLine();
            if (!pattern.matcher(employeeId).find()) {
                System.out.println("Employee ID must be Exxxx");
            } else{
                String finalEmployeeId = employeeId;
                boolean isExist = employeeList.stream().anyMatch(employee -> employee.getEmployeeId().equals(finalEmployeeId));
                if(isExist){
                    System.out.println("Employee ID already exist");
                }else 
                    return employeeId;
            }
        }
        while(true);
    }
//    ----------------
}
