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
    
    //Creating static instance variables
    static double interestRate = 0.03;
    
    /**
     * Set up basic information about bank account
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
     * Mutator: Sets bank balance value
     * @param BankBalance 
     */
    void setBalance(double bankBalance){
        this.bankBalance = bankBalance;
    }
    
    /**
     * Accessor: Get bank balance value
     * @return bankBalance
     */
    public double getBankBalance(){
        return bankBalance;
    }
    
    /**
     * Accessor: Get account name
     * @return accountName
     */
    public String getAccountName(){
        return accountName;
    }
    
    /**
     * Mutator: Set account name
     * @param accountName 
     */
    void setAccountName(String accountName){
        this.accountName = accountName;
    }
    
    /**
     * Accessor: Get bank ID value
     * @return bankID
     */
    public String getID(){
        return bankID;
    }
    
    /**
     * Mutator: Set bank ID value
     * @param bankID 
     */
    void setBankID(String bankID){
        this.bankID = bankID;
    }
    
    /**
     * Compare two bank ID's
     * @param other
     * @return true if both bankID's are the same
     */
    public Boolean equals(Account other){
        return (bankID.equals(other.bankID));
    }
    
    /**
     * Display formatted bank statement
     */
    public String toString(){
        return "---------------------------------------------" +
               "\n               BANK STATEMENT" +
               "\n---------------------------------------------" +
               "\nAccount Name : " + this.accountName +
               "\nBank Balance : " + String.format("%.2f",this.bankBalance) + "$" +
               "\nBank ID      : " + this.bankID +
               "\nInterest Rate: " + String.format("%.2f",(this.interestRate*100)) + "%" +
               "\n---------------------------------------------\n";
    }
    
    /**
     * Accessor: Get interest rate value
     * @return interestRate
     */
    public double getInterestRate(){
        return interestRate;
    }
}
