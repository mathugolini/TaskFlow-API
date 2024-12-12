package hugolini.taskflowapi.annotations.projeto;

import hugolini.taskflowapi.dto.TarefasPorStatusDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.ErrorResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Contagem de tarefas por status retornada com sucesso",
                content = @Content(schema = @Schema(implementation = TarefasPorStatusDTO.class),
                        examples = @ExampleObject(value = "{\n" +
                                "  \"contagemPorStatus\": {\n" +
                                "    \"PENDENTE\": 3,\n" +
                                "    \"EM_ANDAMENTO\": 1,\n" +
                                "    \"CONCLUIDA\": 1\n" +
                                "  }\n" +
                                "}"))
        ),
        @ApiResponse(responseCode = "404", description = "Projeto não encontrado para deleção.",
                content = @Content(schema = @Schema(implementation = ErrorResponse.class),
                        examples = @ExampleObject(value = "{\n" +
                                "  \"message\": \"Projeto com ID 6d77a996-f4ec-4acf-af29-b4e977802953 não encontrado ou já foi deletado.\"\n" +
                                "}"))
        )
})
public @interface ApiResponseContagemTarefasPorStatus {
}