import java.util.ArrayList;
import java.util.Scanner;
public class CourseManagementSystem {
    private static ArrayList<Course> coursesTaught = new ArrayList<>();
    private static ArrayList<Person> personList = new ArrayList<>();

    
    
    
    
    public static void displayInfo(Scanner scanner, String object){

    }
    public static void add(Scanner scanner, String object){

    }
    public static void remove(Scanner scanner, String object){

    }

    public static void searchByName(Scanner scanner){

    }
    public static void searchByID(Scanner scanner){
        
    }
    public static void personMenu(Scanner scanner){
        int localChoice = 0;
        boolean localMenuActive = true;
        while(localMenuActive){
            //Menu configuration using choice variable and menuChoice method
                localChoice = Validator.menuChoice(scanner, "Person Menu", "Show All","Add Person", "Remove Person", "Search by Name", "Search by ID", "Exit");
                //Main menu switch case choices
                switch (localChoice) {
                    case 1:
                        displayInfo(scanner, "Person");
                        break;
                    case 2:
                        add(scanner, "Person");
                        break;
                    case 3:
                        remove(scanner, "Person");
                        break;
                    case 4:
                        searchByName(scanner);
                        break;
                    case 5:
                        searchByID(scanner);
                        break;
                    case 6:
                        localMenuActive = false;
                        break;
                }
        }
        
    }
    public static void courseMenu(Scanner scanner){
        int localChoice = 0;
        boolean localMenuActive = true;
        while(localMenuActive){
            //Menu configuration using choice variable and menuChoice method
                localChoice = Validator.menuChoice(scanner, "Course Menu", "Show All","Add Course", "Remove Course", "Exit");
                //Main menu switch case choices
                switch (localChoice) {
                    case 1:
                        displayInfo(scanner, "Course");
                        break;
                    case 2:
                        add(scanner, "Course");
                        break;
                    case 3:
                        remove(scanner, "Course");
                        break;
                    case 4:
                        localMenuActive = false;
                        break;
                }
        }
    }
    public static void populate(Scanner scanner){

    }
    
    

    




    

    public static void main(String[] args){
        //Open instance of Scanner object
        Scanner scanner = new Scanner(System.in);
        //Declare int to hold choice value
        int choice = 0;
        //Declare active state boolean
        boolean courseManagementSystemActive = true;

        //While active, run Menu loop
        while (courseManagementSystemActive) {
            //Menu configuration using choice variable and menuChoice method
            choice = Validator.menuChoice(scanner, "Course Management System", "Person List", "Course List", "Populate", "Exit");
            //Main menu switch case choices
            switch (choice) {
                case 1:
                    personMenu(scanner);
                    break;
                case 2:
                    courseMenu(scanner);
                    break;
                case 3:
                    populate(scanner);
                    break;
                case 4:
                    courseManagementSystemActive = false;
                    break;
            }
        }
        



        //Close instance of Scanner object
        scanner.close();
    }
}
