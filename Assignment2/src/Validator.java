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

    //Validate CourseCode
    private static boolean validateCourseCode(String input){
        //Set courseCode format
        String courseCodeRegex = "^[A-Za-z]{4}[0-9]{4}$";
        //Return whether the Room Number passed is in the correct format
        return input.matches(courseCodeRegex);
    }

    //Validate Room Number
    private static boolean validateRoomNumber(String input){
        //Set Room Number format
        String roomNumberRegex = "^[A-Za-z][0-9]{3}$";
        //Return whether the Room Number passed is in the correct format
        return input.matches(roomNumberRegex);
    }

    //Validate Employee ID Format
    private static boolean validateEmployeeId(String input){
        //Set Employee ID format
        String employeeIdRegex = "^[eE]-[0-9]{4}$";
        //Return whether the Employee ID passed is in the correct format
        return input.matches(employeeIdRegex);
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
    //Request Course Code
    public static String inputValidCourseCode(Scanner scanner){
        //Declare empty String to hold user input
        String input = "";
        //While input is not in valid Course Code format
        while (!validateCourseCode(input)) { 
            //If input is not empty, and in wrong format print error information
            if (!input.isEmpty()){
                //Print error message letting the user know to input using the Correct format
                System.out.println("Error: Course Code must be in valid format (AAAA####).");
            }
            //Prompt user for Course Code
            System.out.print("Enter Course Code (AAAA####): ");
            //Retrieve input from user with scanner
            input = scanner.nextLine();
            //Loop back to while statement to validate Course Code
        }
        //Return validated input, with uniform letter format (Uppercase)
        return input.toUpperCase();
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

    //Request generic String
    public static String inputValidString(Scanner scanner, String stringName){
        //Declare empty String to hold user input
        String input = "";
        //While input is blank
        while (input.isBlank()) { 
            //Prompt user for input
            System.out.print("Enter "+stringName+": ");
            //Retrieve input from user with scanner
            input = scanner.nextLine();
            //Loop back to while statement to validate String input
        }
        //Return non-null string
        return input;
    }

    // ========== Add/Remove Object Tools
    //InPersonCourse(code, name, teacher, room)
    public static void addInPersonCourse(Scanner scanner, ArrayList<Course> list){
        String code = inputValidCourseCode(scanner);
        String name = inputValidString(scanner, "Course Name");
        String teacher = inputValidString(scanner, "Course Instructor");
        String room = inputValidRoomNumber(scanner);
        list.add(new InPersonCourse(code, name, teacher, room));
        System.out.println(code + " added.");
    }
    //OnlineCourse(code, name, teacher, platform)
    public static void addOnlineCourse(Scanner scanner, ArrayList<Course> list){
        String code = inputValidCourseCode(scanner);
        String name = inputValidString(scanner, "Course Name");
        String teacher = inputValidString(scanner, "Course Instructor");
        String platform = inputValidString(scanner, "Platform");
        list.add(new OnlineCourse(code, name, teacher, platform));
        System.out.println(code + " added.");
    }
    //HybridCourse(code, name, teacher, room, platform)
    public static void addHybridCourse(Scanner scanner, ArrayList<Course> list){
        String code = inputValidCourseCode(scanner);
        String name = inputValidString(scanner, "Course Name");
        String teacher = inputValidString(scanner, "Course Instructor");
        String room = inputValidRoomNumber(scanner);
        String platform = inputValidString(scanner, "Platform");
        list.add(new HybridCourse(code, name, teacher, room, platform));
        System.out.println(code + " added.");
    }
    //Remove Course
    public static void removeCourse(ArrayList<Course> list, int courseIndex){
        String code = list.get(courseIndex).getCode();
        list.remove(list.get(courseIndex));
        System.out.println(code + " removed.");
    }

    //Student(name, id, email, program);
    public static void addStudent(Scanner scanner, ArrayList<Person> list){
        String name = inputValidString(scanner, "Student Name");
        String id = inputValidStudentId(scanner);
        String email = inputValidEmail(scanner);
        String program = inputValidString(scanner, "Program");
        list.add(new Student(name, id, email, program));
        System.out.println(name + " added.");
    }
    //Instructor(name, id, email, department);
    public static void addInstructor(Scanner scanner, ArrayList<Person> list){
        String name = inputValidString(scanner, "Instructor Name");
        String id = inputValidEmployeeId(scanner);
        String email = inputValidEmail(scanner);
        String department = inputValidString(scanner, "Department");
        list.add(new Instructor(name, id, email, department));
        System.out.println(name + " added.");
    }   
    //Remove Person 
    public static void removePerson(ArrayList<Person> list, int personIndex){
        String id = list.get(personIndex).getId();
        list.remove(list.get(personIndex));
        System.out.println(id + " removed.");
    }

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
    
    public static int menuChoice(Scanner scanner, String title, ArrayList<Person> list, int filterPersonType, boolean verbose, boolean select){
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
                if (verbose) {
                    //Print "(current list item #. \n all details)
                    System.out.println(String.valueOf(displayIndex.size()) + ". \n" + (list.get(i)).getDetails() + "\n");
                } else {
                    //Print "(current list item #) - (item)"
                    System.out.println(String.valueOf(displayIndex.size()) + " - " + (list.get(i)).getName());
                }    
            }
        }
        //Adds select function
        if(select){
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
        }
        //If list has no items, display text instead of items
        if (list.isEmpty()) {
            System.out.println("There's nothing here...");   
        }
        //Return selected menu option by its relation to the Master list index saved in displayIndex
        return (select) ? displayIndex.get(choice - 1) : 0;
    }
    
    //Custom Menu Structure for Selection from Course objects
    public static int menuChoice(Scanner scanner, String title, ArrayList<Course> list, String filterDelivery, boolean verbose, boolean select){
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
                if (verbose) {
                    //Print "(current list item #. \n all details)
                    System.out.println(String.valueOf(displayIndex.size()) + ". \n" + (list.get(i)).getDetails() + "\n");
                } else {
                    //Print "(current list item #) - (item)"
                    System.out.println(String.valueOf(displayIndex.size()) + " - " + (list.get(i)).getName());
                } 
            }
        }
        //Adds select function
        if(select){
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
        }
        //If list has no items, display text instead of items
        if (list.isEmpty()) {
            System.out.println("There's nothing here...");   
        }
        //Return selected menu option by its relation to the Master list index saved in displayIndex
        return (select) ? displayIndex.get(choice - 1) : 0;
    }
    
}

