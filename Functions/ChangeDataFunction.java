package Functions;

import java.util.Locale;
import java.util.Scanner;

import Employee.*;
import UndoRedo.*;
import Main.*;
import Menu.*;
import Validar.*;

public class ChangeDataFunction implements FuncoesInterface
{
    public static Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH);

    @Override
    public void command()
    {
        Main.clear();
        System.out.println("Lista de empregados: ");
        Validar.listhourly(Menu.listofhourly);
        Validar.listsalaried(Menu.listofsalaried);

        System.out.print("Indique a ID do empregado: ");
        int id = Validar.int_valido();

        int index = Validar.search_hourly(id, 1);

        if(index != -1)//achei horista
        {
            Hourly hourly = Menu.listofhourly.get(index);
            modificate_data(hourly,id,1);

            Main.clear();   
            return;
        }

        index = Validar.search_salaried(id, 1);

        if(index != -1)//achei assalarido
        {
            Salaried salaried = Menu.listofsalaried.get(index);
            modificate_data(salaried,id,2);
            
            Main.clear();  
            return;
        }

        System.out.println("ID nao encontrada");
        System.out.println("Pressione ENTER para voltar ao menu\n");
        input.nextLine();
        Main.clear();   
    }
    
    private void modificate_data(Employee mudar,int id,int tipo)//chama as funções de alteração nas classes
    {
        int choice = menu_changes();

        UndoRedo new_action = new UndoRedo();
        UndoRedo.verify(Menu.actions,Menu.current_action);
        
        if(tipo == 1)
        {
            new_action.UndoRedo_hourly((Hourly)mudar,9);
            Menu.actions.add(new_action);
            Menu.current_action++;
        }

        else if(tipo == 2)
        {
            new_action.UndoRedo_salaried((Salaried)mudar,10);
            Menu.actions.add(new_action);
            Menu.current_action++; 
        }

        if(choice == 1)
        {
            Employee.change_name(mudar);
        }

        else if(choice == 2)
        {
            Employee.change_city(mudar);
        }

        else if(choice == 3)
        {
            Employee.change_paymentmethod(mudar);
        }

        else if(choice == 4)
        {
            Employee.change_sindicatemember(mudar);
        }

        else if(choice == 5)
        {
            Employee.change_sindicateid(mudar);
        }

        else if(choice == 6)
        {
            Employee.change_sindicatetax(mudar);
        }  

        else if(choice == 7)
        {
            Employee.change_schedule(mudar);
        }  

        else if(choice == 8)
        {
            int new_type = Validar.tipo_funcionario();

            if(new_type == mudar.type)
            {
                System.out.print("O empregado já é desse tipo\n");
            }
    
            else
            {
                Menu.actions.remove(Menu.current_action - 1);
                Menu.current_action -= 1;

                if(tipo == 1)
                {
                    new_action.UndoRedo_hourly((Hourly)mudar,11);
                    Menu.actions.add(new_action);
                    Menu.current_action++;
                }

                else if(tipo == 2)
                {
                    new_action.UndoRedo_salaried((Salaried)mudar,12);
                    Menu.actions.add(new_action);
                    Menu.current_action++;
                }

                change_type(tipo,id,mudar,new_action);
            }
        }

        else
        {
            System.out.printf("Opção inválida!\n");
        }

        if(tipo == 1 && choice != 8)
        {
            new_action.setAtt_hourly((Hourly) mudar);
        }

        else if(tipo == 2 && choice != 8)
        {
            new_action.setAtt_salaried((Salaried) mudar);
        }

        System.out.println("Pressione ENTER para voltar ao menu\n");
        input.nextLine();
    }

    private int menu_changes()
    {
        int escolha;

        while(true)
        {
            System.out.print("Nome                             [1]\n");
            System.out.print("Cidade                           [2]\n");
            System.out.print("Metodo de pagamento              [3]\n");
            System.out.print("Membro do sindicato              [4]\n");
            System.out.print("ID do sindicato                  [5]\n");
            System.out.print("Taxa do sindicato                [6]\n");
            System.out.print("Alterar agenda                   [7]\n");
            System.out.print("Alterar tipo de funcionario      [8]\n");

            System.out.printf("Escolha a opção: ");
            escolha = Validar.int_valido();
            
            if(escolha >= 1 && escolha <= 8)
            {
                Main.clear();
                break;
            }

            Main.clear();
        }

        return escolha;
    }

    private void change_type(int tipo,int id,Employee mudar, UndoRedo new_action)
    {
        if(tipo == 1)//horista -> assalariado
        {
            Salaried novo = new Salaried();

            novo.type = 2;
            Employee.copy(novo,mudar);

            Menu.listofsalaried.add(novo);//adiciona na lista

            for(int i = 0;i < Menu.listofhourly.size();i++)//remove da lista
            {
                Hourly aux = Menu.listofhourly.get(i);
                if(aux.id == id)
                {
                    Menu.listofhourly.remove(i);
                    break;
                }
            }

            new_action.setAtt_salaried(novo);
        }

        else if(tipo == 2)
        {
            //copia os dados
            Hourly novo = new Hourly();

            novo.type = 1;
            Employee.copy(novo,mudar);

            Menu.listofhourly.add(novo);//adiciona na lista

            for(int i = 0;i < Menu.listofsalaried.size();i++)//remove da lista
            {
                Salaried aux = Menu.listofsalaried.get(i);
                if(aux.id == id)
                {
                    Menu.listofsalaried.remove(i);
                    break;
                }
            }

            new_action.setAtt_hourly(novo);
        }
    }
}