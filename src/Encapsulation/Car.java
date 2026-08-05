package Encapsulation;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Car {
    private String make;
    private String model;
    private int year;
    private int mileage;
    private double fuelLevel;
    private static final double MAX_FUEL_CAPACITY = 15.0;

    //=============Constructor========================
    public Car(String make,String model,int year,int mileage,double fuelLevel){
        setMake(make);
        setModel(model);
        this.year = year;
        if(mileage < 0){
            throw new IllegalArgumentException("Mileage can be greater than 0");
        }
        this.mileage  = mileage;

        if(fuelLevel < 0){
            throw new IllegalArgumentException("FuelLevel must be greater than 0");
        }
        this.fuelLevel = fuelLevel;
    }
    public void setMake(String make){
        if(make == null || make.trim().isEmpty()){
            throw new IllegalArgumentException("Make cannot be null or empty");
        }
         this.make = make;
    }

    public String getMake(){
        return make;
    }

    public void setModel(String model){
        if(model == null || model.trim().isEmpty()){
            throw new IllegalArgumentException("Model cannot be null or empty");
        }
         this.model = model;
    }

    public String getModel(){
        return model;
    }

    public int getYear(){
        return year;
    }

    public int getMileage(){
        return mileage;
    }

    public void addFuel(double gallons){
        if(gallons < 0){
            throw new IllegalArgumentException(("Gallons must be greater than zero"));
        }
         else if(fuelLevel + gallons > MAX_FUEL_CAPACITY){
            throw new IllegalArgumentException("Tank capacity exceed");
        }
         this.fuelLevel += gallons;
         System.out.println("FuelAdded Successful");
         System.out.println("Current fuel:- " +fuelLevel+ " gallons");
    }

    public void drive(double miles){
        if(miles <= 0){
            throw new IllegalArgumentException("Miles must be greaterThan Zero");
        }
        this.fuelLevel -= miles;
        System.out.println("Increase fuel:- " +fuelLevel+ " gallons");
    }

    public double getFuelLevel(){
        return fuelLevel;
    }

    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){

            System.out.print("Enter Make:- ");
            String make = scan.nextLine();

            System.out.print("Enter model:- ");
            String model = scan.nextLine();

            System.out.print("Enter Year:- ");
            int year = scan.nextInt();
            scan.nextLine();

            System.out.print("Enter mileage:- ");
            int mileage = scan.nextInt();
            scan.nextLine();

            System.out.print("Enter fuelLevel:- ");
            double fuelLevel = scan.nextDouble();
            scan.nextLine();

            Car car = new Car(make,model,year,mileage,fuelLevel);
            System.out.println("==========================Car Info=============================");
            System.out.println("Make:- " +car.getMake());
            System.out.println("Model:- " +car.getModel());
            System.out.println("Year:- " +car.getYear());
            System.out.println("Mileage:- " +car.getMileage()+ "km/hr");
            System.out.println("FuelLevel:- " +car.getFuelLevel()+ " gallons");

            System.out.print("Enter Add fuel:- ");
            double addFuel = scan.nextDouble();
            scan.nextLine();
            car.addFuel(addFuel);

            System.out.print("Enter miles:- ");
            double miles = scan.nextDouble();
            scan.nextLine();
            car.drive(miles);
        }
        catch(InputMismatchException e){
            System.out.println("!Invalid Please enter numeric valid number");
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
