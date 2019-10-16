package br.com.gilmarioArantes.refatoracao.moverMetodo;

import lombok.Data;
import java.util.Calendar;

@Data
public class Usuario {
    private String name;
    private Integer id;
    private Pagamento pagamento;

    public void confirmPayment() {
        if (!pagamento.isConfirmed()) {
            pagamento.setConfirmed(true);
            pagamento.setConfirmationDate(Calendar.getInstance());
        }
    }
}
