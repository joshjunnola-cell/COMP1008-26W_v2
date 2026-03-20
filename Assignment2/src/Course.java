import java.util.Random;

//Creates a abstract class representing a general course
//contains common fields and behaviour shared by all course types
abstract class Course {
    
    //encapsulated fields common to all courses
    private String code;
    private String name;
    private String teacher;
    
    // Constructor
    public Course(String code, String name, String teacher){
        // Initialize fields
        this.code = code;
        this.name = name;
        this.teacher = teacher;
    }

    // Abstract method used for polymorphism
    //each course type returns its own delivery description
    public abstract String getDelivery();

    //Getter and setter for code/name/teacher
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        // Validation to be added.
        this.code = code;
    }

    public String getName() {
        return name;
    }
    // Ensures name is not blank (basic)
    public void setName(String name) {
        this.name = (!(name == null || name.isBlank())) ? name : this.name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    // Abstract method used for polymorphism to provide their own detailed output
    public abstract String getDetails();

}

//This class represents a course held in person.
class InPersonCourse extends Course{

    //Room where the course is to be held(includes the building letter)
    private String roomNumber; // 1 letter 3 numbers

    //Creates a new InPersonCourse object
    public InPersonCourse(String code, String name, String teacher, String room) {
        super(code, name, teacher);
        this.roomNumber = room;
    }

    //returns delivery type for polymorphism
    @Override
    public String getDelivery() {
        return "In-Person Delivery!";
    }

    //Returns formatted string that contains details only specific to in-person courses
    @Override
    public String getDetails() {
        return "In-Person Course: " + getName() + 
                " | Code: " + getCode() +
                " | Instructor: " + getTeacher() +
                " | Room: " + roomNumber;
    }
}

//This class represents a course held online
class OnlineCourse extends Course{

    //Where the course is to be delivered
    private String platform;

    //Creates a new OnlineCourse object
    public OnlineCourse(String code, String name, String teacher, String platform) {
        super(code, name, teacher);
        this.platform = platform;
    }

    //returns delivery type for polymorphism
    @Override
    public String getDelivery() {
        return "Online Delivery!";
    }

    //Returns formatted string that contains details only specific to Online courses
    @Override
    public String getDetails(){
        return "Online Course: " + getName() +
                " | Code: " + getCode() +
                " | Instructor: " + getTeacher() +
                " | Platform: " + platform;
    }
}

//This class represents courses that hold classes both online and in-person
class HybridCourse extends Course{

    //location fields for hybrid delivery
    private String room;
    private String platform;

    //randomized fields
    private String dayOfWeek;
    private int weekNumb;
    private String deliveryMethod;

    //Array of possible days of week
    private static final String[] days = {
        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
    };

    //Creates a new HybridCourse object and assigns random schedule
    public HybridCourse(String code, String name, String teacher, String room, String platform) {
        super(code, name, teacher);
        this.room = room;
        this.platform = platform;
        assignRandSchedule();
    }

    //Assigns a random day and week for the hybrid class
    private void assignRandSchedule() {
        Random rand = new Random();

        //Random day
        dayOfWeek = days[rand.nextInt(days.length)];

        //Random Week
        weekNumb = rand.nextInt(14) + 1;
    }

    //returns delivery type for polymorphism
    @Override
    public String getDelivery() {
        return "Hybrid Delivery!";
    }

    //Returns formatted string that contains details only specific to hybrid courses
    @Override
    public String getDetails() {
        
        //selects correct location based on delivery method
        this.deliveryMethod = (Math.random() < 0.8) ? "In-Person" : "Online";

        return "Hybrid Course: " + getName() +
                " | Code: " + getCode() +
                " | Instructor: " + getTeacher() +
                " | Week: " + weekNumb +
                " | Day: " + dayOfWeek +
                " | Delivery: " + deliveryMethod;
    }
}
