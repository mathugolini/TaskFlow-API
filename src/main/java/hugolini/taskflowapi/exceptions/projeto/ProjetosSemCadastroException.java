package hugolini.taskflowapi.exceptions.projeto;

public class ProjetosSemCadastroException extends Exception {

    public ProjetosSemCadastroException() {
        super("Não há projetos cadastrados.");
    }
}
