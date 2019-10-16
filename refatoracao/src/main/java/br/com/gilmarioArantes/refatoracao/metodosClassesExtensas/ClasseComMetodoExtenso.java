package br.com.gilmarioArantes.refatoracao.metodosClassesExtensas;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ClasseComMetodoExtenso {

    public int calcularReceitasTotais() {
        int valorTotal = 0;
        System.out.println("-------------------------------------");
        System.out.println("----- Cálculo de Receitas Totais ----");
        System.out.println("--------------------------------------\n\n");
        int valor = Conta.getReceitaAlugueis();
        GregorianCalendar glAgora = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        System.out.println(formatador.format(glAgora.getTime()) +
                " Valor da Receita de Aluguéis: R$ " + valor + "\n");
        valorTotal = valorTotal + valor;

        System.out.println(formatador.format(glAgora.getTime()) +
                " Valor do subtotal R$ " + valorTotal + "\n\n");
        glAgora = new GregorianCalendar();
        valor = Conta.getReceitaVendas();
        System.out.println(formatador.format(glAgora.getTime()) +
                " Valor da Receita de Vendas: R$ " + valor + "\n");
        valorTotal = valorTotal + valor;
        System.out.println(formatador.format(glAgora.getTime()) +
                " Valor do subtotal R$ " + valorTotal + "\n\n");
        glAgora = new GregorianCalendar();
        valor = Conta.getReceitaComissoes();
        System.out.println(formatador.format(glAgora.getTime()) +
                " Valor da Receita de Comissões: R$ " + valor + "\n");
        valorTotal = valorTotal + valor;
        System.out.println(formatador.format(glAgora.getTime()) +
                " Valor do subtotal R$ " + valorTotal + "\n\n");
        System.out.println("---- ---- ---- ---- ---- ---- ----");
        glAgora = new GregorianCalendar();
        System.out.println(formatador.format(glAgora.getTime()) +
                " Valor do Total R$ " + valorTotal);
        System.out.println("---- ---- ---- ---- ---- ---- ----\n\n");
        System.out.println("-------------------------------------");
        System.out.println("- Fim do Cálculo de Receitas Totais -");
        System.out.println("-------------------------------------");
        return valorTotal;
    }
}
