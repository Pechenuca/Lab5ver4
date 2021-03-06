package command;



import Source.Answer;
import Source.Organization;
import mainPackage.Collection;
import mainPackage.CommandExecutor;
import mainPackage.CommandManager;
import mainPackage.MyLogger;

import java.util.HashMap;

public class ExitCommand extends Command {
        private final CommandExecutor commandExecutor;

        public ExitCommand(CommandExecutor commandExecutor){
            this.commandExecutor = commandExecutor;
            setDescription("завершить программу (без сохранения в файл)");
        }

        @Override
        public Answer execute(HashMap<String, Command> commandMap, Collection collection, CommandManager commandManager,
                              Organization organization, String... arg) {
            MyLogger.info("Выполнение команды EXIT");
            return commandExecutor.exit();
        }
    }


