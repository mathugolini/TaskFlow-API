package hugolini.taskflowapi.exceptions;

public class ProjetosSemCadastroException extends Exception {

    public ProjetosSemCadastroException() {
        super("Não há projetos cadastrados.");
    }
}
