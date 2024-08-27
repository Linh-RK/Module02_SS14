package bai_tap.ex03.presentation;

import bai_tap.ex03.ICompany.IDepartment;
import bai_tap.ex03.entity.Department;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentManagement implements IDepartment {
    Scanner sc = new Scanner(System.in);
    public static List<Department> departmentList = new ArrayList<>();
    static {
        departmentList.add(new Department("D001", "Sale", 3 ));
        departmentList.add(new Department("D002", "Marketing", 2 ));
        departmentList.add(new Department("D003", "Assy", 3 ));
    }
    @Override
    public void displayAll() {
        if (departmentList.size() == 0) {
            System.out.println("Department List is empty");
        } else {
            for (Department department : departmentList) {
                department.displayDepartment();
            }
        }
    }

    @Override
    public void addNew() {
        System.out.println("Add the number of department you want to add");
        int number = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < number; i++) {
            Department department = new Department();
            department.inputDep(sc,departmentList);
        }
        System.out.println("Successfully !");
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public Object findById(Object id) {
        return null;
    }
}
