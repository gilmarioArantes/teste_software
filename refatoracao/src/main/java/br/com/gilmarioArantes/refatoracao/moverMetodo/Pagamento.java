package br.com.gilmarioArantes.refatoracao.moverMetodo;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
public class Pagamento {
    private Integer id;
    private Date month;
    private boolean confirmed;
    private Calendar confirmationDate;
}
