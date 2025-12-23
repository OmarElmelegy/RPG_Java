package util;

// Extending Exception makes this a "Checked Exception"
// (Java will force you to handle it with try-catch)
public class RPGException extends Exception {

    public RPGException(String message) {
        super(message); // Pass the message up to the parent Exception class
    }
}
