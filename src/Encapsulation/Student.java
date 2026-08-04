package Encapsulation;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Student {
    private String name;
    private int rollNumber;
    private double mathGrade;
    private double scienceGrade;
    private double englishGrade;

    //==========Constructor============
    public  Student(String name,int rollNumber){
        this.name = name;
        this.rollNumber = rollNumber;
        setMathGrade(mathGrade);
        setScienceGrade(scienceGrade);
        setEnglishGrade(englishGrade);
    }

    public void setMathGrade(double mathGrade){
        if(mathGrade < 0 || mathGrade > 100){
            throw new IllegalArgumentException("MathGrade must be between 0 and 100");
        }
         this.mathGrade = mathGrade;
    }

    public void setScienceGrade(double scienceGrade){
        if(scienceGrade < 0 || scienceGrade >100){
            throw new IllegalArgumentException("ScienceGrade must be between 0 and 100");
        }
         this.scienceGrade = scienceGrade;
    }

    public void setEnglishGrade(double englishGrade){
        if(englishGrade < 0 || englishGrade > 100){
            throw new IllegalArgumentException("EnglishGrade must be between 0 and 100");
        }
         this.englishGrade = englishGrade;
    }

    public String getName(){
        return name;
    }

    public int getRollNumber(){
        return rollNumber;
    }

    public double getMathGrade(){
        return mathGrade;
    }

    public double getScienceGrade(){
        return scienceGrade;
    }

    public double getEnglishGrade(){
        return englishGrade;
    }

    public double getAverageGrade(){
        return mathGrade+scienceGrade+englishGrade/3.0;
    }

    public String getLetterGrade(){
        double avg = getAverageGrade();
        if(avg >= 90){
            return "A";
        }
         else if(avg >= 80){
             return "B";
        }
         else if(avg >= 70){
             return "C";
        }
         else if(avg >= 60){
             return "D";
        }
         else {
             return "fail";
        }

    }

    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){

            System.out.print("Enter Student Name:- ");
            String name = scan.nextLine();

            System.out.print("Enter RollNumber:- ");
            int rollNumber = scan.nextInt();

            System.out.print("Enter MathMarks:- ");
            double mathGrade = scan.nextDouble();

            System.out.print("Enter ScienceGrade:- ");
            double scienceGrade = scan.nextDouble();

            System.out.print("Enter EnglishGrade:- ");
            double englishGrade = scan.nextDouble();

            Student student = new Student(name,rollNumber);
            student.setMathGrade(mathGrade);
            student.setScienceGrade(scienceGrade);
            student.setEnglishGrade(englishGrade);

            System.out.println("=================================:Report Card:=================================");
            System.out.println("Student Name:- " +student.getName());
            System.out.println("RollNumber:- " +student.getRollNumber());
            System.out.println("MathMarks:- " +student.getMathGrade());
            System.out.println("ScienceMarks:- " +student.getScienceGrade());
            System.out.println("EnglishMarks:- " +student.getEnglishGrade());
            System.out.println("Average Marks:- " +student.getAverageGrade());
            System.out.println("Grade:- " +student.getLetterGrade());
        }
        catch(InputMismatchException e){
            System.out.println("Invalid! Please enter numeric valid number");
        }
        catch(IllegalArgumentException e ){
            System.out.println(e.getMessage());
        }
    }
}
