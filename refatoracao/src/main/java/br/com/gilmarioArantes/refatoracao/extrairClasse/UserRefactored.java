package br.com.gilmarioArantes.refatoracao.extrairClasse;

import lombok.Data;

@Data
public class UserRefactored {
    private String name;
    private Integer id;
    private Payment payment;
    private Address adress;
}
