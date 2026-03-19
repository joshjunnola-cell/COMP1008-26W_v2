abstract class Course {
    
    private String code;
    private String name;
    
    // Constructor 
    public Course(String code, String name){
        // Initialize fields
        this.code = code;
        this.name = name;

    }

    

}

class InPersonCourse extends Course{

}
class OnlineCourse extends Course{

}

class HybridCourse extends Course{

}
