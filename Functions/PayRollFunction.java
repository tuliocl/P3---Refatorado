package Functions;

import Menu.*;
import PayRoll.*;

public class PayRollFunction implements FuncoesInterface
{
    @Override
    public void command()
    {
        PayRoll.Pagamento(Menu.listofschedule, Menu.listofhourly, Menu.listofsalaried);
    }
}
