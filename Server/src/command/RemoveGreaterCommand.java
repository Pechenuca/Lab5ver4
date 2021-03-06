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

public class RemoveGreaterCommand extends Command{
    private final CommandExecutor commandExecutor;

    public RemoveGreaterCommand(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        setDescription("удалить из коллекции все элементы, превышающие заданный");
        setNeedOrg(true);
    }

    @Override
    public Answer execute(HashMap<String, Command> commandMap, Collection collection, CommandManager commandManager,
                          Organization organization, String... arg) throws JAXBException {
        MyLogger.info("Выполнение команды REMOVEGREATER");
        if (arg.length > 0) throw new ArgException();
        else {
            return commandExecutor.removeGreater(collection, organization);
        }
    }
}
