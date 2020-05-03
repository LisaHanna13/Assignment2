/*
 * This is the package for Assignment 2
 */
package assignment2;

/**
 * This class will be used for creating constructors and methods.
 * @author lisa-
 */
public class Account {
    //Creating basic attributes
    String accountName, bankID;
    double bankBalance;
  
    //Create variables to count amount of bills (for withdraw method)
    int withdraw, countOneDollarBill = 0, countFiveDollarBill = 0, countTenDollarBill = 0,
        countTwentyDollarBill = 0, countFiftyDollarBill = 0, countHundredDollarBill = 0;
    
    //Creating static instance variables
    static double  oneDollarBill = 1, fiveDollarBill = 5, tenDollarBill = 10, twentyDollarBill = 20,
                   fiftyDollarBill = 50, hundredDollarBill = 100;
    static double interestRate = 0.03;
    
    /**
     * This constructor is used to set up basic information about a bank account
     * @param accountName
     * @param bankBalance 
     * @param bankID
     */
    public Account(String accountName, double bankBalance, String bankID){
        this.accountName = accountName;
        this.bankBalance = bankBalance;
        this.bankID = bankID;
    }
    
    /**
     * When the client withdraws an amount, the bankBalance must be set to a new value
     * This is therefore a mutator (setter)
     * @param BankBalance 
     */
    void setBalance(double bankBalance){
        this.bankBalance = bankBalance;
    }
    
    /**
     * This accessor (getter) can be used to get the bank balance of an account when
     * wanting to transfer money between accounts
     * @return bankBalance
     */
    public double getBankBalance(){
        return bankBalance;
    }
    
    /**
     * This accessor (getter) can be used to get the accountNames available when wanting to
     * do a transfer between accounts
     * @return accountName
     */
    public String getAccountName(){
        return accountName;
    }
    
    /**
     * This equals method can be used for a client to see if he has a second bank account;
     * if they do, there will be two matching bankID's
     * @param other
     * @return true if both bankID's are the same
     */
    public Boolean equals(Account other){
        return (bankID.equals(other.bankID));
    }
    
    /**
     * Use this method for a clean statement with the account name, bank balance, bank ID, and interest rate
     * @return a printed bank statement 
     */
    public String toString(){
        return "---------------------------------------------" +
               "\n               BANK STATEMENT" +
               "\n---------------------------------------------" +
               "\nAccount Name : " + this.accountName +
               "\nBank Balance : " + this.bankBalance + "$" +
               "\nBank ID      : " + this.bankID +
               "\nInterest Rate: " + (this.interestRate*100) + "%" +
               "\n---------------------------------------------\n";
    }
    
    /**
     * Use this method to get the interest rate, useful for menu option 5
     * @return interestRate
     */
    public double getInterestRate(){
        return interestRate;
    }
}
