package command;




import Source.Answer;
import Source.Organization;
import exception.ArgException;
import mainPackage.Collection;
import mainPackage.CommandExecutor;
import mainPackage.CommandManager;
import mainPackage.MyLogger;

import javax.xml.bind.JAXBException;
import java.util.HashMap;

public class ClearCommand extends Command{
    public final CommandExecutor commandExecutor;

    public ClearCommand(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        setDescription("очистить коллекцию");
    }

    @Override
    public Answer execute(HashMap<String, Command> hashMap, Collection collection, CommandManager commandManager,
                          Organization organization, String... arg) throws JAXBException {
        MyLogger.info("Выполнение команды clear");
        if (arg.length > 0) {
            MyLogger.error("Выполнение провалено");
            throw new ArgException();
        }
        else {
           return commandExecutor.clear(collection);
        }
    }
}
