package Conto_Corrente_v2;

public class Conto_corrente {

    private double tot_conto;

    public Conto_corrente(){
        tot_conto = 1000;
    }

    public  double  movimento (double importo , boolean comand){
        if ((importo > tot_conto) && (comand == true) ){
            importo = tot_conto;
            System.out.println("ciao");
        }

        if(comand == true){
            tot_conto = tot_conto - importo;
        }
        if(comand == false){
            tot_conto = tot_conto + importo;
        }

        return tot_conto;
    }
}

