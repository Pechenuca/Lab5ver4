package command;



import Source.Answer;
import Source.Organization;
import exception.ArgException;
import mainPackage.Collection;
import mainPackage.CommandExecutor;
import mainPackage.CommandManager;
import mainPackage.MyLogger;

import java.util.HashMap;


public class Print_Descending extends Command {
    private final CommandExecutor commandExecutor;

    public Print_Descending(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        setDescription("вывести значения поля в порядке возрастания");

    }

    @Override
    public Answer execute(HashMap<String, Command> commandMap, Collection collection, CommandManager commandManager,
                          Organization organization, String... arg) {
        MyLogger.info("Выполнение команды PRINT_DESCENDING");
        if (arg.length > 0)
            throw new ArgException();
        else {
            return commandExecutor.print_descending(collection);
        }
    }
}
