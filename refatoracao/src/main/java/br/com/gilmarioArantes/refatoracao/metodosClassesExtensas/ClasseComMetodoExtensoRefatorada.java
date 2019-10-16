package br.com.gilmarioArantes.refatoracao.metodosClassesExtensas;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ClasseComMetodoExtensoRefatorada {
    
    public int calcularReceitasTotais() {

        int valorTotal=0;
        mostrarCabecalho();
        valorTotal=contabilizarReceitaAlugueis(valorTotal);
        valorTotal=contabilizarReceitaComissoes(valorTotal);
        valorTotal=contabilizarReceitaVendas(valorTotal);
        mostrarTotal(valorTotal);
        mostrarRodape();
        return valorTotal;

    }

    private int contabilizarReceitaAlugueis(int valorTotal){
        int valor=Conta.getReceitaAlugueis();
        GregorianCalendar glAgora=new GregorianCalendar();
        SimpleDateFormat formatador=new SimpleDateFormat("dd/MM/yyyy hh:mm");
        System.out.println(formatador.format(glAgora.getTime())+
                " Valor da Receita de Aluguéis: R$ "+valor+"\n");
        System.out.println(formatador.format(glAgora.getTime())+
                " Valor do subtotal R$ "+valorTotal+"\n\n");
        return valorTotal+valor;
    }

    private int contabilizarReceitaVendas(int valorTotal){
        int valor = Conta.getReceitaVendas();
        GregorianCalendar glAgora = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        System.out.println(formatador.format(glAgora.getTime()) +
                " Valor da Receita de Vendas: R$ " + valor + "\n");
        valorTotal = valorTotal + valor;
        System.out.println(formatador.format(glAgora.getTime()) +
                " Valor do subtotal R$ " + valorTotal + "\n\n");
        return valorTotal + valor;
    }

    private int contabilizarReceitaComissoes(int valorTotal){
        int valor=Conta.getReceitaComissoes();
        GregorianCalendar glAgora=new GregorianCalendar();
        SimpleDateFormat formatador=new SimpleDateFormat("dd/MM/yyyy hh:mm");
        System.out.println(formatador.format(glAgora.getTime())+
                " Valor da Receita de Comissões: R$ "+valor+"\n");
        valorTotal=valorTotal+valor;
        System.out.println(formatador.format(glAgora.getTime())+
                " Valor do subtotal R$ "+valorTotal+"\n\n");
        return valorTotal+valor;
    }

    private void mostrarCabecalho(){
        System.out.println("-------------------------------------");
        System.out.println("----- Cálculo de Receitas Totais ----");
        System.out.println("--------------------------------------\n\n");
    }

    private void mostrarRodape(){
        System.out.println("-------------------------------------");
        System.out.println("- Fim do Cálculo de Receitas Totais -");
        System.out.println("-------------------------------------");
    }

    private void mostrarTotal(int valorTotal){
        System.out.println("-------------------------------------");
        System.out.println("--- Valor Total R$ "+valorTotal+ " ---");
        System.out.println("-------------------------------------");
    }
}

