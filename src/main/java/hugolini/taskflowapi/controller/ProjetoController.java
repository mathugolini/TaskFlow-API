package hugolini.taskflowapi.controller;

import hugolini.taskflowapi.annotations.projeto.*;
import hugolini.taskflowapi.dto.ProjetoDTO;
import hugolini.taskflowapi.dto.TarefasPorStatusDTO;
import hugolini.taskflowapi.model.Projeto;
import hugolini.taskflowapi.service.ProjetoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/projetos")
@Tag(name = "Projetos", description = "Operações para criar e gerenciar os projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @ApiResponseCriarProjeto
    @Operation(summary = "Cria projeto",
            description = "Este endpoint permite a criação de projetos com ID(gerado automaticamente), Nome(obrigatório), Descrição(opcional) e Data de criação(gerado automaticamente)" )
    @PostMapping
    public ResponseEntity<Projeto> criarProjeto(@Valid @RequestBody ProjetoDTO projeto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoService.criarProjeto(projeto));
    }

    @ApiResponseListarProjetos
    @Operation(summary = "Lista todos os projetos com paginação e suas respectivas tarefas associadas",
            description = "Este endpoint permite listar os projetos paginados (página e número de itens por página).")
    @GetMapping
    public ResponseEntity<Page<Projeto>> listarProjetos(@RequestParam Integer pagina,
                                                        @RequestParam Integer itens) throws Exception {
        return ResponseEntity.ok(projetoService.listarProjetos(pagina, itens));
    }

    @ApiResponseBuscarProjetoPorId
    @Operation(summary = "Lista projeto por ID e suas respectivas tarefas associadas",
            description = "Este endpoint permite listar os projetos por ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Projeto>> buscarProjetoPorId(@PathVariable String id) throws Exception{
        return ResponseEntity.ok(projetoService.buscarProjetoPorId(id));
    }

    @ApiResponseDeletarProjeto
    @Operation(summary = "Deleta projeto por ID e suas respectivas tarefas associadas",
            description = "Este endpoint permite deletar os projetos por ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProjeto(@PathVariable String id) throws Exception{
        projetoService.deletarProjeto(id);
        return ResponseEntity.status(HttpStatus.OK).body("Projeto com ID " + id + " deletado com sucesso.");
    }

    @ApiResponseBuscarProjetoPorNome
    @Operation(summary = "Busca projetos pelo nome completo e partes iniciais do nome",
            description = "Este endpoint permite buscar projetos por nome completo e partes iniciais do nome")
    @GetMapping("/busca")
    public Page<Projeto> buscarProjetosPorNome(
            @RequestParam String nome,
            @RequestParam Integer pagina,
            @RequestParam Integer itens,
            @RequestParam(required = false, defaultValue = "false") boolean exactMatch) throws Exception {

        return projetoService.buscarProjetosPorNome(nome, pagina, itens, exactMatch);
    }

    @ApiResponseContagemTarefasPorStatus
    @Operation(summary = "Busca para retornar a contagem de tarefas por status em um projeto.",
            description = "Este endpoint permite retornar a contagem de tarefas por status em um projeto.")
    @GetMapping("/{id}/contagem-tarefas-status")
    public TarefasPorStatusDTO contarTarefasPorStatus(@PathVariable String id) throws Exception {
        Map<String, Long> contagem = projetoService.contarTarefasPorStatus(id);
        return new TarefasPorStatusDTO(contagem);
    }
}
