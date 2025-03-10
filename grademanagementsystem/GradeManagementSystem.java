//TODO
/*

-CLEAN CODE
-SET FIXED SUBJECTS FOR STUDENTS WITH STRANDS
-GRADE CALCULATOR

*/
package com.mycompany.grademanagementsystem;

import java.util.Scanner;
import java.util.HashMap;

public class GradeManagementSystem {
    
    static HashMap<Integer, Student> studentsData = new HashMap();
    static Scanner userInput = new Scanner(System.in);
    static Utils utils = new Utils();
    static Student student;
    
    public static void main(String[] args) {
        
        int command, studentId, gradeLevel;
        
        String StudentName;
        String Strand = "None";
        
        do {
            utils.cls();
            
            System.out.println("|                         |");
            System.out.println("| GRADE MANAGEMENT SYSTEM |");
            System.out.println("|                         |");
            
            System.out.println("1 - Enroll a Student");
            System.out.println("2 - Get Student Info");
            System.out.println("3 - Exit");
            
            System.out.print("Operation: ");
            command = userInput.nextInt();
            
            userInput.nextLine(); //clear prompt so it doesn't skip
            
            switch (command) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    StudentName = userInput.nextLine();
                    
                    System.out.print("Enter Student ID: ");
                    studentId = userInput.nextInt();
                    
                    System.out.print("Enter Grade Level: ");
                    gradeLevel = userInput.nextInt();
                    
                    if (gradeLevel > 10) {
                        userInput.nextLine();
                        System.out.print("Enter Strand: ");
                        Strand = userInput.nextLine();
                    }
                    
                    System.out.println("Student Enrolled.");
                    utils.sleep(2);
                    
                    studentsData.put(studentId, new Student(studentId, StudentName, gradeLevel, Strand));
                                       
                    break;
                case 2:
                    utils.cls();
                    
                    System.out.print("Enter Student ID: ");
                    studentId = userInput.nextInt();
                    
                    student = studentsData.get(studentId);
                    
                    student.displayStudentDetails();
                    
                    System.out.println("0 - Go Back");
                    System.out.println("1 - Add Subject/s");
                    System.out.println("2 - Remove Subject/s");
                    
                    System.out.print("Operation: ");
                    command = userInput.nextInt();
                    
                    if (command == 1) {
                        System.out.print("How many subjects?: ");
                        int numberofSubjects = userInput.nextInt();
                        
                        student.addSubjects(numberofSubjects);
                    } else if (command == 2) {
                        System.out.print("Amount of subjects to remove: ");
                        int numberofSubjects = userInput.nextInt();
                        
                        student.removeSubjects(numberofSubjects);
                    }
                    
                    break;
            }
            
        } while (command != 3);
        
    
    }
}
