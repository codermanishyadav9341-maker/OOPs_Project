package Banking_Management_System;

public abstract class Account {
    private String accountNumber;
    private String holderName;
    private double balance;


    public Account(String accountNumber,String holderName,double balance){
        setAccountNumber(accountNumber);
        setHolderName(holderName);
        setBalance(balance);
    }

    public void setAccountNumber(String accountNumber){
        if(accountNumber == null || accountNumber.trim().isEmpty()){
            throw new IllegalArgumentException("AccountNumber cannot be null or empty");
        }
         this.accountNumber = accountNumber;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void setHolderName(String holderName){
        if(holderName == null || holderName.trim().isEmpty()){
            throw new IllegalArgumentException("HolderName cannot be null or empty");
        }
         this.holderName = holderName;
    }

    public String getHolderName(){
        return holderName;
    }

    public void setBalance(double balance){
        if(balance < 0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
         this.balance += amount;
        System.out.println("Deposit Successfully");
    }

  public void withDraw(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Please check your balance");
        }
         if(amount >= balance){
             System.out.println("Insufficient balance");
         }
          this.balance -= amount;
         System.out.println("WithDraw Successfully");
  }

  public void checkBalance(){
        System.out.println("Balance:- " +balance);
  }
}
