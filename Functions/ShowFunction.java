package Functions;

import Employee.*;
import Main.*;
import Menu.*;

import java.util.Locale;
import java.util.Scanner;

public class ShowFunction implements FuncoesInterface 
{    
    public static Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH);
    @Override
    public void command()
    {
        Main.clear();   

        System.out.println("HORISTAS:\n");
        for(int i = 0;i < Menu.listofhourly.size();i++)
        {
            Hourly aux = Menu.listofhourly.get(i);
          
            Hourly.print(aux);
            System.out.println();
            
            if(i + 1 == Menu.listofhourly.size())
            {
                System.out.println();
            }
       }

        System.out.printf("==================\n");

        System.out.println("ASSALARIADOS:\n");
        for(int i = 0;i < Menu.listofsalaried.size();i++)
        {
            Salaried aux = Menu.listofsalaried.get(i);
            
            Salaried.print(aux);
            System.out.println();
           
            if(i + 1 == Menu.listofsalaried.size())
            {
                System.out.println();
            }
        }
        
        System.out.println("Pressione ENTER para voltar ao menu\n");
        input.nextLine();
        Main.clear(); 
    }
}
