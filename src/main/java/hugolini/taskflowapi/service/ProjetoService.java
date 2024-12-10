package hugolini.taskflowapi.service;

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

    public Projeto criarProjeto(Projeto projeto) {
        if (projeto == null) {
            throw new IllegalArgumentException("Projeto não pode ser nulo");
        }
        if (projeto.getNome() == null || projeto.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do projeto não pode ser nulo ou vazio");
        }
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarProjetos() {
        return projetoRepository.findAll();
    }

    @Transactional
    public Optional<Projeto> buscarProjetoPorId(Long id) {
        Optional<Projeto> projeto = projetoRepository.findById(id);
        projeto.ifPresent(p -> p.getTarefas().size());
        return projeto;
    }

    @Transactional
    public void deletarProjeto(Long id) {
        projetoRepository.deleteById(id);
        entityManager.flush();
    }

}
