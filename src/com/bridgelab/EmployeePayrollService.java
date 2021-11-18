package com.bridgelab;
import java.util.List;

public class EmployeePayrollService {
    EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();
    public  enum  IOService {
        DB_IO

    }
    private List<EmployeePayrollData> employeePayrollDataList;
    public EmployeePayrollService() {

    }
    /* To get the list of employee payroll from the database*/
    public List<EmployeePayrollData> readEmployeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.DB_IO))
            this.employeePayrollDataList = employeePayrollDBService.readData();
        return this.employeePayrollDataList;
    }

}
