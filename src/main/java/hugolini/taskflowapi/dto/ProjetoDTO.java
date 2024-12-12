package hugolini.taskflowapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class ProjetoDTO {

    @NotBlank(message = "O nome do projeto é obrigatório.")
    @Schema(description = "Nome do projeto", example = "Projeto XYZ", required = true)
    private String nome;
    @Schema(description = "Descrição do projeto", example = "Este é um projeto de exemplo", required = false)
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
