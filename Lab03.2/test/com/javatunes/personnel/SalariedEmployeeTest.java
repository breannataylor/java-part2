package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    //fixture --> business object(s) under test
    private SalariedEmployee emp1;
    private SalariedEmployee emp2;

    @Before
    public void setUp() {
        emp1 = new SalariedEmployee("Bobbert", Date.valueOf("2023-10-31"), 1500.0);
        emp2 = new SalariedEmployee("Bobbert", Date.valueOf("2023-10-31"), 1500.0);
    }

    @Test
    public void hashCode_equalObjectsMustHaveEqualHashCodes() {
        assertEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameSalary() {
        emp2.setName("DIFFERENT");
        assertNotEquals(emp1,emp2);
        assertFalse(emp1.equals(emp2));
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        emp2.setHireDate(Date.valueOf("2022-10-15"));
        assertNotEquals(emp1,emp2);
        assertFalse(emp1.equals(emp2));
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        emp2.setSalary(1000.0);
        assertNotEquals(emp1,emp2);
        assertFalse(emp1.equals(emp2));
    }

    @Test
    public void equals_shouldReturnTrue_AllPropertiesSames() {
        assertEquals(emp1, emp2);       //this does an equals() check
        assertTrue(emp1.equals(emp2));  //alternative assertion
    }

    @Test
    public void testPay() {
        assertEquals(1500.0, emp1.getSalary(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(450.00, emp1.payTaxes(), .001); //(expected, returned) 30% of the salary
    }
}