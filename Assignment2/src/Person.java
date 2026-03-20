public abstract class Person {
    //Abstract class contains common fields (name, ID, email)
    private String name;
    private String id;
    private String email;

    public Person(String name, String id, String email){
        //Initialize fields
        this.name = name;
        this.id = id;
        this.email = email;
    }

    // Abstract method used for polymorphism
    public abstract int getPersonType();

    //Getters
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    //Setters
    public void setName(String name) {
        this.name = (!(name == null || name.isBlank())) ? name : this.name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Abstract for polymorphism
    public abstract String getDetails();
    
}
    //Extend Person in child classes
class Student extends Person {
    
    private String program;
    //Creates a new student object
    public Student(String name, String id, String email, String program) {
        super(name, id, email);
        this.program = program;
    }

    @Override
    public int getPersonType(){
        return 1;
    }

    //Returns formatted string that contains details only specific to students
    @Override
    public String getDetails() {
        return "Student: " + getName() +
                " | ID: " + getId() +
                " | Email: " + getEmail() + 
                " | Program: " + program;
    }
}

    //Extend Person in child classes
class Instructor extends Person {

    private String department;
    //Creates a new instructor object
    public Instructor(String name, String id, String email, String department) {
        super(name, id, email);
        this.department = department;
    }

    @Override
    public int getPersonType(){
        return 2;
    }

    //Returns formatted string that contains details only specific to instructors
    @Override
    public String getDetails() {
        return "Instructor: " + getName() +
                " | ID: " + getId() +
                " | Email: " + getEmail() +
                " | Department: " + department;
    }

}
