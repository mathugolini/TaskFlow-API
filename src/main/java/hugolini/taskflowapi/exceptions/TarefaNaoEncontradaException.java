package hugolini.taskflowapi.exceptions;

public class TarefaNaoEncontradaException extends RuntimeException {
    public TarefaNaoEncontradaException(Long id) {
        super("Tarefa não encontrada com ID: " + id);
    }
}
