package hugolini.taskflowapi.exceptions;

public class ProjetoException extends RuntimeException{
    public ProjetoException(String message) {
        super(message);
    }

    public ProjetoException(String message, Throwable cause) {
        super(message, cause);
    }
}
