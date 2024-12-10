package hugolini.taskflowapi.controller;

import hugolini.taskflowapi.model.Projeto;
import hugolini.taskflowapi.service.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<Projeto> criarProjeto(@Valid @RequestBody Projeto projeto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoService.criarProjeto(projeto));
    }

    @GetMapping
    public ResponseEntity<?> listarProjetos() {
        return ResponseEntity.ok(projetoService.listarProjetos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Projeto>> buscarProjetoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.buscarProjetoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProjeto(@PathVariable Long id) {
        projetoService.deletarProjeto(id);
        return ResponseEntity.status(HttpStatus.OK).body("Projeto com ID " + id + " deletado com sucesso.");
    }
}
