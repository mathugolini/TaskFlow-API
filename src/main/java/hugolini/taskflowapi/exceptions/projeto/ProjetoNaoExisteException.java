package hugolini.taskflowapi.exceptions;

public class ProjetoNaoExisteException extends Exception {
    public ProjetoNaoExisteException() {
        super("Projeto não encontrado.");
    }
}
