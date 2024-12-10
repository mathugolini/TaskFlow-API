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
        return projetoService.listarProjetos().isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há projetos cadastrados.")
                : ResponseEntity.ok(projetoService.listarProjetos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProjetoPorId(@PathVariable Long id) {
        Optional<Projeto> projeto = projetoService.buscarProjetoPorId(id);
        if (projeto.isPresent()) {
            return ResponseEntity.ok(projeto.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Projeto com ID " + id + " não encontrado ou já foi deletado.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProjeto(@PathVariable Long id) {
        return projetoService.buscarProjetoPorId(id).map(projeto -> { projetoService.deletarProjeto(id); return ResponseEntity.noContent().build(); }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
