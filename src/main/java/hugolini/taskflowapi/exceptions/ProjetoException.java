package hugolini.taskflowapi.exceptions;

public class ProjetoException extends Exception{
    public ProjetoException(String message) {
        super(message);
    }

    public ProjetoException(String message, Throwable cause) {
        super(message, cause);
    }
}
