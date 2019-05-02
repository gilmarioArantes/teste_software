import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TestRandom {

    private void geraRandomRange(){
        int min = 1;
        int max = 31;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        System.out.println(randomNum);
    }

    private String geraData(){

        Integer dia = ThreadLocalRandom.current().nextInt(1, 31 + 1);
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

    public static void main(String args[]){
        TestRandom tr = new TestRandom();
        for(int i = 0; i< 10; i++) {
            System.out.println(tr.geraData());
        }
    }
}
