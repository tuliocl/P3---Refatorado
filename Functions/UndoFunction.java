package Functions;

import UndoRedo.*;
import Main.*;
import Menu.*;

import java.util.Locale;
import java.util.Scanner;

public class UndoFunction implements FuncoesInterface
{
    public static Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH);

    @Override
    public void command()
    {
        Main.clear();
        if(Menu.current_action == 0)
        {
            System.out.println("Nenhuma ação feita");
            input.nextLine();
        }
        else
        {
            UndoRedo action = Menu.actions.get(Menu.current_action - 1);
            Undo.operation(action,Menu.listofhourly,Menu.listofsalaried);

            Menu.current_action -= 1;
            System.out.println(Menu.current_action);
        }
    }
}
