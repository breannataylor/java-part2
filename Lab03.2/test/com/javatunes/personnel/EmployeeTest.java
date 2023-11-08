package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp1;
    private Employee emp2;

    @Before
    public void setUp() {
//        emp1 = new DummyEmployee("Ben", Date.valueOf("2023-10-12"));
//        emp2 = new DummyEmployee("Ben", Date.valueOf("2023-10-12"));
        emp1 = new Employee() {
            @Override
            public double pay() {
                return 0;
            }

            @Override
            public double payTaxes() {
                return 0;
            }
        };

        emp2 = new Employee() {
            @Override
            public double pay() {
                return 0;
            }

            @Override
            public double payTaxes() {
                return 0;
            }
        };
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("Barbara");
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2023-02-02"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp1,emp2);
    }

    //basement apartment - NAMED, MEMBER LEVEL INNER CLASS
    private static class DummyEmployee extends Employee{
        //we don't care about pay() and payTaxes(), we aren't testing them
        //we only care about Employee name and hireDate

        DummyEmployee (String name, Date hireDate){
            super(name, hireDate);
        }

        public double pay() {
            return 0;
        }
        public double payTaxes() {
            return 0;
        }
    }
}