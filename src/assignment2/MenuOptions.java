/*
 * This is the package for assignment 2.
 */
package assignment2;
/**
 * This class will be used to print the menu options
 * @author lisa-
 */
public class MenuOptions {
    /**
     * Empty constructor for menu object
     */
    public MenuOptions(){}
    
    /**
     * Display formatted menu options for users
     * @return menu options
     */
    public String toString(){
        return "Please choose one option: " +
               "\n---------------------------------------------------" +
               "\n1- Print Bank Statement" +
               "\n2- Deposit Money Into Account" +
               "\n3- Withdraw Money From Account" +
               "\n4- Transfer Money to Another Account" +
               "\n5- See Future Bank Balance Based on Interest Rate" +
               "\n6- Look for another account from the same user" +
               "\n7- Exit" +
               "\n---------------------------------------------------\n";
    }
}
