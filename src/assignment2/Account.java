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
    String acountName;
    Double bankBalance, depositAmount, withdrawAmount;
    static int oneDollarBill = 1, fiveDollarBill = 5, tenDollarBill = 10, twentyDollarBill = 20,
               fiftyDollarBill = 50, hundredDollarBill = 100;
    
    public Account(String accountName, double bankBalance){
        this.acountName = accountName;
        this.bankBalance = bankBalance;
    }
    

}
