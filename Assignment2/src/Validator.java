//Validator Utility Class
import java.util.ArrayList;
import java.util.Scanner;

public class Validator {
    // ========== Regex Validation Tools

    //Validate Student ID Format
    private static boolean validateStudentId(String input){
        //Set Student ID format
        String studentIdRegex = "^[sS]-[0-9]{4}$";
        //Return whether the Student ID passed is in the correct format
        return input.matches(studentIdRegex);
    }

    //Validate Email Format
    private static boolean validateEmail(String input){
        //Set Email format
        String emailRegex = "^[A-za-z0-9+_.-]+@[A-za-z0-9+_.-]+$";
        //Return whether the email passed in in the correct format
        return input.matches(emailRegex);
    }

    //Validate Room Number
    private static boolean validateRoomNumber(String input){
        //Set Room Number format
        String employeeIdRegex = "^[A-Za-z][0-9]{3}$";
        //Return whether the Room Number passed is in the correct format
        return input.matches(employeeIdRegex);
    }

    //Validate Employee ID Format
    private static boolean validateEmployeeId(String input){
        //Set Employee ID format
        String studentIdRegex = "^[eE]-[0-9]{4}$";
        //Return whether the Employee ID passed is in the correct format
        return input.matches(studentIdRegex);
    }

    // ========== Input Tools

    //Request Student ID
    public static String inputValidStudentId(Scanner scanner){
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
        //Return validated input, with uniform letter format (Uppercase)
        return input.toUpperCase();
    }

    //Request Email
    public static String inputValidEmail(Scanner scanner){
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
        //Return validated input, with uniform letter format (Lowercase)
        return input.toLowerCase();
    }

    //Request Room Number
    public static String inputValidRoomNumber(Scanner scanner){
        //Declare empty String to hold user input
        String input = "";
        //While input is not in valid Room Number format
        while (!validateRoomNumber(input)) { 
            //If input is not empty, and in wrong format print error information
            if (!input.isEmpty()){
                //Print error message letting the user know to input using the Correct format
                System.out.println("Error: Room Number must be in valid format (A-Z###).");
            }
            //Prompt user for Room Number
            System.out.print("Enter Room Number (A-Z###): ");
            //Retrieve input from user with scanner
            input = scanner.nextLine();
            //Loop back to while statement to validate Room Number
        }
        //Return validated input, with uniform letter format (Uppercase)
        return input.toUpperCase();
    }

    //Request Employee ID
    public static String inputValidEmployeeId(Scanner scanner){
        //Declare empty String to hold user input
        String input = "";
        //While input is not in valid Employee ID format
        while (!validateEmployeeId(input)) { 
            //If input is not empty, and in wrong format print error information
            if (!input.isEmpty()){
                //Print error message letting the user know to input using the Correct format
                System.out.println("Error: Employee ID must be in valid format (E-####).");
            }
            //Prompt user for Employee ID
            System.out.print("Enter Employee ID (E-####): ");
            //Retrieve input from user with scanner
            input = scanner.nextLine();
            //Loop back to while statement to validate Employee ID
        }
        //Return validated input, with uniform letter format (Uppercase)
        return input.toUpperCase();
    }

    // ========== Add/Remove Object Tools
    //InPersonCourse(code, name, teacher, room)
    public static void addInPersonCourse(){

    }

    //OnlineCourse(code, name, teacher, platform)
    public static void addOnlineCourse(){

    }
    
    //HybridCourse(code, name, teacher, room, platform)
    public static void addHybridCourse(){

    }
    

    //Student(name, id, email, program);
    public static void addStudent(){

    }
    //Instructor(name, id, email, department);
    public static void addInstructor(){
        
    }    


    // ========== Search Tools
    
    //Find Student by id or name

    // ========== Menu Tools

    //Custom Menu Structure for Navigation
    public static int menuChoice(Scanner scanner, String title, String... options){
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
        //Return selected menu option
        return choice;
    }
    
    public static int menuChoice(Scanner scanner, String title, ArrayList<Person> list, int filterPersonType){
        //Declare a choice variable to record user choice
        int choice = 0; 
        //Declare ArrayList<Integer> to hold display order relation to list index
        ArrayList<Integer> displayIndex = new ArrayList<>(); 
        //Print Title to begin menu
        System.out.println("\n ========= " + title + " ========= \n");
        //For each option passed as arguments
        for (int i = 0; i < list.size(); i++){
            //If filter is set and item.getDelivery() equals filterDelivery, or if filter is none, display current item 
            if((((list.get(i)).getPersonType()) == filterPersonType) || filterPersonType == 0){
                //Adds the index of the item in the Master list to the list of diplayed items
                displayIndex.add(i);
                //Print "(current list item #) - (item)"
                System.out.println(String.valueOf(displayIndex.size()) + " - " + (list.get(i)).getName());
            }
        }
        //While the choice of the user is out of the scope of the options
        while(!(choice >=1 && choice <= displayIndex.size())){
            try { 
                //Prompt user to make a choice
                System.out.print("\nPlease enter a number to pick a menu option: ");
                //Parse choice from String to int, may result in NumberFormatException
                choice = Integer.parseInt(scanner.nextLine()); 
                //If choice is not within the scope of the options
                if(choice < 1 || choice > list.size()){ 
                    //Print error message informing the user to pick one of the option numbers
                    System.out.println("Error: Menu " + choice + " not found. Please only select existing menu options.");
                }
            //Catch if trying to parse String to int fails
            } catch (NumberFormatException e) { 
                //Print error message informing the user to select a number
                System.out.println("Error: Invalid selection. Selection must be a number.");
            } 
        } 
        //Return selected menu option by its relation to the Master list index saved in displayIndex
        return displayIndex.get(choice - 1);
    }
    
    //Custom Menu Structure for Selection from Course objects
    public static int menuChoice(Scanner scanner, String title, ArrayList<Course> list, String filterDelivery){
        //Declare a choice variable to record user choice
        int choice = 0; 
        //Declare ArrayList<Integer> to hold display order relation to list index
        ArrayList<Integer> displayIndex = new ArrayList<>(); 
        //Print Title to begin menu
        System.out.println("\n ========= " + title + " ========= \n");
        //For each option passed as arguments
        for (int i = 0; i < list.size(); i++){
            //If filter is set and item.getDelivery() equals filterDelivery, or if filter is none, display current item 
            if((((list.get(i)).getDelivery()).equals(filterDelivery)) || filterDelivery.equals("none")){
                //Adds the index of the item in the Master list to the list of diplayed items
                displayIndex.add(i);
                //Print "(current list item #) - (item)"
                System.out.println(String.valueOf(displayIndex.size()) + " - " + (list.get(i)).getName());
            }
        }
        //While the choice of the user is out of the scope of the options
        while(!(choice >=1 && choice <= displayIndex.size())){
            try { 
                //Prompt user to make a choice
                System.out.print("\nPlease enter a number to pick a menu option: ");
                //Parse choice from String to int, may result in NumberFormatException
                choice = Integer.parseInt(scanner.nextLine()); 
                //If choice is not within the scope of the options
                if(choice < 1 || choice > list.size()){ 
                    //Print error message informing the user to pick one of the option numbers
                    System.out.println("Error: Menu " + choice + " not found. Please only select existing menu options.");
                }
            //Catch if trying to parse String to int fails
            } catch (NumberFormatException e) { 
                //Print error message informing the user to select a number
                System.out.println("Error: Invalid selection. Selection must be a number.");
            } 
        } 
        //Return selected menu option by its relation to the Master list index saved in displayIndex
        return displayIndex.get(choice - 1);
    }
    
}

