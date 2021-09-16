package UndoRedo;

import Employee.*;
import Main.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Redo 
{

    public static Scanner input = new Scanner(System.in);

    public static void execute(UndoRedo action,ArrayList<Hourly> listofhourly, ArrayList<Salaried> listofsalaried)
    {
        if(action.operation == 1)
        {
            UndoRedoFunctions.undo_add_previous_hourly(action.hourly, listofhourly);
            System.out.println("Operação (ADD HORISTA) refeita\nENTER para voltar");
        }

        else if(action.operation == 2)
        {
            UndoRedoFunctions.undo_add_previous_salaried(action.salaried, listofsalaried);
            System.out.println("Operação (ADD SALARIADO) refeita\nENTER para voltar");
        }
        
        else if(action.operation == 3)
        {
            UndoRedoFunctions.undo_remove_current_hourly(action.hourly, listofhourly);
            System.out.println("Operação (REMOVE HORISTA) refeita\nENTER para voltar");
        }

        else if(action.operation == 4)
        {
            UndoRedoFunctions.undo_remove_current_salaried(action.salaried,listofsalaried);
            System.out.println("Operação (REMOVE SALARIADO) refeita\nENTER para voltar");
        }

        else if(action.operation == 5)
        {
            UndoRedoFunctions.undo_remove_current_hourly(action.hourly, listofhourly);
            UndoRedoFunctions.undo_add_previous_hourly(action.att_hourly, listofhourly);
            System.out.println("Operação (ADD Cartão de ponto) refeita\nENTER para voltar");
        }

        else if(action.operation == 6)
        {
            UndoRedoFunctions.undo_remove_current_salaried(action.salaried, listofsalaried);
            UndoRedoFunctions.undo_add_previous_salaried(action.att_salaried, listofsalaried);
            System.out.println("Operação (ADD Venda) refeita\nENTER para voltar");
        }
        
        else if(action.operation == 7)
        {
            UndoRedoFunctions.undo_remove_current_hourly(action.hourly, listofhourly);
            UndoRedoFunctions.undo_add_previous_hourly(action.att_hourly, listofhourly);
            System.out.println("Operação (ADD Taxa) refeita\nENTER para voltar");
        }

        else if(action.operation == 8)
        {
            UndoRedoFunctions.undo_remove_current_salaried(action.salaried, listofsalaried);
            UndoRedoFunctions.undo_add_previous_salaried(action.att_salaried, listofsalaried);
            System.out.println("Operação (ADD Taxa) refeita\nENTER para voltar");
        }

        else if(action.operation == 9)
        {
            UndoRedoFunctions.undo_remove_current_hourly(action.hourly, listofhourly);
            UndoRedoFunctions.undo_add_previous_hourly(action.att_hourly, listofhourly);
            System.out.println("Operação (Alterar dados) refeita\nENTER para voltar");
        }

        else if(action.operation == 10)
        {
            UndoRedoFunctions.undo_remove_current_salaried(action.salaried, listofsalaried);
            UndoRedoFunctions.undo_add_previous_salaried(action.att_salaried, listofsalaried);
            System.out.println("Operação (Alterar dados) refeita\nENTER para voltar");
        }

        else if(action.operation == 11)
        {
            UndoRedoFunctions.undo_remove_current_hourly(action.hourly, listofhourly);
            UndoRedoFunctions.undo_add_previous_salaried(action.att_salaried, listofsalaried);
            System.out.println("Operação (Alterar dados) refeita\nENTER para voltar");
        }

        else if(action.operation == 12)
        {
            UndoRedoFunctions.undo_remove_current_salaried(action.salaried, listofsalaried);
            UndoRedoFunctions.undo_add_previous_hourly(action.att_hourly, listofhourly);
            System.out.println("Operação (Alterar dados) refeita\nENTER para voltar");
        }

        input.nextLine();
        Main.clear();
    }
}
