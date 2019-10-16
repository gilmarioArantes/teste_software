package br.com.gilmarioArantes.refatoracao.extrairMetodo;

import br.com.gilmarioArantes.refatoracao.extrairClasse.Payment;
import br.com.gilmarioArantes.refatoracao.extrairClasse.PaymentDAO;

public class PaymentTeste {
    public void savePayment(Double value, PaymentDAO paymentDAO) {
        Payment payment = new Payment();
        payment.setValue(value);
        paymentDAO.save(payment);
    }
}
