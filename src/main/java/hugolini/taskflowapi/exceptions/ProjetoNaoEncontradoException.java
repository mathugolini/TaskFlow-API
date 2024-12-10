package hugolini.taskflowapi.exceptions;

public class ProjetoNaoEncontradoException extends RuntimeException {

    public ProjetoNaoEncontradoException(Long id) {
        super("Projeto com ID " + id + " não encontrado ou já foi deletado.");
    }
}
