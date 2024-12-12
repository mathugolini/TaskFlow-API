package hugolini.taskflowapi.exceptions;

public class TarefaDuplicadaException extends Exception {

    public TarefaDuplicadaException() {
        super("Já existe uma tarefa com este título.");
    }
}
