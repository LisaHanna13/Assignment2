/*
 * This is the package for Assignment 2
 */
package assignment2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

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
        //PART 1: CREATING OBJECTS FOR 3 ACCOUNTS, FOR DATE, AND FOR MENU
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
        //Test out one of the mutators
        account1.setAccountName("Henry Mills");
        
        blank1 = readFile.nextLine();
        accountName2 = readFile.nextLine();
        bankBalance2 = readFile.nextDouble();
        Account account2 = new Account(accountName2, bankBalance2, "2-4217-6453-2453-3145-B");
        //Test out another mutator
        account2.setBankID("2-4217-6453-2453-3145");
        
        blank2 = readFile.nextLine();
        accountName3 = readFile.nextLine();
        bankBalance3 = readFile.nextDouble();
        Account account3 = new Account(accountName3, bankBalance3, "3-5353-6572-6475-3646");
        
        //Create object for date class
        Date today = new Date();
        
        //Create object from MenuOptions file
        MenuOptions menu = new MenuOptions();
        
        //PART 2: DETERMINE WHICH ACCOUNT WILL BE USED FOR THE REST OF THE STEPS
        //---------------------------------------------------------------------------------------------------------------------
        
        //Print introduction
        System.out.println("BEGINNING OF SESSION: " + today);
        System.out.println("Hello. Welcome to the Ocean Trust Bank.");
        System.out.print("Please, identify yourself by entering the first number of your bankID: ");
        
        //Create a while loop to make sure the input is an int
        int bankIDDigit;
        while (!keyboard.hasNextInt()){
            System.out.print("Sorry, that is not a valid digit. Please try again: ");
            keyboard.next();
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
        int counter1 = 0, counter2 = 0, counter3 = 0, counter4 = 0, counter5 = 0, counter6 = 0;
        
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
                        keyboard.next();
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
                            System.out.print("That is not a valid input. Please try again: ");
                            keyboard.next();
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
                            account1.setBalance(account1.getBankBalance() + deposit);
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
                            System.out.print("That is not a valid input. Please try again: ");
                            keyboard.next();
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
                            account1.setBalance(account1.getBankBalance() - withdraw);
                            
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
                                    countFiveDollarBill + ") 5$ bills, and (" + countOneDollarBill + ") 1$ bills.\n");
                        }
                        
                    //PART D: MENU CHOICE 4
                    //-----------------------------------------------------------------------------------------------------------
                    
                    }else if (menuChoice == 4){
                        System.out.println("You have chosen to transfer money into another account.");
                        //Print instructions
                        System.out.println("Please note, you may not transfer more than 100$ at a time.");
                        System.out.print("How much would you like to transfer?: ");
                        
                        //Make sure the value is a double
                        while (!keyboard.hasNextDouble()){
                            System.out.print("That is not a valid input. Please try again: ");
                            keyboard.next();
                        }
                        //Store the data
                        transferMoney = keyboard.nextDouble();
                        
                        //Make sure the deposit is not over the limit.
                        if (transferMoney >100 || transferMoney <= 0){
                            System.out.println("Sorry, that is not a valid input. You will have to try again.\n");
                        }else{
                            //Print instructions
                            System.out.println("\nHere are the two other accounts available: " + account2.getAccountName() + ", and " + account3.getAccountName());
                            System.out.println("Please make sure to enter their full name.");
                            System.out.print("Which account would you like to transfer the money to?: ");
                            
                            //This is a problem I have noticed with java since the beginning of the semester; when trying to use keyboard.nextLine() two times
                            //in a file, you must first register a blank string, otherwise they keyboard.nextLine() will not be activated.
                            String blank = keyboard.nextLine();
                            //Store the data
                            String accountChoice = keyboard.nextLine();
                            
                            //Use if's to see which account to transfer the money to
                            if (accountChoice.equalsIgnoreCase(account2.accountName)){
                                //Increment the counter for this menu option
                                counter4++;
                                
                                //ACCOUNT 2
                                account2.setBalance(account2.bankBalance + transferMoney);
                                account1.setBalance(account1.bankBalance - transferMoney);
                                //Print confirmation
                                System.out.println("\nYou have successfully transfered " + transferMoney + "$ to " + account2.accountName);
                                System.out.println("Your bank balance is now " + String.format("%.2f",account1.getBankBalance()) + ".\n");
                                
                            }else if (accountChoice.equalsIgnoreCase(account3.accountName)){
                                //Increment the counter for this menu option
                                 counter4++;
                                 
                                //ACCOUNT 3
                                account3.setBalance(account3.bankBalance + transferMoney);
                                account1.setBalance(account1.bankBalance - transferMoney);
                                //Print confirmation
                                System.out.println("\nYou have successfully transfered " + transferMoney + "$ to " + account3.accountName);
                                System.out.println("Your bank balance is now " + account1.getBankBalance() + ".\n");
                            }else{
                                System.out.println("Sorry, that is not a valid account. You will have to try again.\n");
                            }
                            
                        }
                             
                    //PART E: MENU CHOICE 5
                    //-----------------------------------------------------------------------------------------------------------   
                    
                    }else if (menuChoice == 5){
                        counter5++;
                        System.out.println("You have chosen to see your future bank balance based on our interest rate.");
                        System.out.println("Your current bank balance is: " + account1.getBankBalance() + "$.");
                        System.out.println("Note, the interest rate at the Ocean Trust bank is " + account1.getInterestRate()*100 + "%.");
                        
                        //Do the calculation to get the future bank balance values
                        double balance1Year = Math.pow((1 + account1.getInterestRate()),1);
                        double oneYearResult = account1.bankBalance * balance1Year;
                        double balance5Years = Math.pow((1 + account1.getInterestRate()),5);
                        double fiveYearsResult = account1.bankBalance * balance5Years;
                        double balance10Years = Math.pow((1 + account1.getInterestRate()),10);
                        double tenYearsResult = account1.bankBalance * balance10Years;
                       
                        //Print the results
                        System.out.println("\nYour balance in 1 year will be: " + String.format("%.2f", oneYearResult));
                        System.out.println("Your balance in 5 years will be: " + String.format("%.2f", fiveYearsResult));
                        System.out.println("Your balance in 10 years will be: " + String.format("%.2f", tenYearsResult) + "\n");
                        
                    //PART F: FIND OTHER ACCOUNT WITH SAME BANK ID
                    //----------------------------------------------------------------------------------------------------------- 
                    }else if (menuChoice == 6){
                        counter6++;
                        System.out.println("You have chosen to see if you own another account in this bank");
                        System.out.println("Your Bank ID is: " + account1.getID());
                        Boolean otherAccount = account1.equals(account2);
                        Boolean otherAccount2 = account1.equals(account3);
                        if (otherAccount == false && otherAccount2 == false){
                            System.out.println("You do not own any other account in this bank.\n");
                        }else System.out.println("You do own another account in this bank.\n");
                        
                    //PART F: MENU CHOICE NOT VALID
                    //----------------------------------------------------------------------------------------------------------- 
                    }else if (menuChoice != 7){
                        System.out.println("That is not a valid option. Please try again.\n");
                    }
                }while (menuChoice != 7);
                break;
                
            //PART 5: IF SECOND ACCOUNT IS CHOSEN
            //------------------------------------------------------------------------------------------------------------------
            case 2:
                //Greet the account owner
                System.out.println("\nGood day, " + account2.getAccountName() + ".");
                do{
                    //Print menu options
                    System.out.println(menu);
                    //Make sure user chooses an int
                    while(!keyboard.hasNextInt()){
                        System.out.print("That is not an integer. Please try again:");
                        keyboard.next();
                    }
                    //Store the data
                    menuChoice = keyboard.nextInt();
                    
                    //Create the if statement that is based on bank menu
                    
                    //PART A: MENU CHOICE 1
                    //-----------------------------------------------------------------------------------------------------------
                    
                    if (menuChoice == 1){
                        System.out.println("You have chosen to print a bank statement.");
                        //Print bank statement
                        System.out.println(account2);
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
                            System.out.print("That is not a valid input. Please try again: ");
                            keyboard.next();
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
                            account2.setBalance(account2.getBankBalance() + deposit);
                            System.out.println("Your bank balance is now " + String.format("%.2f",account2.bankBalance) + "$.\n");
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
                            System.out.print("That is not a valid input. Please try again: ");
                            keyboard.next();
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
                            account2.setBalance(account2.getBankBalance() - withdraw);
                            
                            //Print new balance
                             System.out.println("Your bank balance is now " + String.format("%.2f",account2.bankBalance) + "$.");
                            
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
                                    countFiveDollarBill + ") 5$ bills, and (" + countOneDollarBill + ") 1$ bills.\n");
                        }
                        
                    //PART D: MENU CHOICE 4
                    //-----------------------------------------------------------------------------------------------------------
                    
                    }else if (menuChoice == 4){
                        System.out.println("You have chosen to transfer money into another account.");
                        //Print instructions
                        System.out.println("Please note, you may not transfer more than 100$ at a time.");
                        System.out.print("How much would you like to transfer?: ");
                        
                        //Make sure the value is a double
                        while (!keyboard.hasNextDouble()){
                            System.out.print("That is not a valid input. Please try again: ");
                            keyboard.next();
                        }
                        //Store the data
                        transferMoney = keyboard.nextDouble();
                        
                        //Make sure the deposit is not over the limit.
                        if (transferMoney >100 || transferMoney <= 0){
                            System.out.println("Sorry, that is not a valid input. You will have to try again.\n");
                        }else{
                            //Print instructions
                            System.out.println("\nHere are the two other accounts available: " + account1.getAccountName() + ", and " + account3.getAccountName());
                            System.out.println("Please make sure to enter their full name.");
                            System.out.print("Which account would you like to transfer the money to?: ");
                            
                            //This is a problem I have noticed with java since the beginning of the semester; when trying to use keyboard.nextLine() two times
                            //in a file, you must first register a blank string, otherwise they keyboard.nextLine() will not be activated.
                            String blank = keyboard.nextLine();
                            //Store the data
                            String accountChoice = keyboard.nextLine();
                            
                            //Use if's to see which account to transfer the money to
                            if (accountChoice.equalsIgnoreCase(account1.accountName)){
                                //Increment the counter for this menu option
                                counter4++;
                                
                                //ACCOUNT 2
                                account1.setBalance(account1.bankBalance + transferMoney);
                                account2.setBalance(account2.bankBalance - transferMoney);
                                //Print confirmation
                                System.out.println("\nYou have successfully transfered " + transferMoney + "$ to " + account1.accountName);
                                System.out.println("Your bank balance is now " + String.format("%.2f",account2.getBankBalance()) + ".\n");
                                
                            }else if (accountChoice.equalsIgnoreCase(account3.accountName)){
                                //Increment the counter for this menu option
                                 counter4++;
                                 
                                //ACCOUNT 3
                                account3.setBalance(account3.bankBalance + transferMoney);
                                account2.setBalance(account2.bankBalance - transferMoney);
                                //Print confirmation
                                System.out.println("\nYou have successfully transfered " + transferMoney + "$ to " + account3.accountName);
                                System.out.println("Your bank balance is now " + account2.getBankBalance() + ".\n");
                            }else{
                                System.out.println("Sorry, that is not a valid account. You will have to try again.\n");
                            }
                            
                        }
                             
                    //PART E: MENU CHOICE 5
                    //-----------------------------------------------------------------------------------------------------------   
                    
                    }else if (menuChoice == 5){
                        counter5++;
                        System.out.println("You have chosen to see your future bank balance based on our interest rate.");
                        System.out.println("Your current bank balance is: " + account2.getBankBalance() + "$.");
                        System.out.println("Note, the interest rate at the Ocean Trust bank is " + account2.getInterestRate()*100 + "%.");
                        
                        //Do the calculation to get the future bank balance values
                        double balance1Year = Math.pow((1 + account2.getInterestRate()),1);
                        double oneYearResult = account2.bankBalance * balance1Year;
                        double balance5Years = Math.pow((1 + account2.getInterestRate()),5);
                        double fiveYearsResult = account2.bankBalance * balance5Years;
                        double balance10Years = Math.pow((1 + account2.getInterestRate()),10);
                        double tenYearsResult = account2.bankBalance * balance10Years;
                       
                        //Print the results
                        System.out.println("\nYour balance in 1 year will be: " + String.format("%.2f", oneYearResult));
                        System.out.println("Your balance in 5 years will be: " + String.format("%.2f", fiveYearsResult));
                        System.out.println("Your balance in 10 years will be: " + String.format("%.2f", tenYearsResult) + "\n");
                        
                    //PART F: FIND OTHER ACCOUNT WITH SAME BANK ID
                    //----------------------------------------------------------------------------------------------------------- 
                    }else if (menuChoice == 6){
                        counter6++;
                        System.out.println("You have chosen to see if you own another account in this bank");
                        System.out.println("Your Bank ID is: " + account2.getID());
                        Boolean otherAccount = account2.equals(account1);
                        Boolean otherAccount2 = account2.equals(account3);
                        if (otherAccount == false && otherAccount2 == false){
                            System.out.println("You do not own any other account in this bank.\n");
                        }else System.out.println("You do own another account in this bank.\n");
                        
                    //PART F: MENU CHOICE NOT VALID
                    //----------------------------------------------------------------------------------------------------------- 
                    }else if (menuChoice != 7){
                        System.out.println("That is not a valid option. Please try again.\n");
                    }
                }while (menuChoice != 7);
                
                break;
                
            //PART 6: IF THIRD ACCOUNT IS CHOSEN
            //------------------------------------------------------------------------------------------------------------------
            case 3:
                //Greet the account owner
                System.out.println("\nGood day, " + account3.getAccountName() + ".");
                do{
                    //Print menu options
                    System.out.println(menu);
                    //Make sure user chooses an int
                    while(!keyboard.hasNextInt()){
                        System.out.print("That is not an integer. Please try again:");
                        keyboard.next();
                    }
                    //Store the data
                    menuChoice = keyboard.nextInt();
                    
                    //Create the if statement that is based on bank menu
                    
                    //PART A: MENU CHOICE 1
                    //-----------------------------------------------------------------------------------------------------------
                    
                    if (menuChoice == 1){
                        System.out.println("You have chosen to print a bank statement.");
                        //Print bank statement
                        System.out.println(account3);
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
                            System.out.print("That is not a valid input. Please try again: ");
                            keyboard.next();
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
                            account3.setBalance(account3.getBankBalance() + deposit);
                            System.out.println("Your bank balance is now " + String.format("%.2f",account3.bankBalance) + "$.\n");
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
                            System.out.print("That is not a valid input. Please try again: ");
                            keyboard.next();
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
                            account3.setBalance(account3.getBankBalance() - withdraw);
                            
                            //Print new balance
                             System.out.println("Your bank balance is now " + String.format("%.2f",account3.bankBalance) + "$.");
                            
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
                                    countFiveDollarBill + ") 5$ bills, and (" + countOneDollarBill + ") 1$ bills.\n");
                        }
                        
                    //PART D: MENU CHOICE 4
                    //-----------------------------------------------------------------------------------------------------------
                    
                    }else if (menuChoice == 4){
                        System.out.println("You have chosen to transfer money into another account.");
                        //Print instructions
                        System.out.println("Please note, you may not transfer more than 100$ at a time.");
                        System.out.print("How much would you like to transfer?: ");
                        
                        //Make sure the value is a double
                        while (!keyboard.hasNextDouble()){
                            System.out.print("That is not a valid input. Please try again: ");
                            keyboard.next();
                        }
                        //Store the data
                        transferMoney = keyboard.nextDouble();
                        
                        //Make sure the deposit is not over the limit.
                        if (transferMoney >100 || transferMoney <= 0){
                            System.out.println("Sorry, that is not a valid input. You will have to try again.\n");
                        }else{
                            //Print instructions
                            System.out.println("\nHere are the two other accounts available: " + account2.getAccountName() + ", and " + account1.getAccountName());
                            System.out.println("Please make sure to enter their full name.");
                            System.out.print("Which account would you like to transfer the money to?: ");
                            
                            //This is a problem I have noticed with java since the beginning of the semester; when trying to use keyboard.nextLine() two times
                            //in a file, you must first register a blank string, otherwise they keyboard.nextLine() will not be activated.
                            String blank = keyboard.nextLine();
                            //Store the data
                            String accountChoice = keyboard.nextLine();
                            
                            //Use if's to see which account to transfer the money to
                            if (accountChoice.equalsIgnoreCase(account2.accountName)){
                                //Increment the counter for this menu option
                                counter4++;
                                
                                //ACCOUNT 2
                                account2.setBalance(account2.bankBalance + transferMoney);
                                account3.setBalance(account3.bankBalance - transferMoney);
                                //Print confirmation
                                System.out.println("\nYou have successfully transfered " + transferMoney + "$ to " + account2.accountName);
                                System.out.println("Your bank balance is now " + String.format("%.2f",account3.getBankBalance()) + ".\n");
                                
                            }else if (accountChoice.equalsIgnoreCase(account1.accountName)){
                                //Increment the counter for this menu option
                                 counter4++;
                                 
                                //ACCOUNT 3
                                account1.setBalance(account1.bankBalance + transferMoney);
                                account3.setBalance(account3.bankBalance - transferMoney);
                                //Print confirmation
                                System.out.println("\nYou have successfully transfered " + transferMoney + "$ to " + account1.accountName);
                                System.out.println("Your bank balance is now " + account3.getBankBalance() + ".\n");
                            }else{
                                System.out.println("Sorry, that is not a valid account. You will have to try again.\n");
                            }
                            
                        }
                             
                    //PART E: MENU CHOICE 5
                    //-----------------------------------------------------------------------------------------------------------   
                    
                    }else if (menuChoice == 5){
                        counter5++;
                        System.out.println("You have chosen to see your future bank balance based on our interest rate.");
                        System.out.println("Your current bank balance is: " + account3.getBankBalance() + "$.");
                        System.out.println("Note, the interest rate at the Ocean Trust bank is " + account3.getInterestRate()*100 + "%.");
                        
                        //Do the calculation to get the future bank balance values
                        double balance1Year = Math.pow((1 + account3.getInterestRate()),1);
                        double oneYearResult = account3.bankBalance * balance1Year;
                        double balance5Years = Math.pow((1 + account3.getInterestRate()),5);
                        double fiveYearsResult = account3.bankBalance * balance5Years;
                        double balance10Years = Math.pow((1 + account3.getInterestRate()),10);
                        double tenYearsResult = account3.bankBalance * balance10Years;
                       
                        //Print the results
                        System.out.println("\nYour balance in 1 year will be: " + String.format("%.2f", oneYearResult));
                        System.out.println("Your balance in 5 years will be: " + String.format("%.2f", fiveYearsResult));
                        System.out.println("Your balance in 10 years will be: " + String.format("%.2f", tenYearsResult) + "\n");
                        
                    //PART F: FIND OTHER ACCOUNT WITH SAME BANK ID
                    //----------------------------------------------------------------------------------------------------------- 
                    }else if (menuChoice == 6){
                        counter6++;
                        System.out.println("You have chosen to see if you own another account in this bank");
                        System.out.println("Your Bank ID is: " + account3.getID());
                        Boolean otherAccount = account3.equals(account2);
                        Boolean otherAccount2 = account3.equals(account1);
                        if (otherAccount == false && otherAccount2 == false){
                            System.out.println("You do not own any other account in this bank.\n");
                        }else System.out.println("You do own another account in this bank.\n");
                        
                    //PART F: MENU CHOICE NOT VALID
                    //----------------------------------------------------------------------------------------------------------- 
                    }else if (menuChoice != 7){
                        System.out.println("That is not a valid option. Please try again.\n");
                    }
                }while (menuChoice != 7);
                break;
                
            default:
                System.out.print("Sorry, that is not a valid digit. The bank deems you an imposter. Please try again later. ");
                bankIDDigit = keyboard.nextInt();
        }
        //PART 7: FINISHING TOUCHES
        //----------------------------------------------------------------------------------------------------------------------
        
        //Print out all the actions that were done by the user
        System.out.println("\nThank you for user the Ocean Trust Bank.");
        System.out.println("Here is a summary of all the actions you have done in this session: ");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("You have printed a bank statement " + counter1 + " time(s).");
        System.out.println("You have deposited money " + counter2 + " time(s).");
        System.out.println("You have withdrawn money " + counter3 + " time(s).");
        System.out.println("You have transfered money " + counter4 + " time(s).");
        System.out.println("You have looked at future bank balance values " + counter5 + " time(s).");
        System.out.println("You have looked for another account " + counter6 + " time(s).");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("We hope to see you again soon! Goodbye.");  
        System.out.println("END OF SESSION.");
    }
}