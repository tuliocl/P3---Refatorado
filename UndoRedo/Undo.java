package UndoRedo;

import Employee.*;
import Main.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Undo 
{
    public static Scanner input = new Scanner(System.in);

    public static void operation(UndoRedo action,ArrayList<Hourly> listofhourly, ArrayList<Salaried> listofsalaried)
    {
        if(action.operation == 1)
        {
           UndoRedoFunctions.undo_remove_current_hourly(action.hourly,listofhourly);
           System.out.println("Operação (ADD HORISTA) desfeita\nENTER para voltar");
        }

        else if(action.operation == 2)
        {
            UndoRedoFunctions.undo_remove_current_salaried(action.salaried,listofsalaried);
            System.out.println("Operação (ADD SALARIADO) desfeita\nENTER para voltar");
        }
        
        else if(action.operation == 3)
        {
            UndoRedoFunctions.undo_add_previous_hourly(action.hourly,listofhourly);
            System.out.println("Operação (REMOVE HORISTA) desfeita\nENTER para voltar");
        }

        else if(action.operation == 4)
        {
            UndoRedoFunctions.undo_add_previous_salaried(action.salaried,listofsalaried);
            System.out.println("Operação (REMOVE SALARIADO) desfeita\nENTER para voltar");
        }

        else if(action.operation == 5)
        {
            UndoRedoFunctions.undo_remove_current_hourly(action.hourly,listofhourly);
            UndoRedoFunctions.undo_add_previous_hourly(action.hourly,listofhourly);
            System.out.println("Operação (ADD Cartão de ponto) desfeita\nENTER para voltar");
        }

        else if(action.operation == 6)
        {
            UndoRedoFunctions.undo_remove_current_salaried(action.salaried, listofsalaried);
            UndoRedoFunctions.undo_add_previous_salaried(action.salaried, listofsalaried);
            System.out.println("Operação (ADD Venda) desfeita\nENTER para voltar");
        }
        
        else if(action.operation == 7)
        {
            UndoRedoFunctions.undo_remove_current_hourly(action.hourly,listofhourly);
            UndoRedoFunctions.undo_add_previous_hourly(action.hourly,listofhourly);
            System.out.println("Operação (ADD Taxa) desfeita\nENTER para voltar");
        }

        else if(action.operation == 8)
        {
            UndoRedoFunctions.undo_remove_current_salaried(action.salaried, listofsalaried);
            UndoRedoFunctions.undo_add_previous_salaried(action.salaried, listofsalaried);
            System.out.println("Operação (ADD Taxa) desfeita\nENTER para voltar");
        }

        else if(action.operation == 9)
        {
            UndoRedoFunctions.undo_remove_current_hourly(action.hourly,listofhourly);
            UndoRedoFunctions.undo_add_previous_hourly(action.hourly,listofhourly);
            System.out.println("Operação (Alterar dados) desfeita\nENTER para voltar");
        }

        else if(action.operation == 10)
        {
            UndoRedoFunctions.undo_remove_current_salaried(action.salaried, listofsalaried);
            UndoRedoFunctions.undo_add_previous_salaried(action.salaried, listofsalaried);
            System.out.println("Operação (Alterar dados) desfeita\nENTER para voltar");
        }

        else if(action.operation == 11)
        {
            int id = action.hourly.id;
            UndoRedoFunctions.undo_remove_salaried_using_id(id,listofsalaried);
            UndoRedoFunctions.undo_add_previous_hourly(action.hourly, listofhourly);
            System.out.println("Operação (Alterar dados) desfeita\nENTER para voltar");
        }

        else if(action.operation == 12)
        {
            int id = action.salaried.id;
            UndoRedoFunctions.undo_remove_hourly_using_id(id,listofhourly);
            UndoRedoFunctions.undo_add_previous_salaried(action.salaried, listofsalaried);
            System.out.println("Operação (Alterar dados) desfeita\nENTER para voltar");
        }

        input.nextLine();
        Main.clear();
    }    
}
