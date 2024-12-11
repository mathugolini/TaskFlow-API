package hugolini.taskflowapi.dto;

import jakarta.validation.constraints.NotBlank;

public class ProjetoDTO {

    @NotBlank(message = "O nome do projeto é obrigatório.")
    private String nome;
    private String descricao;

    public ProjetoDTO () {}

    public ProjetoDTO(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
