package Sindicate;

import Employee.*;
import Validar.*;

import java.util.ArrayList;

public class Sindicate 
{  
    public int sindicate_id;
    public double mensal_taxe;
    public ArrayList<Sale> taxes = new ArrayList<Sale>();

    public static void adiciona_taxa(Employee aux, int dia, double valor)
    {
        Sale nova = new Sale(dia,valor);
        aux.sindicate_data.taxes.add(nova);
    }

    public static void Taxa(Employee aux)//jogar pra sindicato
    {
        System.out.print("Indique o dia [dd]: ");
        int dia = Validar.dia_valido();

        System.out.print("Indique a taxa    : R$ ");
        double taxa = Validar.verifica_dinheiro();

        Sindicate.adiciona_taxa(aux, dia, taxa);
    }

    public static double Calculate_taxes(Employee aux)
    {
        double total = 0.0;

        for(int i = 0;i < aux.sindicate_data.taxes.size();i++)
        {
            Sale taxa = aux.sindicate_data.taxes.get(i);
            total += taxa.value;
        }

        return total + aux.sindicate_data.mensal_taxe;
    }
}
