package hugolini.taskflowapi.exceptions.tarefa;

public class TituloTarefaObrigatorioException extends Exception{

    public TituloTarefaObrigatorioException() {
        super("O título da tarefa é obrigatório.");
    }
}

