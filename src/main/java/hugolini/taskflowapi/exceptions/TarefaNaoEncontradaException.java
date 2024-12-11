package hugolini.taskflowapi.exceptions;

import java.util.UUID;

public class TarefaNaoEncontradaException extends Exception {
    public TarefaNaoEncontradaException(String id) {
        super("Tarefa não encontrada com ID: " + id);
    }
}
