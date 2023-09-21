/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.st10301625progpoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author totca
 */
public class StudentIT {
    
    public StudentIT() {
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Student.main(args);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDisplayMenu() {
        System.out.println("displayMenu");
        Student.displayMenu();
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddStudent() {
        System.out.println("addStudent");
        Student.addStudent();
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsNumeric() {
        System.out.println("isNumeric");
        String str = "5";
        boolean expResult = true;
        boolean result = Student.isNumeric(str);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsValidEmail() {
        System.out.println("isValidEmail");
        String email = "c@t.co.za";
        boolean expResult = false;
        boolean result = Student.isValidEmail(email);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testExitStudentApplication() {
        System.out.println("exitStudentApplication");
        Student.exitStudentApplication();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteStudent() {
        System.out.println("deleteStudent");
        Student.deleteStudent();
        fail("The test case is a prototype.");
    }

    @Test
    public void testSearchStudentByID() {
        System.out.println("searchStudentByID");
        Student.searchStudentByID();
        fail("The test case is a prototype.");
    }

    @Test
    public void testStudentReport() {
        System.out.println("studentReport");
        Student.studentReport();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetID() {
        System.out.println("getID");
        Student instance = null;
        String expResult = "";
        String result = instance.getID();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Student instance = null;
        String expResult = "Daniel";
        String result = instance.getName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Student instance = null;
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Student instance = null;
        String expResult = "c@t.co.za";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCourse() {
        System.out.println("getCourse");
        Student instance = null;
        String expResult = "";
        String result = instance.getCourse();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
