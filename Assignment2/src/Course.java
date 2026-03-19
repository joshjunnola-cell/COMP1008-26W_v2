abstract class Course {
    
    private String code;
    private String name;
    
    // Constructor 
    public Course(String code, String name){
        // Initialize fields
        this.code = code;
        this.name = name;

    }

    //Getter and setter for code and name
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
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Course name cannot be empty.");
        }
        this.name = name;
    }

    // Abstract method used for polymorphism
    public abstract String getDetails();

}

class InPersonCourse extends Course{

}
class OnlineCourse extends Course{

}

class HybridCourse extends Course{

}
