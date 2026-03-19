//Validator Utility Class
import java.util.Scanner;

public class Validator {

    // ========== Regex Validation Tools

    //Validate Student ID Format
    private static boolean validateStudentId(String input){
        //Set Student ID format
        String studentIdRegex = "^[sS]-[0-9]{4}$";
        //Return wether the Student ID passed is in the correct format
        return input.matches(studentIdRegex);
    }

    //Validate Email Format
    private static boolean validateEmail(String input){
        //Set Email format
        String emailRegex = "^[A-za-z0-9+_.-]+@[A-za-z0-9+_.-]+$";
        //Return wether the email passed in in the correct format
        return input.matches(emailRegex);
    }


    // ========== Input Tools

    //Request Student ID
    public static String inputValidStudentId(){
        //Open instance of Scanner object from java.util.Scanner
        Scanner scanner = new Scanner(System.in);
        //Declare empty String to hold user input
        String input = "";
        //While input is not in valid Student ID format
        while (!validateStudentId(input)) { 
            //If input is not empty, and in wrong format print error information
            if (!input.isEmpty()){
                //Print error message letting the user know to input using the Correct format
                System.out.println("Error: Student ID must be in valid format (S-####).");
            }
            //Prompt user for Student ID
            System.out.print("Enter Student ID (S-####): ");
            //Retrieve input from user with scanner
            input = scanner.nextLine();
            //Loop back to while statement to validate Student ID
        }
        //Close Scanner instance
        scanner.close();
        //Return validated input, with uniform letter format (Uppercase)
        return input.toUpperCase();
    }

    //Request Email
    public static String inputValidEmail(){
        //Open instance of Scanner object from java.util.Scanner
        Scanner scanner = new Scanner(System.in);
        //Declare empty String to hold user input
        String input = "";
        //While input is not in valid Email format
        while (!validateEmail(input)) { 
            //If input is not empty, and in wrong format print error information
            if (!input.isEmpty()){
                //Print error message letting the user know to input using the Correct format
                System.out.println("Error: Email must be in valid format.");
            }
            //Prompt user for Email
            System.out.print("Enter Email: ");
            //Retrieve input from user with scanner
            input = scanner.nextLine();
            //Loop back to while statement to validate Email
        }
        //Close Scanner instance
        scanner.close();
        //Return validated input, with uniform letter format (Lowercase)
        return input.toLowerCase();
    }

    // ========== Menu and Interaction Tools

    //Custom Menu Structure for Navigation
    public static int menuChoice(String title, String... options){
        //Open instance of Scanner object from java.util.Scanner
        Scanner scanner = new Scanner(System.in);
        //Declare an index variable to store display numbers in the foreach loop
        int menuIndex = 0;
        //Declare a choice variable to record user choice
        int choice = 0; 
        //Print Title to begin menu
        System.out.println("\n ========= " + title + " ========= \n");
        //For each option passed as arguments
        for(String option : options){ 
            //Add 1 to display index
            menuIndex++;
            //Print "(display index) - (option)"
            System.out.println(menuIndex + " - " + option);
        }
        //While the choice of the user is out of the scope of the options
        while(!(choice >=1 && choice <= options.length)){
            try { 
                //Prompt user to make a choice
                System.out.print("\nPlease enter a number to pick a menu option: ");
                //Parse choice from String to int, may result in NumberFormatException
                choice = Integer.parseInt(scanner.nextLine()); 
                //If choice is not within the scope of the options
                if(choice < 1 || choice > options.length){ 
                    //Print error message informing the user to pick one of the option numbers
                    System.out.println("Error: Menu " + choice + " not found. Please only select existing menu options.");
                }
            //Catch if trying to parse String to int fails
            } catch (NumberFormatException e) { 
                //Print error message informing the user to select a number
                System.out.println("Error: Invalid selection. Selection must be a number.");
            } 
        } 
        //Close Scanner instance
        scanner.close();
        //Return selected menu option
        return choice;
    }
    
}

