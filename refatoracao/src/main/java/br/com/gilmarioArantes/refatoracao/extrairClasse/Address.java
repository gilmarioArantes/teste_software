package br.com.gilmarioArantes.refatoracao.extrairClasse;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String number;
    private String zipCode;
    private String city;
    private String country;
}
