package hugolini.taskflowapi.exceptions;

public class TituloTarefaObrigatorioException extends RuntimeException{

    public TituloTarefaObrigatorioException() {
        super("O título da tarefa é obrigatório.");
    }
}

