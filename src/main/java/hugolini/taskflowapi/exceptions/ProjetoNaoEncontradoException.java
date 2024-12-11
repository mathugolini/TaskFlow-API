package hugolini.taskflowapi.exceptions;

import java.util.UUID;

public class ProjetoNaoEncontradoException extends Exception {

    public ProjetoNaoEncontradoException(String id) {
        super("Projeto com ID " + id + " não encontrado ou já foi deletado.");
    }
}
