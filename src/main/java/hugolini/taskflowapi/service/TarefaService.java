package hugolini.taskflowapi.service;

import hugolini.taskflowapi.dto.TarefaDTO;
import hugolini.taskflowapi.enums.StatusTarefaEnum;
import hugolini.taskflowapi.exceptions.ProjetoNaoEncontradoException;
import hugolini.taskflowapi.exceptions.TarefaDuplicadaException;
import hugolini.taskflowapi.exceptions.TarefaNaoEncontradaException;
import hugolini.taskflowapi.exceptions.TituloTarefaObrigatorioException;
import hugolini.taskflowapi.model.Projeto;
import hugolini.taskflowapi.model.Tarefa;
import hugolini.taskflowapi.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ProjetoService projetoService;

    @Transactional
    public Tarefa criarTarefa(TarefaDTO tarefa) throws TarefaDuplicadaException, TituloTarefaObrigatorioException, ProjetoNaoEncontradoException {

        if (tarefa.getTitulo() == null || tarefa.getTitulo().isEmpty()) {
            throw new TituloTarefaObrigatorioException();
        }
        Projeto projeto = projetoService.buscarProjetoPorId(tarefa.getProjetoId())
                .orElseThrow(() -> new ProjetoNaoEncontradoException(tarefa.getProjetoId()));

        Tarefa possivelTarefa = tarefaRepository.findByTitulo(tarefa.getTitulo()).orElse(null);

        if (possivelTarefa != null) {
            throw new TarefaDuplicadaException();
        }
        return tarefaRepository.save(new Tarefa(tarefa.getTitulo(), tarefa.getDescricao(), StatusTarefaEnum.PENDENTE, projeto));
    }

    @Transactional
    public Tarefa atualizarStatusTarefa(String id, Tarefa tarefaAtualizada) throws TarefaNaoEncontradaException {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontradaException(id));
        if (tarefaAtualizada.getStatus() != null) {
            tarefa.setStatus(tarefaAtualizada.getStatus());
        }
        return tarefaRepository.save(tarefa);
    }

    @Transactional
    public boolean deletarTarefa(String id) throws TarefaNaoEncontradaException {
        if (!tarefaRepository.existsById(id)) {
            throw new TarefaNaoEncontradaException(id);
        }
        tarefaRepository.deleteById(id);
        return true;
    }

}
