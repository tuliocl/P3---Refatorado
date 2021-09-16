package UndoRedo;

import Employee.*;

import java.util.Scanner;
import java.util.ArrayList;

public class UndoRedoFunctions 
{    
    public static Scanner input = new Scanner(System.in);

    public static void undo_remove_current_hourly(Hourly toremove, ArrayList<Hourly> list)//remove
    {
        for(int i = 0;i < list.size();i++)
        {
            Hourly aux = list.get(i);
            if(toremove.id == aux.id)
            {
                list.remove(i);
            }
        }
    }

    public static void undo_remove_current_salaried(Salaried toremove, ArrayList<Salaried> list)
    {
        for(int i = 0;i < list.size();i++)
        {
            Salaried aux = list.get(i);
            if(toremove.id == aux.id)
            {
                list.remove(i);
            }
        }
    }

    public static void undo_add_previous_hourly(Hourly toadd, ArrayList<Hourly> list)
    {
        list.add(toadd);
    }

    public static void undo_add_previous_salaried(Salaried toadd, ArrayList<Salaried> list)
    {
        list.add(toadd);
    }

    public static void undo_remove_salaried_using_id(int id, ArrayList<Salaried> list)
    {
        for(int i = 0;i < list.size();i++)
        {
            Salaried aux = list.get(i);
            if(id == aux.id)
            {
                list.remove(i);
            }
        }
    }

    public static void undo_remove_hourly_using_id(int id, ArrayList<Hourly> list)
    {
        for(int i = 0;i < list.size();i++)
        {
            Hourly aux = list.get(i);
            if(id == aux.id)
            {
                list.remove(i);
            }
        }
    }
}