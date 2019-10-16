package br.com.gilmarioArantes.refatoracao.extrairClasse;

import lombok.Data;

@Data
public class User {
    private String name;
    private Integer id;
    private Payment payment;
    private String street;
    private String number;
    private String zipCode;
    private String city;
    private String country;
}
