package view.commands;

import view.ConsoleUI;

public class IssueToy extends Command{
    public IssueToy(ConsoleUI consoleUi) {
        super(consoleUi, "Выдать игрушку.");
    }

    @Override
    public void execute() {
        super.consoleUi.issueToy();
    }
}
