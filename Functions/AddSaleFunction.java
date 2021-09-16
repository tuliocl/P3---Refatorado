package Functions;

import Employee.*;
import UndoRedo.*;
import Main.*;
import Menu.*;
import Validar.*;


import java.util.Locale;
import java.util.Scanner;

public class AddSaleFunction implements FuncoesInterface
{
    public static Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH);
    
    @Override
    public void command()
    {
        UndoRedo new_action = new UndoRedo();
        UndoRedo.verify(Menu.actions,Menu.current_action);
    
        Main.clear();
        System.out.println("Lista de empregados: ");
        Validar.listsalaried(Menu.listofsalaried);

        System.out.print("Digite a ID do assalariado: ");
        int id = Validar.int_valido();

        Salaried aux;
        int index = Validar.search_salaried(id, 1);
        
        if(index != -1)
        {
            aux = Menu.listofsalaried.get(index);

            new_action.UndoRedo_salaried(aux,6);
            Menu.actions.add(new_action);
            Menu.current_action++;

            Boolean adicionou =  Salaried.add_sale(aux);
            if(adicionou == false)
            {
                Menu.actions.remove(new_action);
                Menu.current_action--;
            }
            else
            {
                new_action.setAtt_salaried(aux);
            }
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
