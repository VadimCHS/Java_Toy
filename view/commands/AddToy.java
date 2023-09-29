package view.commands;

import view.ConsoleUI;

public class AddToy extends Command{

    public AddToy(ConsoleUI consoleUi) {
        super(consoleUi, "Добавить игрушку в список для розыгрыша.");
    }

    @Override
    public void execute() {
        super.consoleUi.addToy();
    }

}
