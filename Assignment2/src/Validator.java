//Validator Utility Class


public class Validator {

    public static boolean validateStudentId(String input){
        //Set Student ID format
        String studentIdRegex = "^[sS]-[0-9]{4}$";
        //return wether the Student ID passed is in the correct format
        return input.matches(studentIdRegex);
    }

    public static void validateEmail(String input){

    }


    public static String inputValidStudentId(){

        return "";
    }

    public static String inputValidEmail(){
        
        return "";
    }
    
}

