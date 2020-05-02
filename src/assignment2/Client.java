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
        
        //Creating objects from account file
        accountName1 = readFile.nextLine();
        bankBalance1 = readFile.nextDouble();
        Account account1 = new Account(accountName1, bankBalance1, "1-4833-1200-3412-3456");
        
        blank1 = readFile.nextLine();
        accountName2 = readFile.nextLine();
        bankBalance2 = readFile.nextDouble();
        Account account2 = new Account(accountName2, bankBalance2, "2-4217-6453-2453-3145-B");
        
        blank2 = readFile.nextLine();
        accountName3 = readFile.nextLine();
        bankBalance3 = readFile.nextDouble();
        Account account3 = new Account(accountName3, bankBalance3, "3-5353-6572-6475-3646-C");
        
        //Create object from MenuOptions file
        MenuOptions menu = new MenuOptions();
        
        //Print introduction
        System.out.println("Hello. Welcome to the Ocean Trust Bank.");
        System.out.print("Please, identify yourself by entering the first number of your bankID: ");
        
        //Create a while loop to make sure the input is an int
        int bankIDDigit;
        while (!keyboard.hasNextInt()){
            System.out.print("Sorry, that is not a valid digit. Please try again: ");
            keyboard.nextLine();
        }
        
        //Store the data
        bankIDDigit = keyboard.nextInt();
        
        //Create variable for menuOptions
        int menuChoice = 0;
        
        //Create switch statements to determine which bank account to access
        switch(bankIDDigit){
            case 1:
                //Greet the account owner
                System.out.println("\nGood day, " + account1.getAccountName() + ".");
                do{
                    //Print menu options
                    System.out.println(menu);
                    //Make sure user chooses an int
                    while(!keyboard.hasNextInt()){
                        System.out.print("That is not an integer. Please try again:");
                    }
                    //Store the data
                    menuChoice = keyboard.nextInt();
                    
                    //Create the if statements
                    if (menuChoice == 1){
                        
                    }else if (menuChoice == 2){
                        
                    }else if (menuChoice == 3){
                        
                    }else if (menuChoice == 4){
                        
                    }else if (menuChoice == 5){
                        
                    }else if (menuChoice != 6){
                        System.out.println("That is not a valid option. Please try again.\n");
                    }
                }while (menuChoice != 6);
                
                break;
                
            case 2:
                break;
                
            case 3:
                break;
                
            default:
                System.out.print("Sorry, that is not a valid digit. The bank deems you an imposter. Please try again later. ");
                bankIDDigit = keyboard.nextInt();
        }
        
  
    }
    
}
