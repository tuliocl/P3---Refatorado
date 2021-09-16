package Schedule;

import Main.*;
import Validar.*;

import java.util.ArrayList;

public class PaymentSchedule 
{
    ScheduleInterface var;
        
    public ArrayList<String> methods = new ArrayList<String>();//lista que contem todos os metodos
    
    public PaymentSchedule()//construtor com as 3 primeiras agendar
    {
        String aux = "Semanal 1 FRIDAY";
        this.methods.add(aux);

        aux = "Mensal $";
        this.methods.add(aux);

        aux = "Semanal 2 FRIDAY";
        this.methods.add(aux);
    }

    public void print()//funcao que uso pra apresentar as opcoes
    {
        for(int i = 0;i < methods.size();i++)
        {
            String aux = methods.get(i);
            String[] aux1 = aux.split(" ");

            System.out.printf("[%d] - ",i);
            System.out.printf("%s %s",aux1[0],aux1[1]);

            if(aux1[0].equals("Semanal"))
            {
                if(aux1[2].equals("MONDAY"))
                {
                    System.out.println(" Segunda");
                }
    
                if(aux1[2].equals("TUESDAY"))
                {
                    System.out.println(" Terça");
                }
    
                if(aux1[2].equals("WEDNESDAY"))
                {
                    System.out.println(" Quarta");
                }
    
                if(aux1[2].equals("THURSDAY"))
                {
                    System.out.println(" Quinta");
                }
    
                if(aux1[2].equals("FRIDAY"))
                {
                    System.out.println(" Sexta");
                }
            }

            else
            {
                System.out.println();
            }
        }
    }

    public void CriarNovaAgenda()
    {
        Main.clear();
        String nova;
        int option;

        System.out.print("Escolha a opção Semanal[1] ou Mensal[2]: ");//primeiro escolhe o tipo
     
        while(true)
        {
            option = Validar.int_valido();

            if(option == 1 || option == 2)
            {
                break;
            }

            System.out.print("Opção ínvalida\n");
        }

        if(option == 1)
        {
            var = new WeeklySchedule();
        }

        else//opcao mensal
        {
            var = new MensalSchedule();
        }    

        nova = var.execute();
        methods.add(nova);
    }
}
