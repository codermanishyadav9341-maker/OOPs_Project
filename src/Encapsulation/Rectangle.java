package Encapsulation;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Rectangle {
    private double length;
    private double width;

    //=============Constructor===========
    public Rectangle(double length,double width){
        setLength(length);
        setWidth(width);
    }

    //=========Getter&&Setter==========
    public void setLength(double length){
        if(length < 0){
            throw new IllegalArgumentException("Length cannot be negative");
        }
         this.length = length;
    }

    public double getLength(){
        return length;
    }

    public void setWidth(double width){
        if(width < 0){
            throw new IllegalArgumentException("Width cannot be negative");
        }
         this.width = width;
    }

    public double getWidth(){
        return width;
    }


    public double getArea(){
        return length*width;
    }

    public double getPerimeter(){
        return 2*(length+width);
    }

    public boolean isSquare(){
        return length == width;
    }

    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){

            System.out.print("Enter Length:- ");
            double length = scan.nextDouble();

            System.out.print("Enter Breadth:- ");
            double width = scan.nextDouble();

            Rectangle rectangle = new Rectangle(length,width);

            System.out.println("Area of Rectangle:- " +rectangle.getArea());
            System.out.println("Perimeter of Rectangle:- " +rectangle.getPerimeter());
            System.out.println("Area of Square:- " +rectangle.isSquare());

        }
        catch(InputMismatchException e){
            System.out.println("Invalid! Please enter valid number value");
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
