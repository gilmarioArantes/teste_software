package br.com.gilmarioArantes.refatoracao.moverMetodo;

import lombok.Data;

import java.util.Calendar;

@Data
public class UsuarioRefatorado {
    private String name;
    private Integer id;
    private Pagamento pagamento;

}
