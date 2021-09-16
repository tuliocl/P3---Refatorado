package Functions;

import Menu.*;

public class CreateScheduleFunction implements FuncoesInterface
{
    @Override
    public void command()
    {
        Menu.listofschedule.CriarNovaAgenda();
    }
}
