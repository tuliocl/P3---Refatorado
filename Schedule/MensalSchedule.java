package Schedule;

import Main.*;
import Validar.*;

public class MensalSchedule implements ScheduleInterface
{
    @Override
    public String execute()
    {
        Main.clear();
        String nova = "Mensal";

        int aux;
        System.out.print("Digite [1] se deseja que o pagamento ocorra no ultimo dia útil\n");
        System.out.print("Digite [0] para escolher outro dia\n");
        System.out.print("DIGITE: ");
        aux = Validar.int_valido();

        Main.clear();
        if(aux == 1)
        {
            nova += " $";
        }

        else
        {
            System.out.print("Indique o dia do pagamento: ");
            aux = Validar.dia_valido();
            String str = Integer.toString(aux);
            nova += " ";
            nova += str;
            nova += " "; 
        }

        Main.clear();
        return nova;
    }
}
