package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    //fixture --> business object(s) under test
    private HourlyEmployee emp;

    @Before
    public void setUp() {
        emp = new HourlyEmployee("Amilia", Date.valueOf("2023-10-31"), 25.00, 30.0);
    }

    @Test
    public void testPay() {
        assertEquals(750.0, emp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(187.50, emp.payTaxes(), .001);

    }
}