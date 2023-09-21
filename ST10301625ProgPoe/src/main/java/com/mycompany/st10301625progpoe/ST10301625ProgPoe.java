

package com.mycompany.st10301625progpoe;



public class ST10301625ProgPoe { 
    
    public static void main(String[] args) {
        Student.displayMenu();
        //Calling the student class to this class
        
    }
    // Private declaration of instance variables
    private String id;
    private String name;
    private int age;
    private String email;
    private String course;

    //constructor to initialize variables
    public ST10301625ProgPoe(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }
// Getter method for retrieving the student's ID
    public String getId() {
        return id;
    }
// Getter method for retrieving the student's Name
    public String getName() {
        return name;
    }
// Getter method for retrieving the student's Age
    public int getAge() {
        return age;
    }
// Getter method for retrieving the student's email
    public String getEmail() {
        
        
        
        return email;
    }
// Getter method for retrieving the student's course
    public String getCourse() {
        return course;
    }
}
 
    



    
