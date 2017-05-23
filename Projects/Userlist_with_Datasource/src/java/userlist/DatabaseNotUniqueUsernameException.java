package userlist;

public class DatabaseNotUniqueUsernameException extends RuntimeException{

    public DatabaseNotUniqueUsernameException() {
        super("Der Name ist bereits vergeben");
    }
    
}
