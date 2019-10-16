package br.com.gilmarioArantes.refatoracao.extrairMetodo;

import br.com.gilmarioArantes.refatoracao.extrairClasse.Payment;
import br.com.gilmarioArantes.refatoracao.extrairClasse.PaymentDAO;

public class PaymentTesteRefatorada {

    PaymentDAO paymentDAO;

    public void savePayment(Double value) {
        paymentDAO.save(createPayment(value));
    }

    public Payment createPayment(Double value) {
        Payment payment = new Payment();
        payment.setValue(value);
        return payment;
    }
}
