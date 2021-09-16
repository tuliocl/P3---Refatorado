package Functions;

import UndoRedo.*;
import Main.*;
import Menu.*;

import java.util.Locale;
import java.util.Scanner;

public class RedoFunction implements FuncoesInterface
{
    public static Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH);

    @Override
    public void command()
    {
        Main.clear();

        if(Menu.current_action == Menu.actions.size())
        {
            System.out.println("Nenhuma ação para refazer");
            input.nextLine();
        }

        else
        {
            UndoRedo action = Menu.actions.get(Menu.current_action);
            Redo.execute(action, Menu.listofhourly, Menu.listofsalaried);
            Menu.current_action++;
        }
    }
}
