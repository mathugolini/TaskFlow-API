package hugolini.taskflowapi.exceptions;

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

    @ExceptionHandler(ProjetoNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleProjetoNaoEncontradoException(ProjetoNaoEncontradoException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Projeto não encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ProjetosSemCadastroException.class)
    public ResponseEntity<Map<String, String>> handleProjetosNaoEncontradosException(ProjetosSemCadastroException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Nenhum projeto encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(TituloTarefaObrigatorioException.class)
    public ResponseEntity<Map<String, String>> handleTituloTarefaObrigatorioException(TituloTarefaObrigatorioException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Erro ao criar tarefa");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ProjetoNaoExisteException.class)
    public ResponseEntity<Map<String, String>> handleProjetoNaoExisteException(ProjetoNaoExisteException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Projeto não encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(TarefaNaoEncontradaException.class)
    public ResponseEntity<Map<String, String>> handleTarefaNaoEncontradaException(TarefaNaoEncontradaException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Tarefa não encontrada");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
