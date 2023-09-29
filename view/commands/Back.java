package view.commands;

import view.ConsoleUI;

public class Back extends Command{

    public Back(ConsoleUI consoleUi) {
        super(consoleUi, "Выйти.");
    }
    
    @Override
    public void execute() {
        super.consoleUi.back();
    }
}
