import java.util.ArrayList;
import java.util.Scanner;
public class CourseManagementSystem {
    private static ArrayList<Course> coursesTaught = new ArrayList<>();
    private static ArrayList<Person> personList = new ArrayList<>();




    

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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
            }
        }
        



        //Close instance of Scanner object
        scanner.close();
    }
}
