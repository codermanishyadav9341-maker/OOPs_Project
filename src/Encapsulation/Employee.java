package Encapsulation;

import java.util.Scanner;
public class Employee {
    private String name;
    private int employeeID;
    private double salary;
    private double bonus;

    //====================Constructor============================
    public Employee(String name,int employeeID,double salary,double bonus){
        setName(name);
        setEmployeeID(employeeID);
        setSalary(salary);
        setBonus(bonus);
    }

    //===========Getter && Setter;
    public void setName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot null or empty");
        }
         this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setEmployeeID(int employeeID){
        if(employeeID <= 0){
            throw new IllegalArgumentException("EmployeeID must greaterThan Zero");
        }
         this.employeeID = employeeID;
    }

    public int getEmployeeID(){
        return employeeID;
    }

    public void setSalary(double salary){
        if(salary <= 0){
            throw new IllegalArgumentException("Salary cannot be negative");
        }
         this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    public void setBonus(double bonus){
        if(bonus <= 0){
            throw new IllegalArgumentException("Bonus cannot be negative");
        }
         this.bonus = bonus;
    }

    public double getBonus(){
        return bonus;
    }

    public double getTotalPay(){
        return salary+bonus;
    }

    public void giveRaise(double percentage){
        if(percentage < 0){
            throw new IllegalArgumentException("Percentage cannot be negative");
        }
         this.salary  += salary*percentage/100;

    }


public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){

            System.out.print("Enter name:- ");
            String name = scan.nextLine();

            System.out.print("Enter ID:- ");
            int employeeID = scan.nextInt();
            scan.nextLine();

            System.out.print("Enter Salary:- ");
            double salary = scan.nextDouble();

            System.out.print("Enter Bonus:- ");
            double bonus = scan.nextDouble();

            Employee employee = new Employee(name,employeeID,salary,bonus);
            System.out.println("============================Employee======================================");
            System.out.println("Employee Name:- " +employee.getName());
            System.out.println("EmployeeID:- " +employee.getEmployeeID());
            System.out.println("Salary:- " +employee.getSalary());
            System.out.println("Bonus:- " +employee.getBonus());
            System.out.println("TotalPay:- " +employee.getTotalPay());

            System.out.print("Enter Raise:- ");
            double per = scan.nextDouble();
            employee.giveRaise(per);
            //System.out.println(employee.giveRaise(per))

        }
}

}
