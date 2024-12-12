package hugolini.taskflowapi.controller;

import hugolini.taskflowapi.annotations.tarefa.ApiResponseAtualizaStatusTarefa;
import hugolini.taskflowapi.annotations.tarefa.ApiResponseCriaTarefa;
import hugolini.taskflowapi.annotations.tarefa.ApiResponseDeletarTarefa;
import hugolini.taskflowapi.dto.TarefaDTO;
import hugolini.taskflowapi.model.Tarefa;
import hugolini.taskflowapi.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
@Tag(name = "Tarefas", description = "Operações para criar e gerenciar as tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @ApiResponseCriaTarefa
    @Operation(summary = "Cria tarefa e associa a um projeto",
            description = "Este endpoint permite a criação de tarefas com ID(gerado automaticamente), Titulo(obrigatório), Descrição(opcional), Status(PENDENTE por padrão) e Data de criação(gerado automaticamente)" )
    @PostMapping
    public ResponseEntity <Tarefa> criarTarefa(@RequestBody @Validated TarefaDTO tarefa) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.criarTarefa(tarefa));
    }

    @ApiResponseAtualizaStatusTarefa
    @Operation(summary = "Atualiza status de uma tarefa",
            description = "Este endpoint permite a atualização de status: PENDENTE, EM_ANDAMENTO ou CONCLUIDA" )
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarStatusTarefa(@PathVariable String id, @RequestBody Tarefa tarefaAtualizada) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.atualizarStatusTarefa(id, tarefaAtualizada));
    }

    @ApiResponseDeletarTarefa
    @Operation(summary = "Deleta tarefa associada a um projeto",
            description = "Este endpoint permite a deleção de tarefas por ID" )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable String id) throws Exception {
        return tarefaService.deletarTarefa(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
