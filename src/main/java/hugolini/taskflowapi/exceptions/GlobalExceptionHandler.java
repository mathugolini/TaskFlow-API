package hugolini.taskflowapi.exceptions;

import hugolini.taskflowapi.exceptions.projeto.ProjetoNaoEncontradoException;
import hugolini.taskflowapi.exceptions.projeto.ProjetoNaoExisteException;
import hugolini.taskflowapi.exceptions.projeto.ProjetosSemCadastroException;
import hugolini.taskflowapi.exceptions.tarefa.TarefaDuplicadaException;
import hugolini.taskflowapi.exceptions.tarefa.TarefaNaoEncontradaException;
import hugolini.taskflowapi.exceptions.tarefa.TituloTarefaObrigatorioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> response = new HashMap<>();

        FieldError fieldError = ex.getBindingResult().getFieldError();
        if (fieldError != null) {
            response.put("message", fieldError.getDefaultMessage());
        } else {
            response.put("message", "Erro de validação desconhecido");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message",  ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(ProjetoNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleProjetoNaoEncontradoException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message",  ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ProjetosSemCadastroException.class)
    public ResponseEntity<Map<String, String>> handleProjetosNaoEncontradosException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message",  ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(TituloTarefaObrigatorioException.class)
    public ResponseEntity<Map<String, String>> handleTituloTarefaObrigatorioException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message",  ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ProjetoNaoExisteException.class)
    public ResponseEntity<Map<String, String>> handleProjetoNaoExisteException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message",  ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(TarefaNaoEncontradaException.class)
    public ResponseEntity<Map<String, String>> handleTarefaNaoEncontradaException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message",  ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(TarefaDuplicadaException.class)
    public ResponseEntity<Map<String, String>> handleTarefaDuplicadaException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
