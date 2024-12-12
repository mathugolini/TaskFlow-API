package hugolini.taskflowapi.annotations;

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
        @ApiResponse(responseCode = "200", description = "Projeto deletado com sucesso",
                content = @Content(schema = @Schema(implementation = ErrorResponse.class),
                        examples = @ExampleObject(value = "{\n" +
                                "  \"message\": \"Projeto com ID 6d77a996-f4ec-4acf-af29-b4e977802953 deletado com sucesso.\"\n" +
                                "}"))
        ),
        @ApiResponse(responseCode = "404", description = "Projeto não encontrado para deleção.",
                content = @Content(schema = @Schema(implementation = ErrorResponse.class),
                        examples = @ExampleObject(value = "{\n" +
                                "  \"message\": \"Projeto com ID 6d77a996-f4ec-4acf-af29-b4e977802953 não encontrado ou já foi deletado.\"\n" +
                                "}"))
        ),
})
public @interface ApiResponseDeletarProjeto {
}
