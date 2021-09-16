package Functions;

import Employee.*;
import UndoRedo.*;
import Main.*;
import Menu.*;
import Validar.*;

public class AddFunction implements FuncoesInterface 
{
    @Override
    public void command()
    {
        UndoRedo new_action = new UndoRedo();
        UndoRedo.verify(Menu.actions,Menu.current_action);

        Main.clear();

        int type = Validar.tipo_funcionario();
        Main.clear();
        if(type == 1)
        {
            Hourly new_hourly = new Hourly();
            new_hourly = Hourly.add_hourly(new_hourly,Menu.id,Menu.id_sindicato);
            
            Menu.listofhourly.add(new_hourly);
            Menu.id++;

            if(new_hourly.sindicate)
            {
                Menu.id_sindicato++;
            }

            new_action.UndoRedo_hourly(new_hourly,1);
            Menu.actions.add(new_action);
            Menu.current_action++;
        }

        else if(type == 2)
        {
            Salaried new_salaried = new Salaried();
    
            new_salaried = Salaried.add_Salaried(new_salaried,Menu.id,Menu.id_sindicato);
            
            Menu.listofsalaried.add(new_salaried);
            Menu.id++;

            if(new_salaried.sindicate)
            {
                Menu.id_sindicato++;
            }

            new_action.UndoRedo_salaried(new_salaried,2);
            Menu.actions.add(new_action);
            Menu.current_action++;
        }
        
        Main.clear();     
    }
}
