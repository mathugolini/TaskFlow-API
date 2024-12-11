package hugolini.taskflowapi.controller;

import hugolini.taskflowapi.dto.ProjetoDTO;
import hugolini.taskflowapi.dto.TarefasPorStatusDTO;
import hugolini.taskflowapi.enums.StatusTarefaEnum;
import hugolini.taskflowapi.exceptions.ProjetoNaoEncontradoException;
import hugolini.taskflowapi.model.Projeto;
import hugolini.taskflowapi.model.Tarefa;
import hugolini.taskflowapi.repository.TarefaRepository;
import hugolini.taskflowapi.service.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping
    public ResponseEntity<Projeto> criarProjeto(@Valid @RequestBody ProjetoDTO projeto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoService.criarProjeto(projeto));
    }

    @GetMapping
    public ResponseEntity<Page<Projeto>> listarProjetos(@RequestParam Integer pagina,
                                                        @RequestParam Integer itens) throws Exception {
        return ResponseEntity.ok(projetoService.listarProjetos(pagina, itens));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Projeto>> buscarProjetoPorId(@PathVariable String id) throws Exception{
        return ResponseEntity.ok(projetoService.buscarProjetoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProjeto(@PathVariable String id) throws Exception{
        projetoService.deletarProjeto(id);
        return ResponseEntity.status(HttpStatus.OK).body("Projeto com ID " + id + " deletado com sucesso.");
    }

    @GetMapping("/busca")
    public Page<Projeto> buscarProjetosPorNome(
            @RequestParam String nome,
            @RequestParam Integer pagina,
            @RequestParam Integer itens,
            @RequestParam(required = false, defaultValue = "false") boolean exactMatch) {

        return projetoService.buscarProjetosPorNome(nome, pagina, itens, exactMatch);
    }

    @GetMapping("/{id}/contagem-tarefas-status")
    public TarefasPorStatusDTO contarTarefasPorStatus(@PathVariable String id) throws ProjetoNaoEncontradoException {
        Map<String, Long> contagem = projetoService.contarTarefasPorStatus(id);
        return new TarefasPorStatusDTO(contagem);
    }
}
