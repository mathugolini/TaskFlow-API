package hugolini.taskflowapi.exceptions.tarefa;

public class TarefaDuplicadaException extends Exception {

    public TarefaDuplicadaException() {
        super("Já existe uma tarefa com este título.");
    }
}
