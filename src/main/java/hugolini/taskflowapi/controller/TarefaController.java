package hugolini.taskflowapi.controller;

import hugolini.taskflowapi.dto.TarefaDTO;
import hugolini.taskflowapi.model.Tarefa;
import hugolini.taskflowapi.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity <Tarefa> criarTarefa(@RequestBody @Validated TarefaDTO tarefa) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.criarTarefa(tarefa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarStatusTarefa(@PathVariable String id, @RequestBody Tarefa tarefaAtualizada) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.atualizarStatusTarefa(id, tarefaAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable String id) throws Exception {
        return tarefaService.deletarTarefa(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
