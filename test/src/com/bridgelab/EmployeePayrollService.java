package com.bridgelab;
import org.junit.Test;
import org.junit.jupiter.api.Assertion;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import static com.bridgelab.EmployeePayrollService.IOService.DB_IO;


public class EmployeePayrollService {
    @Test
    void  givenEmployeePayrollInDB_WhenRetrived__ShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(DB_IO);
        Assertions.assertArrayEquals(4, employeePayrollData.size());
    }
}
