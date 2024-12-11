package hugolini.taskflowapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hugolini.taskflowapi.enums.StatusTarefaEnum;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Tarefa {

    @Id
    @Column(length = 36)
    private String id;

    @Column(nullable = false)
    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTarefaEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id", nullable = false)
    @JsonBackReference
    private Projeto projeto;

    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao, StatusTarefaEnum status, Projeto projeto) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.projeto = projeto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public StatusTarefaEnum getStatus() {
        return status;
    }

    public void setStatus(StatusTarefaEnum status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
