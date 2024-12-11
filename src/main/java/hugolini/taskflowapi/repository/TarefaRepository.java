package hugolini.taskflowapi.repository;

import hugolini.taskflowapi.enums.StatusTarefaEnum;
import hugolini.taskflowapi.model.Projeto;
import hugolini.taskflowapi.model.Tarefa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, String> {
    Page<Tarefa> findAll(Pageable pageable);

    Optional<Tarefa> findByTitulo(String titulo);

    List<Tarefa> findByProjeto(Projeto projeto);
}
