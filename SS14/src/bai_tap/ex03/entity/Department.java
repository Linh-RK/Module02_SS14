package bai_tap.ex03.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Department {
    public List<Department> departmentList = new ArrayList<>();
    private String departmentId;
    private String departmentName;
    private int totalMembers;

    public Department() {
    }

    public Department(String departmentId, String departmentName, int totalMembers) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.totalMembers = totalMembers;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }
    public void inputDep(Scanner sc, List<Department> departmentList) {
        this.departmentId = inputDepartmentId(sc, departmentList);
        this.departmentName = inputDepartmentName(sc,departmentList);
        this.totalMembers = inputTotalMembers(sc);
    }
    public void displayDepartment() {

        System.out.printf("| %-10s | %-15s | %-5s |",this.departmentId, this.departmentName, this.totalMembers);
        System.out.println("------------------------------------------------------");
    }

    private int inputTotalMembers(Scanner sc) {
        System.out.println("Enter Total Members:");
        String total = inputString(sc);
        do{
            try {
                return Integer.parseInt(total);
            }catch(NumberFormatException e) {
                System.err.println("Total Members must be an integer");
            }
        }while (true);
    }

    private String inputDepartmentName(Scanner sc, List<Department> department) {
        System.out.println("Enter department name: ");
        do{
            String departmentName = inputString(sc);
            boolean isExist = department.stream().anyMatch(employee -> employee.getDepartmentId().equals(departmentName));
            if (!isExist){
                return departmentName;
            }else {
                System.err.println("Department already exists!");
            }
        }while(true);

    }
    private static String inputString(Scanner sc) {
        String string = "";
        do {
            string = sc.nextLine();
            if(string.isEmpty()){
                System.err.println("Data can't be empty!");
            } else
                return string;
        }while(true);
    }
    private String inputDepartmentId(Scanner sc,List<Department> department) {
        System.out.println("Enter department ID (Dxxx)");
        Pattern pattern = Pattern.compile("^D\\w{3}$");
        String depId = "";
        do {
            depId = sc.nextLine();
            if (!pattern.matcher(depId).find()) {
                System.err.println("Department ID must be Dxxx");
            } else{
                String finalDepId = depId;
                boolean isExist = department.stream().anyMatch(employee -> employee.getDepartmentId().equals(finalDepId));
                if(isExist){
                    System.err.println("Employee ID already exist");
                }else
                    return depId;
            }
        }
        while(true);
    }


}
