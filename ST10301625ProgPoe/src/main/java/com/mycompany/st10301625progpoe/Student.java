package com.mycompany.st10301625progpoe;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Iterator;

public class Student { 

    private String ID;
    private String name;
    private int age;
    private String email;
    private String course;

    private static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        // Declaration of the menu message 
        String menuMessage = "Student Management Application\n"
                + "***************************************************************\n"
                + "Please select 1 of the following items:\n"
                + "(1) Add a new student\n"
                + "(2) Search for a student\n"
                + "(3) Delete a student\n"
                + "(4) Print student report\n"
                + "(5) Exit Application\n";

        int choice;
        try {
            choice = Integer.parseInt(JOptionPane.showInputDialog(menuMessage));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid menu choice.");
            displayMenu();
            return;
        }

        switch (choice) {
            case 1:
                // Add a new student
                addStudent();
                break;

            case 2:
                // Search for a student by ID
                searchStudentByID();
                break;

            case 3:
                // Delete a student by ID
                deleteStudent();
                break;

            case 4:
                // Print student report
                studentReport();
                break;

            case 5:
                // Exit the application
                exitStudentApplication();
                break;

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please select a valid menu option.");
                break;
        }
    }

    public static void addStudent() {
        // Continue adding students until the user decides to exit
     
    while (true) { // Continue adding students until the user decides to exit
        String id = null;
        String name = null;
        String ageStr = null;
        String email = null;
        String course = null;

        // Loop until a unique student ID is entered
        while (true) {
            boolean isDuplicate = false;

            // Prompts the user for the student ID and validates it
            while (id == null || id.trim().isEmpty()) {
                id = JOptionPane.showInputDialog("Enter the student id:");
                if (id == null) {
                    exitStudentApplication();
                    return;
                }
            }

            // Checks if the entered ID is a duplicate
            for (Student student : studentList) {
                if (student.getID() != null && student.getID().equals(id)) {
                    isDuplicate = true;
                    JOptionPane.showMessageDialog(null, "Student with ID " + id + " already exists. Please enter a different ID.");
                    id = null; // Reset ID to null to prompt the user for a new one
                    break;
                }
            }

            if (!isDuplicate) {
                break; // Unique ID, exit the loop
            }
        }
    //Prompts the user to enter name
        while (name == null || name.trim().isEmpty()) {
            name = JOptionPane.showInputDialog("Enter the student name:");
            if (name == null) {
                name = JOptionPane.showInputDialog("Invalid input, please enter valid student name:");
                exitStudentApplication();
                return;
            }
        }
    //Prompts the user to enter student age
        while (true) {
            ageStr = JOptionPane.showInputDialog("Enter the student age:");
            if (ageStr == null) {
                ageStr = JOptionPane.showInputDialog("Invalid input! Please enter a valid age: ");
                exitStudentApplication();
                return;
            }
    //Checks if the user age is an integer
            if (isNumeric(ageStr)) {
                int ageValue = Integer.parseInt(ageStr);
                if (ageValue >= 16) {
                    break; // Valid age, exit the loop
                } else {
                    JOptionPane.showMessageDialog(null, "You have entered an incorrect student age!!!\nPlease re-enter the student age.");
                    ageStr = null; // Reset ageStr to null to prompt the user for a new age
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid age data type. Please enter a valid number.");
                ageStr = null; // Reset ageStr to null to prompt the user for a new age
            }
        }
    //Prompts the user to enter student's email
        while (email == null || !isValidEmail(email)) {
            email = JOptionPane.showInputDialog("Enter the student email:");
            if (email == null) {
                exitStudentApplication();
                return;
            }
    //Checks if the student's email is valid
            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Invalid email format. Please enter a valid email.");
                email = null; // Reset email to null to prompt the user for a new email
            }
        }
    //Prompts the user to enter student's course
        while (course == null || course.trim().isEmpty()) {
            course = JOptionPane.showInputDialog("Enter the student course:");
            if (course == null) {
                course = JOptionPane.showInputDialog(null,"Incorrect input! Please enter a course");
                exitStudentApplication();
                return;
            }
        }

        // Create a new Student object and add it to the studentList
        Student student = new Student(id, name, Integer.parseInt(ageStr), email, course);
        studentList.add(student);

        JOptionPane.showMessageDialog(null, "Student details have been successfully saved.");

        // Ask the user if they want to add another student or return to the menu
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to add another student?", "Add Another Student", JOptionPane.YES_NO_OPTION);

        if (choice != JOptionPane.YES_OPTION) {
            break; // Exit the loop if the user doesn't want to add another student
        }
    }
    
    // Return to the main menu
    displayMenu();
}


    
//Checks if the user entered a number as Age
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
//Checks if the student's email is valid
    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }
//Method to exit application 
    public static void exitStudentApplication() {
        JOptionPane.showMessageDialog(null, "Exiting the program.");
        System.exit(0);
    }
//Method to delete Student's details
    public static void deleteStudent() {
        String idString = JOptionPane.showInputDialog("Enter the Student ID to delete:");
        String idToDelete = null;
        try {
            idToDelete = idString;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a valid integer ID.");
            return;
        }
    // Framework to iterate through elements in a collection 
        Iterator<Student> iterator = studentList.iterator();
        boolean studentFound = false;

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getID().equals(idToDelete)) {
                iterator.remove();
                JOptionPane.showMessageDialog(null, "Student with ID " + idToDelete + " deleted successfully.");
                studentFound = true;
                break;
            }
        }
//Checks if a student's ID not found
        if (!studentFound) {
            JOptionPane.showMessageDialog(null, "Student with ID " + idToDelete + " not found.");
        }
        displayMenu();
    }
//Method to search for a Studen by using their ID
    public static void searchStudentByID() {
        String idString = JOptionPane.showInputDialog("Enter the Student ID to search:");
        String idToSearch = null;
//Checks if a student's ID entered is the incorrect format        
        try {
            idToSearch = idString;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a valid integer ID.");
            return;
        }

        Iterator<Student> iterator = studentList.iterator();
        boolean studentFound = false;

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getID().equals(idToSearch)) {
                JOptionPane.showMessageDialog(null, "Student ID: " + student.getID() + "\nName: " + student.getName() + "\nAge: " + student.getAge() + "\nEmail: " + student.getEmail() + "\nCourse: " + student.getCourse());
                studentFound = true;
                break;
            }
        }
    //Displays error message if student's ID not found
        if (!studentFound) {
            JOptionPane.showMessageDialog(null, "Student with ID " + idToSearch + " not found.");
        }
        displayMenu();
    }
//Method to display studen't report
    public static void studentReport() {
    if (studentList.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No students have been entered.");
    } else {
        StringBuilder report = new StringBuilder();

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            report.append("STUDENT ").append(i + 1).append("\n");
            report.append("--------‐‐----------------------------------------------------------\n");
            report.append("STUDENT ID: ").append(student.getID()).append("\n");
            report.append("STUDENT NAME: ").append(student.getName()).append("\n");
            report.append("STUDENT AGE: ").append(student.getAge()).append("\n");
            report.append("STUDENT EMAIL: ").append(student.getEmail()).append("\n");
            report.append("STUDENT COURSE: ").append(student.getCourse()).append("\n");
            report.append("--------‐‐----------------------------------------------------------\n");
        }

        // Display the report
        JOptionPane.showMessageDialog(null, report.toString());
    }
    
    // Return to the main menu
    displayMenu();
}

    

    public Student(String ID, String name, int age, String email, String course) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }
}



