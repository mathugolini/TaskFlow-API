package hugolini.taskflowapi.exceptions;

public class TarefaException extends RuntimeException{

    public TituloTarefaObrigatorioException() {
        super("O título da tarefa é obrigatório.");
    }
}

public class ProjetoNaoEncontradoException extends RuntimeException {
    public ProjetoNaoEncontradoException() {
        super("Projeto não encontrado.");
    }
}
