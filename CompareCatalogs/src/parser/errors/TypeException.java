package parser.errors;

@SuppressWarnings("serial")
public class TypeException extends Exception{
    //Parameterless Constructor
    public TypeException() {}

    //Constructor that accepts a message
    public TypeException(String message){
       super(message);
    }
}