package com.br.pratica.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Produto {
    private Integer id;
    private String descricao;
    private Double preco;
}
