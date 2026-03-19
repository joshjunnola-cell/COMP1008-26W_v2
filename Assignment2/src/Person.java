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

    //Getters
    public abstract String getName();
    public abstract String getId();
    public abstract String getEmail();

    
}
    //Extend Person in child classes
class Student extends Person {
    
}

    //Extend Person in child classes
class Instructor extends Person {

}
