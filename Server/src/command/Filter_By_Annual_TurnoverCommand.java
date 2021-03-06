package command;


import Source.Answer;
import Source.Organization;
import exception.ArgException;
import mainPackage.Collection;
import mainPackage.CommandExecutor;
import mainPackage.CommandManager;
import mainPackage.MyLogger;

import java.util.HashMap;

public class Filter_By_Annual_TurnoverCommand extends Command{
    private final CommandExecutor commandExecutor;

    public Filter_By_Annual_TurnoverCommand(CommandExecutor commandExecutor) {
        setDescription("вывести элементы, значение поля annual turnover которых содержит заданную подстроку");
        setArgs(" annual turnover");
        this.commandExecutor = commandExecutor;
    }

    @Override
    public Answer execute(HashMap<String, Command> commandMap, Collection collection, CommandManager commandManager,
                          Organization organization, String... arg) {
        MyLogger.info("Выполнение команды FILTER");
        if (arg.length != 1) {
            MyLogger.error("Беды с выполнением");
            throw new ArgException();

        }
        else {
           return commandExecutor.filterTurnover(collection, arg[0]);
        }
    }
}
