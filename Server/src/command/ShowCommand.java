package command;



import Source.Answer;
import Source.Organization;
import exception.ArgException;
import mainPackage.Collection;
import mainPackage.CommandExecutor;
import mainPackage.CommandManager;
import mainPackage.MyLogger;

import java.util.HashMap;

public class ShowCommand extends Command {
    private final CommandExecutor commandExecutor;

    public ShowCommand(CommandExecutor commandExecutor){
        this.commandExecutor = commandExecutor;
        setDescription("вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    @Override
    public Answer execute(HashMap<String, Command> commandMap, Collection collection, CommandManager commandManager,
                          Organization organization, String... arg) {
        MyLogger.info("Выполнение команды SHOW");
        if (arg.length > 0) {

            throw new ArgException();
        }
        else {
            return commandExecutor.show(collection);
        }
    }
}