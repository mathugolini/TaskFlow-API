package hugolini.taskflowapi.exceptions;

public class ProjetosSemCadastroException extends RuntimeException {

    public ProjetosSemCadastroException() {
        super("Não há projetos cadastrados.");
    }
}
