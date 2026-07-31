package Banking_Management_System;


public class SavingAccount extends Account{

    private double interestRate;

    public SavingAccount(String accountNumber,String holderName,double balance,double interestRate){
        super(accountNumber,holderName,balance);

        if(interestRate < 0){
            throw new IllegalArgumentException("InterestRate cannot be negative");
        }
         this.interestRate = interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate < 0) {
            throw new IllegalArgumentException("InterestRate cannot be negative");
        }
        this.interestRate = interestRate;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public void calculateInterestRate(){
        double interest = getBalance()*interestRate/100;
        System.out.println("Interest:- " +interest);
        System.out.println("Balance with interestRate:- " +getBalance()+interest);
    }
}
