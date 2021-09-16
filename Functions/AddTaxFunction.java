package Functions;

import java.util.Locale;
import java.util.Scanner;

import Employee.*;
import Sindicate.*;
import UndoRedo.*;
import Main.*;
import Menu.*;
import Validar.*;


public class AddTaxFunction implements FuncoesInterface
{    
    public static Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH);
    @Override
    public void command()
    {
        UndoRedo new_action = new UndoRedo();
        UndoRedo.verify(Menu.actions,Menu.current_action);

        Main.clear();

        Validar.listhourly_sindicate(Menu.listofhourly);
        Validar.listsalaried_sindicate(Menu.listofsalaried);

        System.out.print("Indique a ID do sindicato: ");
        int id = Validar.int_valido();

        Hourly hourly;
        Salaried salaried;

        int index = Validar.search_hourly(id, 2);

        if(index != -1)//achei horista
        {
            hourly = Menu.listofhourly.get(index);

            new_action.UndoRedo_hourly(hourly,7);
            Menu.actions.add(new_action);
            Menu.current_action++;

            Sindicate.Taxa(hourly);

            new_action.setAtt_hourly(hourly);

            Main.clear();   
            return;
        }

        index = Validar.search_salaried(id, 2);

        if(index != -1)//achei assalarido
        {
            salaried = Menu.listofsalaried.get(index);

            new_action.UndoRedo_salaried(salaried,8);
            Menu.actions.add(new_action);
            Menu.current_action++;

            Sindicate.Taxa(salaried);

            new_action.setAtt_salaried(salaried);

            Main.clear();  
            return;
        }

        System.out.println("ID nao encontrada");
        System.out.println("Pressione ENTER para voltar ao menu\n");
        input.nextLine();
        Main.clear();   
    }    
}
