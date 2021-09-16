package Employee;

import Main.*;
import Sindicate.*;
import Validar.*;
import Menu.*;

public class Employee 
{
    public int type;
    public int id;

    public String name;
    String city;

    public int schedule;
    public int payment_method;
    public double salary;

    public boolean sindicate;
    public Sindicate sindicate_data = new Sindicate();

    public static void main_info(Employee aux)
    {
        System.out.printf("NOME              : %s\n",aux.name);
        System.out.printf("CIDADE            : %s\n",aux.city);

        System.out.printf("PAGAMENTO         : R$ %.2f\n",aux.salary);

        if(aux.sindicate)
        {
            System.out.printf("TAXA SINDICAL     : R$ %.2f\n",aux.sindicate_data.mensal_taxe);
            System.out.printf("ID SINDICATO      : %d\n",aux.sindicate_data.sindicate_id);
            System.out.printf("TAXAS\n");

            for(int i = 0;i < aux.sindicate_data.taxes.size();i++)
            {
                Sale nova = aux.sindicate_data.taxes.get(i);
                System.out.printf("DIA %d: %.2f\n",nova.day,nova.value);
            }
        }

        System.out.printf("ID                : %d\n",aux.id);
    }

    public static void copy(Employee novo, Employee mudar)
    {
        novo.id = mudar.id;
        novo.name = mudar.name;
        novo.city = mudar.city;
        novo.payment_method = mudar.payment_method;
        novo.schedule = mudar.schedule;
       
        System.out.print("Indique o salario: R$ ");
        novo.salary = Validar.verifica_dinheiro();
       
        novo.sindicate = mudar.sindicate;
        
        if(novo.sindicate)
        {
            novo.sindicate_data.sindicate_id = mudar.sindicate_data.sindicate_id;
            novo.sindicate_data.mensal_taxe = mudar.sindicate_data.mensal_taxe;

            for(int i = 0;i < mudar.sindicate_data.taxes.size(); i++) // passa as taxas
            {
                Sale nova = mudar.sindicate_data.taxes.get(i);
                novo.sindicate_data.taxes.add(nova);
            }
        }
    }

    public static void change_name(Employee aux)
    {
        System.out.print("Digite o novo nome: ");
        String novo = Validar.string_valida();

        aux.name = novo;
    }

    public static void change_city(Employee aux)
    {
        System.out.print("Digite a nova cidade: ");
        String novo = Validar.string_valida();

        aux.city = novo;
    }

    public static void change_paymentmethod(Employee aux)
    {
        int novo;
        while(true)
        {
            System.out.print("Digite o Metodo de pagamento\n");
            System.out.print("Cheque correio[1] Cheque-Mãos[2] Deposito[3]: ");
            novo = Validar.int_valido();

            if(novo >= 1 && novo <= 3)
            {
                aux.payment_method = novo;
                break;
            }

        }

        Main.clear();
    }

    public static void change_sindicatemember(Employee aux)
    {
        System.out.print("Pertence ao sindicato? Sim[1] Não[2]");
        boolean novo = Validar.verifica_boolean();

        aux.sindicate = novo;
    }

    public static void change_sindicateid(Employee aux)
    {
        System.out.print("Digite a nova ID do sindicato: ");
        int novo = Validar.int_valido();

        aux.sindicate_data.sindicate_id = novo;
    }

    public static void change_sindicatetax(Employee aux)
    {
        System.out.print("Digite a nova taxa do sindicato: R$ ");
        double novo = Validar.verifica_dinheiro();

        aux.sindicate_data.mensal_taxe = novo;
    }
    public static void change_schedule(Employee aux)
    {
        int tipo;

        while(true)
        {
            System.out.print("Digite a agenda de pagamento\n");
            Menu.listofschedule.print();
            tipo = Validar.int_valido();

            if(tipo >= 0 && tipo < Menu.listofschedule.methods.size())
            {
                if(tipo != aux.schedule)
                {
                    aux.schedule = tipo;
                    return;
                }

                Main.clear();
            }
        }
    }
} 