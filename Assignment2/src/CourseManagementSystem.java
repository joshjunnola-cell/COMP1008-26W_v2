import java.util.ArrayList;
import java.util.Scanner;
public class CourseManagementSystem {

    private static ArrayList<Course> coursesTaught = new ArrayList<>();
    private static ArrayList<Person> personList = new ArrayList<>();

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

    public static void main(String[] args){
        //Open instance of Scanner object
        Scanner scanner = new Scanner(System.in);





        //Close instance of Scanner object
        scanner.close();
    }
}