package Functions;

import java.util.ArrayList;

public class FunctionsHandler 
{
    ArrayList<FuncoesInterface> functions = new ArrayList<FuncoesInterface>();
    FuncoesInterface var;
   
    public FunctionsHandler()
    {
        var = new AddFunction();
        this.functions.add(var);

        var = new RemoveFunction();
        this.functions.add(var);

        var = new ShowFunction();
        this.functions.add(var);

        var = new AddTimeCardFunction();
        this.functions.add(var);

        var = new AddSaleFunction();
        this.functions.add(var);

        var = new AddTaxFunction();
        this.functions.add(var);

        var = new ChangeDataFunction();
        this.functions.add(var);

        var = new CreateScheduleFunction();
        this.functions.add(var);

        var = new PayRollFunction();
        this.functions.add(var);

        var = new UndoFunction();
        this.functions.add(var);

        var = new RedoFunction();
        this.functions.add(var);
    }

    public FuncoesInterface handler(int input)
    {
        return functions.get(input - 1);
    }
}
