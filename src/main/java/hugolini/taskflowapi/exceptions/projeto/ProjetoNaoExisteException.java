package hugolini.taskflowapi.exceptions.projeto;

public class ProjetoNaoExisteException extends Exception {
    public ProjetoNaoExisteException() {
        super("Projeto não encontrado.");
    }
}
