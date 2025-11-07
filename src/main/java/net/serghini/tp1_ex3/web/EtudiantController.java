package net.serghini.tp1_ex3.web;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.AllArgsConstructor;
import net.serghini.tp1_ex3.dtos.RequestEtudiantDto;
import net.serghini.tp1_ex3.dtos.ResponseAllEtudiantsDTO;
import net.serghini.tp1_ex3.dtos.ResponseEtudiantDto;
import net.serghini.tp1_ex3.services.EtudiantService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@OpenAPIDefinition(
        info = @Info(
                title = "Gestion des etudiants",
                description = "cette api offre tous les méthodes pour gérer les etudiants",
                version = "1.0.0"
        ),
        servers = @Server(
                url = "http://localhost:8082"
        )
)






@RestController
@RequestMapping("/v1/etudiants")
@AllArgsConstructor

public class EtudiantController {
    private EtudiantService etudiantService;



    @Operation(
            summary = " récuperer liste des etudiants",

            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregiter",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ResponseAllEtudiantsDTO.class ))
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )



    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ResponseAllEtudiantsDTO>>  getAllEtudiants() {
        return ResponseEntity.ok(etudiantService.getAllEtudiants());
    }

    @Operation(
            summary = " récupérer etudiants par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien récuperer",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseAllEtudiantsDTO.class )
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )
    @PreAuthorize("hasAuthority('ADMIN')")

    @GetMapping("/{id}")
    public ResponseEntity<ResponseEtudiantDto>  getEtudiantById(@PathVariable("id") Long id) {


        return ResponseEntity.ok(etudiantService.getEtudiantById(id));
    }




    @Operation(
            summary = " creer une filiere",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RequestEtudiantDto.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregistrer",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseEtudiantDto.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )




    @PreAuthorize("hasAuthority('ADMIN')")

    @PostMapping
    public ResponseEntity<ResponseEtudiantDto> createEtudiant(@RequestBody RequestEtudiantDto requestEtudiantDto) {


        return ResponseEntity.ok(etudiantService.addEtudiant(requestEtudiantDto));


    }

    @Operation(
            summary = " Modifier etudiant",
            parameters = @Parameter(name = "id", required = true),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RequestEtudiantDto.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien modifier",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseEtudiantDto.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('ADMIN')")

    @PutMapping("/{id}")
    public ResponseEntity<ResponseEtudiantDto> updateEtu(@PathVariable Long id, @RequestBody RequestEtudiantDto requestEtudiantDto) {


        return ResponseEntity.ok(etudiantService.update_etu(id,requestEtudiantDto));
    }






    @Operation(
            summary = " supprimer etudiants par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien supprimer"),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )


    @PreAuthorize("hasAuthority('ADMIN')")

    @DeleteMapping("{id}")
    public ResponseEntity DeleteMapping(@PathVariable Long id) {

        etudiantService.delete_etu(id);
        return ResponseEntity.ok().build();
    }



}