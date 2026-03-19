public abstract class Person {
    //Abstract class contains common fields (name, ID, email)
    private String name;
    private String id;
    private String email;

    public Person(String name, String id, String email){
        this.name = name;
        this.id = id;
        this.email = email;
    }

}
    //Extend Person in child classes
class Student extends Person {

}

    //Extend Person in child classes
class Instructor extends Person {

}
