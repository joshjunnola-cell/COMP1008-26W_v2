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
    
}

