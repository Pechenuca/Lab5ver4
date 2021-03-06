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

public class AddCommand extends Command {
    private final CommandExecutor commandExecutor;


    public AddCommand(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        setDescription("добавить новый элемент в коллекцию");
        setNeedOrg(true);
    }

    @Override
    public Answer execute(HashMap<String, Command> hashMap, Collection collection, CommandManager mySwitch, Organization organization, String... arg) throws JAXBException {
        MyLogger.info("Выполнение команды ADD");
        if (arg.length > 0) throw new ArgException();
        else {
            return commandExecutor.add(collection, organization);
        }
    }
}
