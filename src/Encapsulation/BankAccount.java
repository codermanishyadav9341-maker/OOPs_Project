package Encapsulation;

import java.util.InputMismatchException;
import java.util.Scanner;
public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    double balance;

    //============Constructor================
    public BankAccount(String accountNumber ,String accountHolderName,double balance){
        setAccountNumber(accountNumber);
        setAccountHolderName(accountHolderName);
       if(balance < 0){
           throw new IllegalArgumentException("Initial balance cannot be negative");
       }
        this.balance = balance;
    }

    //======Getter&&Setter;
    public void setAccountNumber(String accountNumber){
        if(!accountNumber.matches("\\d{10}")){
            throw new IllegalArgumentException("AccountNumber cannot be empty or null");
        }
         this.accountNumber = accountNumber;
    }


    public void setAccountHolderName(String accountHolderName){
        if(accountHolderName == null || accountHolderName.trim().isEmpty()){
            throw new IllegalArgumentException("AccountHolderName cannot be null or empty");
        }
         this.accountHolderName = accountHolderName;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void deposit(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount can be greater than Zero");
        }
         this.balance += amount;
        System.out.println("----Deposit Successful----");
    }

    public void withDraw(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount can be greater than Zero");
        }
         else if(amount > balance){
             System.out.println("Insufficient balance");
        }
         else{
             this.balance -= amount;
             System.out.println("-----WithDraw Successful------");
        }
    }

    public double getBalance(){
        return balance;
    }

//    public String toString(){
//
//    }

    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){

            System.out.print("Enter Account number:- ");
            String accountNumber = scan.nextLine();

            System.out.print("Enter AccountHolderName:- ");
            String accountHolderName = scan.nextLine();

            System.out.print("Enter Balance:- ");
            double balance = scan.nextDouble();
            scan.nextLine();


            BankAccount bankAccount = new BankAccount(accountNumber,accountHolderName,balance);
           // bankAccount.deposit(balance);
            System.out.println("==========================Bank Account===========================");
            System.out.println("AccountNumber:- " +bankAccount.getAccountNumber());
            System.out.println("AccountHolderName:- " +bankAccount.getAccountHolderName());
            System.out.println("Balance:- " +bankAccount.getBalance());

            System.out.print("Enter Deposit amount:- ");
            double deposit = scan.nextDouble();
            bankAccount.deposit(deposit);
            System.out.println("Total Balance:- " +bankAccount.getBalance());

            System.out.print("Enter WithDraw amount:- ");
            double withDraw = scan.nextDouble();
            bankAccount.withDraw(withDraw);
            System.out.println("Sufficient balance:- " +bankAccount.getBalance());
        }
        catch(InputMismatchException e){
            System.out.println("Invalid! Please enter numeric valid number");
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
