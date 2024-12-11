package hugolini.taskflowapi.dto;

import hugolini.taskflowapi.model.Projeto;
import jakarta.validation.constraints.NotBlank;

public class TarefaDTO {

    @NotBlank(message = "O título da tarefa é obrigatório.")
    private String titulo;
    private String descricao;
    private String projetoId;

    public TarefaDTO() { }

    public TarefaDTO(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.projetoId = projetoId;
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

    public String getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(String projetoId) {
        this.projetoId = projetoId;
    }
}
