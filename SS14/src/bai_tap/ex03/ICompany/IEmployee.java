package bai_tap.ex03.ICompany;

import bai_tap.ex03.entity.Employee;

public interface IEmployee extends ICompany <Employee,String>{
    void displayById();
    void displayEmployeeByDepartment();
    void getAvgEmployeesPerDepartment();
    void oldestEmployee5();
    void highestSalary5();
    void departmentCrowded5();
}
