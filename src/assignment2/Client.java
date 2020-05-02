/*
 * This is the package for Assignment 2
 */
package assignment2;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * This is the class that will be used to execute the constructors and methods
 * @author lisa-
 */
public class Client {
    /**
     * This is the main method used for this class. 
     * @param args the command line arguments
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        //Create a scanner that will read a file, and a scanner for user input
        File inFile = new File("AccountNamesAndBalance.txt");
        Scanner readFile = new Scanner(inFile);
        Scanner keyboard = new Scanner(System.in);
        
        //Create variables for the different accounts
        String accountName1, accountName2, accountName3;
        double bankBalance1, bankBalance2, bankBalance3;
        //Create variables to skip over empty lines, so there is no issue reading files
        String blank1, blank2;
        
        //Creating objects
        accountName1 = readFile.nextLine();
        bankBalance1 = readFile.nextDouble();
        Account account1 = new Account(accountName1, bankBalance1, "4833-1200-3412-3456-A");
        
        blank1 = readFile.nextLine();
        accountName2 = readFile.nextLine();
        bankBalance2 = readFile.nextDouble();
        Account account2 = new Account(accountName2, bankBalance2, "4217-6453-2453-3145-B");
        
        blank2 = readFile.nextLine();
        accountName3 = readFile.nextLine();
        bankBalance3 = readFile.nextDouble();
        Account account = new Account(accountName3, bankBalance3, "5353-6572-6475-3646-C");
        
    }
    
}
