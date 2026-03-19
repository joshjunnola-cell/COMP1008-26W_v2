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
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Course name cannot be empty.");
        }
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    // Abstract method used for polymorphism
    public abstract String getDetails();

    // Returns new format
    @Override
    public String toString() {
        return String.format("Course Name: %s%nCourse Code: %s%nInstructor: %s",
                            getName(), getCode(), getTeacher());
    }

}

class InPersonCourse extends Course{

}

class OnlineCourse extends Course{

}

class HybridCourse extends Course{

}
