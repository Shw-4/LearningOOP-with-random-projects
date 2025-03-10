package com.mycompany.grademanagementsystem;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Student {   
    Scanner userInput = new Scanner(System.in);
    
    //Student related data
    int StudentID;
    int GradeLevel;
    String StudentName;
    String Strand;
    
    //Subject related data
    HashMap<String, Integer> Sub_Grade = new HashMap(); //HashMap for list of subjects for unknown strands
    String[] STEM_Subjects = {}; //STEM SUBJECTS
    String[] ICT_Subjects = {}; //TVL-ICT SUBJECTS
    
     Student(int StudentID, String StudentName, int gradeLevel) {
        this.StudentID = StudentID;
        this.StudentName = StudentName;
        this.GradeLevel = gradeLevel;
    }
    
    Student(int StudentID, String StudentName, int gradeLevel, String strand) {
        this.StudentID = StudentID;
        this.StudentName = StudentName;
        this.GradeLevel = gradeLevel;
        this.Strand = strand;
    }
    
    public void addSubjects(int numberOfSubjects) {
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter Subject Name: ");
            String subject = userInput.nextLine();
            
            System.out.print("Enter Grade for that Subject: ");
            int grade = userInput.nextInt();
            
            userInput.nextLine();
            
            Sub_Grade.put(subject, grade);
        }
    }
    
    public void removeSubjects(int numberOfSubjects) {
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Subject to remove: ");
            String subject = userInput.nextLine();
            
            Sub_Grade.remove(subject);
        }
    }
    
    public void displayStudentDetails() {
        System.out.println("------ [ STUDENT: " + this.StudentName + " ] ------");
        System.out.println("ID: " + this.StudentID);
        System.out.println("Grade Level: " + this.GradeLevel);
        System.out.println("Strand: " + this.Strand);
        System.out.println("Subjects & Grades: ");
        for (Map.Entry entry : Sub_Grade.entrySet()) {
            System.out.println("-> " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("");
        
    }
    
    public int getStudentID() {
        return this.StudentID;
    }
}
