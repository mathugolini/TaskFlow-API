package hugolini.taskflowapi.repository;

import hugolini.taskflowapi.model.Projeto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, String> {

    Page<Projeto> findAll(Pageable pageable);

    Page<Projeto> findByNomeStartingWithIgnoreCase(String nome, Pageable pageable);

    Page<Projeto> findByNomeIgnoreCase(String nome, Pageable pageable);

}
