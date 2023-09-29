package view.commands;

import view.ConsoleUI;

public class ShowListToy extends Command{
    public ShowListToy(ConsoleUI consoleUi) {
        super(consoleUi, "Показать очередь список игрушек.");
    }

    @Override
    public void execute() {
        super.consoleUi.showListToy();
    }
}
