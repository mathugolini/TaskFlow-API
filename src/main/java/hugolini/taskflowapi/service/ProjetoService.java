package hugolini.taskflowapi.service;

import hugolini.taskflowapi.exceptions.ProjetoException;
import hugolini.taskflowapi.exceptions.ProjetoNaoEncontradoException;
import hugolini.taskflowapi.exceptions.ProjetosSemCadastroException;
import hugolini.taskflowapi.model.Projeto;
import hugolini.taskflowapi.repository.ProjetoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Projeto criarProjeto(Projeto projeto) {
        if (projeto.getNome() == null || projeto.getNome().isEmpty()) {
            throw new ProjetoException(projeto.getNome());
        }
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarProjetos() {
        List<Projeto> projetos = projetoRepository.findAll();
        if (projetos.isEmpty()) {
            throw new ProjetosSemCadastroException();
        }
        return projetos;
    }

    @Transactional
    public Optional<Projeto> buscarProjetoPorId(Long id) {

        Optional<Projeto> projeto = projetoRepository.findById(id);

        if (projeto.isEmpty()) {
            throw new ProjetoNaoEncontradoException(id);
        }
        projeto.get().getTarefas().size();
        return Optional.of(projeto.get());
    }

    @Transactional
    public void deletarProjeto(Long id) {
        if (!projetoRepository.existsById(id)) {
            throw new ProjetoNaoEncontradoException(id);
        }
        projetoRepository.deleteById(id);
        entityManager.flush();
    }
}
