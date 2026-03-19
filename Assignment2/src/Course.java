abstract class Course {
    
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
        // Sets name and checks that user is not trying to enter a blank
    public void setName(String name) {
        this.name = (!(name == null || name.isBlank())) ? name : this.name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    // Abstract method used for polymorphism
    public abstract String getDetails();

}

//This class represents a course held in person.
class InPersonCourse extends Course{

    //Room where the course is to be held(includes the building letter)
    private String roomNumber; // 3 numbers 1 letter

    //Creates a new InPersonCourse object
    public InPersonCourse(String code, String name, String teacher, String room) {
        super(code, name, teacher);
        this.roomNumber = room;
    }

    //Returns formatted string that contains details only specific to in-person courses
    @Override
    public String getDetails() {
        return "In-Person Course: " + getName() + 
                "Code: " + getCode() +
                "Instructor: " + getTeacher() +
                "Room: " + roomNumber;
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

    //Returns formatted string that contains details only specific to Online courses
    @Override
    public String getDetails(){
        return "Online Course: " + getName() +
                "Code: " + getCode() +
                "Instructor: " + getTeacher() +
                "Platform: " + platform;
    }
}

//This class represents courses that hold classes both online and in-person
class HybridCourse extends Course{

    //Where the course is to be delivered
    private String room;
    private String platform;

    //Creates a new HybridCourse object
    public HybridCourse(String code, String name, String teacher, String room, String platform) {
        super(code, name, teacher);
        this.room = room;
        this.platform = platform;
    }

    //Returns formatted string that contains details only specific to hybrid courses
    @Override
    public String getDetails() {
        return "Hybrid Course: " + getName() +
                "Code: " + getCode() +
                "Instructor: " + getTeacher() +
                "Room: " + room +
                "Platform: " + platform;
    }
}
