package com.company.menu;

import com.company.controllers.ScoreController;
import com.company.controllers.StudentController;

import java.util.Scanner;

public class Menu {
    public static void menu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What would you like to do now?");
        System.out.println( "1. Add new student");
        System.out.println("2. Get student by ID");
        System.out.println("3. Edit student's database");
        System.out.println("4. Delete student");
        System.out.println("5. Add a new score");
        System.out.println("6. Edit student's score");
        System.out.println("7. Delete score");

        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch(option){
            case 1:
                StudentController.addNewStudent();
                break;
            case 2:
                StudentController.getStudentById();
                break;
            case 3:
                StudentController.editStudent();
                break;
            case 4:
                StudentController.deleteStudent();
                break;
            case 5:
                ScoreController.addMarks();
                break;
            case 6:
                ScoreController.editScore();
                break;
            case 7:
                ScoreController.deleteScore();
                break;
            default:
                System.out.println("Invalid option selected");
        }
    }
}

