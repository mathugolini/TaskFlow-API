package hugolini.taskflowapi.service;

import hugolini.taskflowapi.dto.ProjetoDTO;
import hugolini.taskflowapi.exceptions.projeto.ProjetoException;
import hugolini.taskflowapi.exceptions.projeto.ProjetoNaoEncontradoException;
import hugolini.taskflowapi.exceptions.projeto.ProjetoNaoExisteException;
import hugolini.taskflowapi.exceptions.projeto.ProjetosSemCadastroException;
import hugolini.taskflowapi.model.Projeto;
import hugolini.taskflowapi.model.Tarefa;
import hugolini.taskflowapi.repository.ProjetoRepository;
import hugolini.taskflowapi.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Projeto criarProjeto(ProjetoDTO projeto) throws ProjetoException {
        if (projeto.getNome() == null || projeto.getNome().isEmpty()) {
            throw new ProjetoException(projeto.getNome());
        }
        return projetoRepository.save(new Projeto(projeto.getNome(), projeto.getDescricao()));
    }

    public Page<Projeto> listarProjetos(Integer pagina, Integer itens) throws ProjetosSemCadastroException {

        Page<Projeto> projetosPage = projetoRepository.findAll(PageRequest.of(pagina, itens));
        if (projetosPage.isEmpty()) {
            throw new ProjetosSemCadastroException();
        }
        return projetosPage;
    }

    @Transactional
    public Optional<Projeto> buscarProjetoPorId(String id) throws ProjetoNaoEncontradoException {

        Projeto projeto = projetoRepository.findById(id).orElse(null);

        if (projeto == null) {
            throw new ProjetoNaoEncontradoException(id);
        }
        projeto.getTarefas().size();
        return Optional.of(projeto);
    }

    @Transactional
    public void deletarProjeto(String id) throws ProjetoNaoEncontradoException {
        if (!projetoRepository.existsById(id)) {
            throw new ProjetoNaoEncontradoException(id);
        }
        projetoRepository.deleteById(id);
    }

    public Page<Projeto> buscarProjetosPorNome(String nome, Integer pagina, Integer itens, boolean exactMatch) throws ProjetoNaoExisteException {
        Pageable pageable = PageRequest.of(pagina, itens);
        Page<Projeto> projetos;

        if (exactMatch) {
            projetos = projetoRepository.findByNomeIgnoreCase(nome, pageable);
        } else {
            projetos = projetoRepository.findByNomeStartingWithIgnoreCase(nome, pageable);
        }
        if (projetos.isEmpty()) {
            throw new ProjetoNaoExisteException();
        }
        return projetos;
    }

    public Map<String, Long> contarTarefasPorStatus(String projetoId) throws ProjetoNaoEncontradoException {
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new ProjetoNaoEncontradoException(projetoId));

        Map<String, Long> contagemPorStatus = new HashMap<>();

        List<Tarefa> tarefas = tarefaRepository.findByProjeto(projeto);

        for (Tarefa tarefa : tarefas) {
            String status = tarefa.getStatus().name();
            contagemPorStatus.put(status, contagemPorStatus.getOrDefault(status, 0L) + 1);
        }
        return contagemPorStatus;
    }

}
