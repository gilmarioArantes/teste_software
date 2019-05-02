package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DadosTesteGenerico {

    private String geraData(){

        Integer dia = ThreadLocalRandom.current().nextInt(1, 30 + 1);
        Integer mes = ThreadLocalRandom.current().nextInt(1, 12 + 1);
        Integer ano = ThreadLocalRandom.current().nextInt(2017, 2018 + 1);
        String barra = "/";
        String diaString;
        String mesString;

        List<Integer> meses30Dias = Arrays.asList(4,6,9,11);

        if(meses30Dias.contains(mes) && dia > 30){
            dia = dia--;
        }else{
            if(mes == 2 && dia > 28){
                dia = 28;
            }
        }

        if(dia < 10){
            diaString = "0" + dia.toString();
        }else{
            diaString = dia.toString();
        }

        if(mes < 10){
            mesString = "0" + mes.toString();
        }else{
            mesString = mes.toString();
        }

        return diaString + barra + mesString + barra + ano.toString();

    }

    public String GeraValor(){

        Integer valorMeta = ThreadLocalRandom.current().nextInt(1, 10000000 + 1);
        return valorMeta.toString();
    }

    public int GeraHoras()
    {
        return ThreadLocalRandom.current().nextInt(8,17);
    }

    public int GeraMinutos()
    {
        return ThreadLocalRandom.current().nextInt(0,61);
    }

    public String getGrupoMenuConfiguracoes(){
        return "Configurações";
    }

    public String getGrupoMenuCadastros(){
        return "Cadastros";
    }

    public String getGrupoMenuGovernanca(){
        return "Governança";
    }

    public String getGrupoMenuRelatorios(){
        return "Relatórios";
    }

    public String getGrupoMenuSeguranca(){
        return "Segurança";
    }

    public String getSituacaoAberto(){
        return "ABERTO";
    }

    public String getSituacaoCancelado(){
        return "CANCELADO";
    }

    public String getSituacaoConcluido(){
        return "CONCLUIDO";
    }

    public String getSituacaoEmAndamento(){
        return "EM ANDAMENTO";
    }

    public String getSituacaoResolvido(){
        return "RESOLVIDO";
    }
}
