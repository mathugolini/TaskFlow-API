package hugolini.taskflowapi.exceptions;

public class TituloTarefaObrigatorioException extends Exception{

    public TituloTarefaObrigatorioException() {
        super("O título da tarefa é obrigatório.");
    }
}

