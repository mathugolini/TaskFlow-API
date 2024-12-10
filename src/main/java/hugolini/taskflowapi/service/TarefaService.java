package hugolini.taskflowapi.service;

import hugolini.taskflowapi.exceptions.ProjetoNaoEncontradoException;
import hugolini.taskflowapi.exceptions.TarefaNaoEncontradaException;
import hugolini.taskflowapi.exceptions.TituloTarefaObrigatorioException;
import hugolini.taskflowapi.model.Projeto;
import hugolini.taskflowapi.model.Tarefa;
import hugolini.taskflowapi.repository.TarefaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ProjetoService projetoService;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Tarefa criarTarefa(Tarefa tarefa) {

        if (tarefa.getTitulo() == null || tarefa.getTitulo().isEmpty()) {
            throw new TituloTarefaObrigatorioException();
        }
        Projeto projeto = projetoService.buscarProjetoPorId(tarefa.getProjeto().getId())
                .orElseThrow(() -> new ProjetoNaoEncontradoException(tarefa.getProjeto().getId()));

        if (projeto.getId() != null) {
            projeto = entityManager.merge(projeto);
        } else {
            entityManager.persist(projeto);
        }
        tarefa.setProjeto(projeto);
        return tarefaRepository.save(tarefa);
    }

    @Transactional
    public Tarefa atualizarStatusTarefa(Long id, Tarefa tarefaAtualizada) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontradaException(id));
        if (tarefaAtualizada.getStatus() != null) {
            tarefa.setStatus(tarefaAtualizada.getStatus());
        }
        return tarefaRepository.save(tarefa);
    }

    @Transactional
    public boolean deletarTarefa(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new TarefaNaoEncontradaException(id);
        }
        tarefaRepository.deleteById(id);
        return true;
    }
}
