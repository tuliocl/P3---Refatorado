package UndoRedo;

import Employee.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UndoRedo
{   
    public static Scanner input = new Scanner(System.in);

    int operation;

    Salaried salaried = new Salaried();
    Hourly hourly = new Hourly();

    Salaried att_salaried = new Salaried(); 
    Hourly att_hourly = new Hourly();

    public static void verify(ArrayList<UndoRedo> actions, int current_action)
    {
        if(current_action < actions.size())
        {
            for(int i = current_action;i < actions.size();)
            {
                actions.remove(i);
            }
        }
    }

    public void UndoRedo_hourly(Hourly save_hourly,int operation)
    {
        this.operation = operation;
        this.hourly = Hourly.clone(save_hourly);
    }

    public void UndoRedo_salaried(Salaried save_salaried,int operation)
    {
        this.operation = operation;
        this.salaried = Salaried.clone(save_salaried);
    }

    public void setAtt_salaried(Salaried att_salaried) {
        this.att_salaried = Salaried.clone(att_salaried);
    }

    public void setAtt_hourly(Hourly att_hourly) {
        this.att_hourly = Hourly.clone(att_hourly);
    }
}