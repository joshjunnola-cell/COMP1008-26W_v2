import java.util.ArrayList;
import java.util.Scanner;

public class CourseManagementSystem {
    //Stores all courses and person objects in arrays
    private static ArrayList<Course> coursesTaught = new ArrayList<>();
    private static ArrayList<Person> personList = new ArrayList<>();


    //Keeps displayed text until user chooses to move on
    public static void menuHold(Scanner scanner){
        System.out.println("Hit Enter to exit the menu.");
        scanner.nextLine();
    }

    //Displays info about either people or courses, filters by type using validator.menuChoice
    public static void displayInfo(Scanner scanner, String object) {
        
        //displays person list
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
        // displays course list
        } else if (object.equals("Course")) {
            switch (Validator.menuChoice(scanner, "Display Course List", "All", "In Person", "Online", "Hybrid")) {
                case 1:
                    Validator.menuChoice(scanner, "All", coursesTaught, "none", true, false);
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
        //Keeps displayed text until user chooses to move on
        menuHold(scanner);
    }

    //Adds either a person or course depending on user selection
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

    //Removes either a Person or course depending on user selection
    public static void remove(Scanner scanner, String object) {
        if (object.equals("Person")) {
            switch (Validator.menuChoice(scanner, "Select Person Type to Remove", "Student", "Instructor")) {

                case 1: // removes student
                    Validator.removePerson(personList,
                            Validator.menuChoice(scanner, "Select Student to Remove", personList, 1, false, true));
                    break;

                case 2: // removes instructor
                    Validator.removePerson(personList,
                            Validator.menuChoice(scanner, "Select Instructor to Remove", personList, 2, false, true));
                    break;
            }
        } else if (object.equals("Course")) {
            switch (Validator.menuChoice(scanner, "Select Course Type to Remove", "In Person", "Online", "Hybrid")) {

                case 1: //remove in-person course
                    Validator.removeCourse(coursesTaught, Validator.menuChoice(scanner, "Select Course to Remove",
                            coursesTaught, "In-Person Delivery!", false, true));
                    break;

                case 2: //remove online course
                    Validator.removeCourse(coursesTaught, Validator.menuChoice(scanner, "Select Course to Remove",
                            coursesTaught, "Online Delivery!", false, true));
                    break;

                case 3: //remove hybrid course
                    Validator.removeCourse(coursesTaught, Validator.menuChoice(scanner, "Select Course to Remove",
                            coursesTaught, "Hybrid Delivery!", false, true));
                    break;
            }
        }
        //Keeps displayed text until user chooses to move on
        menuHold(scanner);
    }

    //Find Student by id search tool
    public static void searchByID(Scanner scanner){
        String searchID = Validator.inputValidStudentId(scanner);
        
        //searches through all id's to match input
        for (Person s : personList) {
            if (s.getId().equalsIgnoreCase(searchID)) {
                System.out.println(s.getDetails()+"\n");
                break;
            }
        }
        //Keeps displayed text until user chooses to move on
        menuHold(scanner);
    }

    //Find Student by name search tool
    public static void searchByName(Scanner scanner){
        String searchName = Validator.inputValidString(scanner, "Student Name");

        //searches through all name's to match input
        for (Person s : personList) {
            if (s.getName().equalsIgnoreCase(searchName)) {
                System.out.println(s.getDetails()+"\n");
                break;
            }
        }
        //Keeps displayed text until user chooses to move on
        menuHold(scanner);
    }

    //menu for all person-related operations
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

    //all course-related operations
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

    
    
    //Quickly fills all categories with objects upon call
    public static void populate() {
        personList.add(new Student("Josh1", "S-0001", "josh1@georgian.ca", "Computer Programming & Analysis"));
        personList.add(new Student("Josh2", "S-0002", "josh2@georgian.ca", "Computer Programming & Analysis"));
        personList.add(new Student("Josh3", "S-0003", "josh3@georgian.ca", "Computer Programming & Analysis"));
        personList.add(new Student("Josh4", "S-0004", "josh4@georgian.ca","Computer Programming & Analysis"));

        personList.add(new Instructor("Instructor1", "E-0001", "inst1@georgian.ca", "Computer Programming"));
        personList.add(new Instructor("Instructor2", "E-0002", "inst2@georgian.ca", "Computer Programming"));
        personList.add(new Instructor("Instructor3", "E-0003", "inst3@georgian.ca", "Computer Programming"));
        personList.add(new Instructor("Instructor4", "E-0004", "inst4@georgian.ca", "Computer Programming"));

        coursesTaught.add(new InPersonCourse("COMP1001", "Computers and Stuff 1", "Instructor1", "K318"));
        coursesTaught.add(new InPersonCourse("COMP1002", "Computers and Stuff 2", "Instructor2", "K224"));
        coursesTaught.add(new InPersonCourse("COMP1003", "Computers and Stuff 3", "Instructor3", "K320"));
        coursesTaught.add(new InPersonCourse("COMP1004", "Computers and Stuff 4", "Instructor4", "K322"));

        coursesTaught.add(new OnlineCourse("COMP1005", "Computers and Stuff 5", "Instructor5", "BlackBoard"));
        coursesTaught.add(new OnlineCourse("COMP1006", "Computers and Stuff 6", "Instructor6", "D2L"));
        coursesTaught.add(new OnlineCourse("COMP1007", "Computers and Stuff 7", "Instructor7", "Zoom"));
        coursesTaught.add(new OnlineCourse("COMP1008", "Computers and Stuff 8", "Instructor8", "Carrier Pigeon"));

        coursesTaught.add(new HybridCourse("COMP1009", "Computers and Stuff 9", "Instructor9", "A216", "Blackboard"));
        coursesTaught.add(new HybridCourse("COMP1010", "Computers and Stuff 10", "Instructor10", "B124", "Blackboard"));
        coursesTaught.add(new HybridCourse("COMP1011", "Computers and Stuff 11", "Instructor11", "M330", "Blackboard"));
        coursesTaught.add(new HybridCourse("COMP1012", "Computers and Stuff 12", "Instructor12", "M124", "Blackboard"));

    }

    //main entry for Course Management System
    public static void main(String[] args) {
        // Open instance of Scanner object
        Scanner scanner = new Scanner(System.in);
        // Declare active state boolean
        boolean courseManagementSystemActive = true;

        // While active, run Menu loop
        while (courseManagementSystemActive) {
            // Main menu switch case choices
            switch (Validator.menuChoice(scanner, "Course Management System", "Person List", "Course List", "Populate",
                    "Exit")) {
                case 1:
                    personMenu(scanner);
                    break;
                case 2:
                    courseMenu(scanner);
                    break;
                case 3:
                    populate();
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
