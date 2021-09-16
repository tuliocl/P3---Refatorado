package Schedule;

import Main.*;
import Validar.*;

public class WeeklySchedule implements ScheduleInterface
{
    @Override
    public String execute()
    {
        String nova = "Semanal";
        int aux;
        
        System.out.print("Indique a cada quantas semanas ocorre o pagamento: ");
        while(true)
        {
            aux = Validar.int_valido();

            if(aux >= 1 && aux <= 4)
            {   
                String str = Integer.toString(aux);
                nova += " ";
                nova += str;
                nova += " ";
                System.out.println(nova);    
                Main.clear();
                break;
            }

            System.out.println("Número de semanas ínvalido");
        }

        System.out.print("Segunda[1]\nTerça[2]\nQuarta[3]\nQuinta[4]\nSexta[5]\n");//escolhe o dia da semana
        System.out.print("Indique o dia da semana do pagamento: ");
        
        while(true)
        {
            aux = Validar.int_valido();

            if(aux >= 1 && aux <= 5)
            {   
                if(aux == 1)
                {
                    nova += "MONDAY";
                }

                else if(aux == 2)
                {
                    nova += "TUESDAY";
                }
                else if(aux == 3)
                {
                    nova += "WEDNESDAY";
                }
                else if(aux == 4)
                {
                    nova += "THURSDAY";
                }
                else if(aux == 5)
                {
                    nova += "FRIDAY";
                }
                System.out.println(nova);    
                break;
            }

            System.out.println("Opção ínvalida\n");
        }
        
        Main.clear();
        return nova;

    }
}
