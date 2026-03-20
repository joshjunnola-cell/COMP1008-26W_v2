import java.util.ArrayList;
import java.util.Scanner;

public class CourseManagementSystem {
    private static ArrayList<Course> coursesTaught = new ArrayList<>();
    private static ArrayList<Person> personList = new ArrayList<>();

    public static void displayInfo(Scanner scanner, String object) {
        if (object.equals("Person")) {
            switch (Validator.menuChoice(scanner, "Display Person List", "All", "Students", "Instructors")) {
                case 1:
                    Validator.menuChoice(scanner, "All", personList, 0, true, false);
                    break;
                case 2:
                    Validator.menuChoice(scanner, "Students", personList, 1, true, false);
                    break;
                case 3:
                    Validator.menuChoice(scanner, "Instructors", personList, 2, true, false);
                    break;
            }
        } else if (object.equals("Course")) {
            switch (Validator.menuChoice(scanner, "Display Course List", "All", "In Person", "Online", "Hybrid")) {
                case 1:
                    Validator.menuChoice(scanner, "All", coursesTaught, "", true, false);
                    break;
                case 2:
                    Validator.menuChoice(scanner, "In Person", coursesTaught, "In-Person Delivery!", true, false);
                    break;
                case 3:
                    Validator.menuChoice(scanner, "Online", coursesTaught, "Online Delivery!", true, false);
                    break;
                case 4:
                    Validator.menuChoice(scanner, "Hybrid", coursesTaught, "Hybrid Delivery!", true, false);
                    break;
            }
        }
    }

    public static void add(Scanner scanner, String object) {
        if (object.equals("Person")) {
            switch (Validator.menuChoice(scanner, "Select Person Type to Add", "Student", "Instructor")) {
                case 1:
                    Validator.addStudent(scanner, personList);
                    break;
                case 2:
                    Validator.addInstructor(scanner, personList);
                    break;
            }
        } else if (object.equals("Course")) {
            switch (Validator.menuChoice(scanner, "Select Course Type to Add", "In Person", "Online", "Hybrid")) {
                case 1:
                    Validator.addInPersonCourse(scanner, coursesTaught);
                    break;
                case 2:
                    Validator.addOnlineCourse(scanner, coursesTaught);
                    break;
                case 3:
                    Validator.addHybridCourse(scanner, coursesTaught);
                    break;
            }
        }
    }

    public static void remove(Scanner scanner, String object) {
        if (object.equals("Person")) {
            switch (Validator.menuChoice(scanner, "Select Person Type to Remove", "Student", "Instructor")) {
                case 1:
                    Validator.removePerson(personList,
                            Validator.menuChoice(scanner, "Select Student to Remove", personList, 1, false, true));
                    break;
                case 2:
                    Validator.removePerson(personList,
                            Validator.menuChoice(scanner, "Select Instructor to Remove", personList, 2, false, true));
                    break;
            }
        } else if (object.equals("Course")) {
            switch (Validator.menuChoice(scanner, "Select Course Type to Remove", "In Person", "Online", "Hybrid")) {
                case 1:
                    Validator.removeCourse(coursesTaught, Validator.menuChoice(scanner, "Select Course to Remove",
                            coursesTaught, "In-Person Delivery!", false, true));
                    break;
                case 2:
                    Validator.removeCourse(coursesTaught, Validator.menuChoice(scanner, "Select Course to Remove",
                            coursesTaught, "Online Delivery!", false, true));
                    break;
                case 3:
                    Validator.removeCourse(coursesTaught, Validator.menuChoice(scanner, "Select Course to Remove",
                            coursesTaught, "Hybrid Delivery!", false, true));
                    break;
            }
        }
    }

    //Find Student by id search tool
    public static void searchByID(Scanner scanner){
        String searchID = Validator.inputValidStudentId(scanner);
        
        //searches through all id's to match input
        for (Person s : personList) {
            if (s.getId().equals(searchID)) {
                System.out.println(s.getDetails());
                break;
            }
        }
    }

    //Find Student by name search tool
    public static void searchByName(Scanner scanner){
        String searchName = Validator.inputValidString(scanner, "Student Name");

        //searches through all name's to match input
        for (Person s : personList) {
            if (s.getName().equals(searchName)) {
                System.out.println(s.getDetails());
                break;
            }
        }
    }

    public static void personMenu(Scanner scanner) {
        boolean localMenuActive = true;
        while (localMenuActive) {
            // Main menu switch case choices
            switch (Validator.menuChoice(scanner, "Person Menu", "Show All", "Add Person", "Remove Person",
                    "Search by Name", "Search by ID", "Exit")) {
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

    public static void courseMenu(Scanner scanner) {
        boolean localMenuActive = true;
        while (localMenuActive) {
            // Main menu switch case choices
            switch (Validator.menuChoice(scanner, "Course Menu", "Show All", "Add Course", "Remove Course", "Exit")) {
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

    public static void populate(Scanner scanner) {

    }

    public static void main(String[] args) {
        // Open instance of Scanner object
        Scanner scanner = new Scanner(System.in);
        // Declare int to hold choice value
        int choice = 0;
        // Declare active state boolean
        boolean courseManagementSystemActive = true;

        // While active, run Menu loop
        while (courseManagementSystemActive) {
            // Menu configuration using choice variable and menuChoice method
            choice = Validator.menuChoice(scanner, "Course Management System", "Person List", "Course List", "Populate",
                    "Exit");
            // Main menu switch case choices
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

        // Close instance of Scanner object
        scanner.close();
    }
}
