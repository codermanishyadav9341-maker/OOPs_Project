package Encapsulation;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Circle {
    private double radius;

    //============Constructor==========
    public Circle(double radius){
        setRadius(radius);
    }

    //=========Getter&&Setter===========;
    public void setRadius(double radius){
        if(radius < 0){
            throw new IllegalArgumentException("Radius cannot be negative");
        }
         this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }

    public double getCircumference(){
        return 2*Math.PI*radius;
    }

    public double getDiameter(){
        return 2*radius;
    }

    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){

            System.out.print("Enter Radius:- ");
            double radius = scan.nextDouble();

            Circle  circle = new Circle(radius);

            //=======================Circle calculation============================
            System.out.println("===============================Circle Calculation============================");
            System.out.println("Area of circle:- " +circle.getArea());
            System.out.println("Circumference of circle:- " +circle.getCircumference());
            System.out.println("Diameter of circle:- " +circle.getDiameter());
        }
        catch (InputMismatchException e){
            System.out.println("Invalid! Please enter integer number");
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
