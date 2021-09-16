package Functions;

import Employee.*;
import UndoRedo.*;
import Main.*;
import Menu.*;
import Validar.*;


import java.util.Locale;
import java.util.Scanner;

public class RemoveFunction implements FuncoesInterface
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
        Validar.listsalaried(Menu.listofsalaried);

        System.out.print("ID do empregado: ");
        int id = Validar.int_valido();
        
        int index_hourly = Validar.search_hourly(id, 1);
        if(index_hourly != -1)
        {
            Hourly aux = Menu.listofhourly.get(index_hourly);
            Menu.listofhourly.remove(index_hourly);

            System.out.println("Usuario Removido: " + aux.getNome() + " ID: " + aux.getId());
            System.out.println("Pressione ENTER para voltar ao menu\n");
            input.nextLine();

            Main.clear();

            new_action.UndoRedo_hourly(aux,3);
            Menu.actions.add(new_action);
            Menu.current_action++;

            return;
        }

        int index_salaried = Validar.search_salaried(id, 1);
        if(index_salaried != -1)
        {
            Salaried aux1 = Menu.listofsalaried.get(index_salaried);
            Menu.listofsalaried.remove(index_salaried);

            System.out.println("Usuario Removido: " + aux1.getNome() + " ID: " + aux1.getId());
            System.out.println("Pressione ENTER para voltar ao menu\n");
            input.nextLine();

            Main.clear();

            new_action.UndoRedo_salaried(aux1,4);
            Menu.actions.add(new_action);
            Menu.current_action++;

            return;
        }
    
        System.out.println("ID não encontrada!"); 
        System.out.print("Pressione ENTER para voltar ao menu\n");
        input.nextLine();
        
        Main.clear();
    }    
}
