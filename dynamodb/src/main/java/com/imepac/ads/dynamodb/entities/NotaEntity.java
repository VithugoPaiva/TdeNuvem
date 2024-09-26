package com.imepac.ads.dynamodb.entities;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import com.imepac.ads.dynamodb.dto.NotaDto;

@DynamoDbBean
public class NotaEntity {

    private String PK;
    private String SK;
    private double nota;
    private String disciplina;
    private String professor;

    // Construtor padrão (necessário para o DynamoDB)
    public NotaEntity() {
    }

    // Construtor para criar a entidade a partir do DTO e dos parâmetros do método POST
    public NotaEntity(String matricula, String idDisciplina, NotaDto notaDto) {
        this.PK = matricula;
        this.SK = "NOTA#" + idDisciplina;  // Concatenação com o prefixo "NOTA#"
        this.nota = notaDto.nota();
        this.disciplina = notaDto.disciplina();
        this.professor = notaDto.professor();
    }

    @DynamoDbPartitionKey
    public String getPK() {
        return PK;
    }

    public void setPK(String PK) {
        this.PK = PK;
    }

    @DynamoDbSortKey
    public String getSK() {
        return SK;
    }

    public void setSK(String SK) {
        this.SK = SK;
    }

    @DynamoDbAttribute("Nota")
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @DynamoDbAttribute("Disciplina")
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @DynamoDbAttribute("Professor")
    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
