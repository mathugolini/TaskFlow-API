package hugolini.taskflowapi.exceptions;

public class ProjetoNaoExisteException extends RuntimeException {
    public ProjetoNaoExisteException() {
        super("Projeto não encontrado.");
    }
}
