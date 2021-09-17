package Menu;

import Main.*;
import Employee.*;
import Functions.*;
import UndoRedo.*;
import Schedule.*;
import Validar.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Menu 
{
    Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH);//variavel de entrada

    public static int id = 1;
    public static int id_sindicato = 1;

    public static ArrayList<Hourly> listofhourly = new ArrayList<Hourly>();//lista de funcionarios - Horista
    public static ArrayList<Salaried> listofsalaried = new ArrayList<Salaried>();//lista de funcionarios - assalariado
    public static PaymentSchedule listofschedule = new PaymentSchedule();

    public static ArrayList<UndoRedo> actions = new ArrayList<UndoRedo>();//TRANSFERIR - undoredo
    public static int current_action = 0;

    public static void Main(String[] args)
    {
        Start();
    }

    public static void Start()
    {
        FunctionsHandler functionshandler = new FunctionsHandler();
        FuncoesInterface var;

        System.out.println("Bem vindo ao sistema!!!");
        while(true)
        {
            System.out.println("Por favor, escolha uma das seguintes opções:");

            int choice = Choice();

            if(choice == 12)
            {
                System.out.println("Finalizando o sistema...");

            }

            var = functionshandler.handler(choice);
            var.command();
        }
    }

    private static int Choice()
    {
        System.out.println("OBS: Digite o código da sua ação\n");
        System.out.println("Adicionar novo funcionário [1]");
        System.out.println("Remover Funcionarios       [2]");
        System.out.println("Listar Funcionarios        [3]");
        System.out.println("Lançar Cartão de ponto     [4]");
        System.out.println("Lançar Venda               [5]");
        System.out.println("Lançar Taxa de Serviço     [6]");
        System.out.println("Alterar Dados do empregado [7]");
        System.out.println("Criar agenda de pagamento  [8]");
        System.out.println("Folha de pagamento         [9]");
        System.out.println("Undo                       [10]");
        System.out.println("Redo                       [11]");
        System.out.println("Sair do sistema            [12]");

        while(true)
        {
            System.out.print("Digite o código: ");
            int code = Validar.int_valido();

            if(code >= 1 && code <= 12)
            {
                return code;
            }

            else
            {
                Main.clear();
                System.out.print("Opcão invalida, digite novamente: ");
            }
        }
    }
}