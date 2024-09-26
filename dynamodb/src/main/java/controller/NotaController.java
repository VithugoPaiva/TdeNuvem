package com.imepac.ads.dynamodb.controller;

import com.imepac.ads.dynamodb.dto.NotaDto;
import com.imepac.ads.dynamodb.entities.NotaEntity;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTemplate;

@RestController
@RequestMapping("/v1/notas")
public class NotaController {

    private final DynamoDbTemplate dynamoDbTemplate;

    // Construtor com injeção de dependência do DynamoDbTemplate
    public NotaController(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }

    // Endpoint para salvar uma nota
    @PostMapping("/{matricula}/{idDisciplina}")
    public void salvar(@PathVariable String matricula,
                       @PathVariable String idDisciplina,
                       @RequestBody NotaDto notaDto) {

        // Criar uma entidade NotaEntity utilizando o construtor
        NotaEntity notaEntity = new NotaEntity(matricula, idDisciplina, notaDto);

        // Salvar a entidade no DynamoDB
        dynamoDbTemplate.save(notaEntity);
    }
}
