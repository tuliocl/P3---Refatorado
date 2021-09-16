package Functions;

import java.util.Locale;
import java.util.Scanner;

import Employee.*;
import UndoRedo.*;
import Main.*;
import Menu.*;
import Validar.*;


public class AddTimeCardFunction implements FuncoesInterface
{
    public static Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH);
    @Override
    public void command()
    {
        UndoRedo new_action = new UndoRedo();
        UndoRedo.verify(Menu.actions,Menu.current_action);

        Main.clear();
        System.out.println("Lista de empregados: ");
        Validar.listhourly(Menu.listofhourly);

        System.out.print("Digite a ID do horista: ");
        int id = Validar.int_valido();

        Hourly aux;
        int index = Validar.search_hourly(id, 1);

        if(index != -1)
        {
            aux = Menu.listofhourly.get(index);

            new_action.UndoRedo_hourly(aux,5);
            Menu.actions.add(new_action);
            Menu.current_action++;

            Hourly.add_Timecard(aux);

            new_action.setAtt_hourly(aux);
        }

        else
        {
            System.out.println("ID nao encontrada");
            System.out.println("Pressione ENTER para voltar ao menu\n");
            input.nextLine();
            Main.clear(); 
        }
    }    
}
