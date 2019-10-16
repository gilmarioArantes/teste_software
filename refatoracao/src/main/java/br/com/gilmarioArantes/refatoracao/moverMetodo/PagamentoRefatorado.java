package br.com.gilmarioArantes.refatoracao.moverMetodo;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
public class PagamentoRefatorado {

    private Integer id;
    private Date month;
    private boolean confirmed;
    private Calendar confirmationDate;

    public void confirmaPagamento() {
        if (!this.confirmed) {
            this.confirmed = true;
            this.confirmationDate = Calendar.getInstance();
        }
    }
}
