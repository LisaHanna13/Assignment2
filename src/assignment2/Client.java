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
        //PART 1: CREATING OBJECTS FOR 3 ACCOUNTS AND FOR MENU
        //--------------------------------------------------------------------------------------------------------------------
        
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
        
        //PART 2: DETERMINE WHICH ACCOUNT WILL BE USED FOR THE REST OF THE STEPS
        //---------------------------------------------------------------------------------------------------------------------
        
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
        
        //PART 3: CREATING MOST VARIABLES USEFUL FOR THE REST OF THE PROGRAM
        //---------------------------------------------------------------------------------------------------------------------
        
        //Create variables for menuOptions
        int menuChoice = 0;
        double deposit = 0,transferMoney = 0;
        int withdraw = 0;
        
        //These variables will be incremented depending on which menuOption is picked. That way,
        //I can give a summary of the actions that the user did at the end of my program.
        int counter1 = 0, counter2 = 0, counter3 = 0, counter4 = 0, counter5 = 0;
        
        //Create variables to count amount of bills (for withdraw method)
        int countOneDollarBill = 0, countFiveDollarBill = 0, countTenDollarBill = 0,
                countTwentyDollarBill = 0, countFiftyDollarBill = 0, countHundredDollarBill = 0;
        
        
        //Create switch statements to determine which bank account to access
        switch(bankIDDigit){
            
            //PART 4: IF FIRST ACCOUNT IS CHOSEN
            //------------------------------------------------------------------------------------------------------------------
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
                    
                    //Create the if statement that is based on bank menu
                    
                    //PART A: MENU CHOICE 1
                    //-----------------------------------------------------------------------------------------------------------
                    
                    if (menuChoice == 1){
                        System.out.println("You have chosen to print a bank statement.");
                        //Print bank statement
                        System.out.println(account1);
                        //Increment the counter for this menu option
                        counter1++;
                        
                    //PART B: MENU CHOICE 2
                    //-----------------------------------------------------------------------------------------------------------  
                    
                    }else if (menuChoice == 2){
                        System.out.println("You have chosen to deposit money into your account.");
                        //Print instructions
                        System.out.println("Please note, you may not deposit more than 100$ at a time.");
                        System.out.print("How much would you like to deposit?: ");
                       
                        //Make sure the deposit is a valid value.
                        while (!keyboard.hasNextDouble()){
                            System.out.println("That is not a valid input. Please try again: ");
                            keyboard.nextLine();
                        }
                        //Store the data
                        deposit = keyboard.nextDouble();
                        
                        //Make sure the deposit is not over the limit.
                        if (deposit >100 || deposit <= 0){
                            System.out.println("Sorry, that is not a valid input. You will have to try again.\n");
                        } else{
                            //Increment the counter for this menu option
                            counter2++;
                            //Use the accessor deposit to reset the value of bankBalance
                            account1.deposit(bankBalance1 + deposit);
                            System.out.println("Your bank balance is now " + String.format("%.2f",account1.bankBalance) + "$.\n");
                        }
                    
                    //PART C: MENU CHOICE 3
                    //-----------------------------------------------------------------------------------------------------------
                    
                    }else if (menuChoice == 3){
                        System.out.println("You have chosen to withdraw money from your account.");
                        //Print instructions
                        System.out.println("Please note, you may not withdraw more than 100$ at a time, and you may not withdraw cents.");
                        System.out.print("How much would you like to withdraw?: ");
                        
                        //Make sure the value is a double
                        while (!keyboard.hasNextInt()){
                            System.out.println("That is not a valid input. Please try again: ");
                            keyboard.nextLine();
                        }
                        //Store the data
                        withdraw = keyboard.nextInt();
                        
                        //Make sure the deposit is not over the limit.
                        if (withdraw >100 || withdraw <= 0){
                            System.out.println("Sorry, that is not a valid input. You will have to try again.\n");
                        }else{
                            //Increment the counter for this menu option
                            counter3++;
                            //Use the accessor withdraw to reset the value of bankBalance
                            account1.withdraw(bankBalance1 - deposit);
                            
                            //Print new balance
                             System.out.println("Your bank balance is now " + String.format("%.2f",account1.bankBalance) + "$.");
                            
                            //CHALLENGE PART: Give money back with least amount of bills
                            countHundredDollarBill = withdraw/100;
                            int remainder = withdraw%100;
                            countFiftyDollarBill = remainder/50;
                            int remainder2 = remainder%50;
                            countTwentyDollarBill = remainder2/20;
                            int remainder3 = remainder2%20;
                            countTenDollarBill =remainder3/10;
                            int remainder4 = remainder3%10;
                            countFiveDollarBill = remainder4/5;
                            int remainder5 = remainder4%5;
                            countOneDollarBill = remainder5/1;
                            System.out.println("You were given back (" + countHundredDollarBill + ") 100$ bills, (" + countFiftyDollarBill + 
                                    ") 50$ bills, (" + countTwentyDollarBill + ") 20$ bills, (" + countTenDollarBill + ") 10$ bills, (" + 
                                    countFiveDollarBill + ") 5$ bills, and (" + countOneDollarBill + ") 1% bills.\n");
                        }
                        
                    //PART D: MENU CHOICE 4
                    //-----------------------------------------------------------------------------------------------------------
                    
                    }else if (menuChoice == 4){
                    
                    //PART E: MENU CHOICE 5
                    //-----------------------------------------------------------------------------------------------------------   
                    
                    }else if (menuChoice == 5){
                       
                    //PART F: MENU CHOICE NOT VALID
                    //----------------------------------------------------------------------------------------------------------- 
                    }else if (menuChoice != 6){
                        System.out.println("That is not a valid option. Please try again.\n");
                    }
                }while (menuChoice != 6);
                break;
                
            //PART 5: IF SECOND ACCOUNT IS CHOSEN
            //------------------------------------------------------------------------------------------------------------------
            case 2:
                break;
                
            //PART 6: IF THIRD ACCOUNT IS CHOSEN
            //------------------------------------------------------------------------------------------------------------------
            case 3:
                break;
                
            default:
                System.out.print("Sorry, that is not a valid digit. The bank deems you an imposter. Please try again later. ");
                bankIDDigit = keyboard.nextInt();
        }
    }
    
}
