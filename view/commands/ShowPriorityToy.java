package view.commands;

import view.ConsoleUI;

public class ShowPriorityToy extends Command{
    public ShowPriorityToy(ConsoleUI consoleUi) {
        super(consoleUi, "Показать очередь выдачи игрушек.");
    }

    @Override
    public void execute() {
        super.consoleUi.showPriorityToy();
    }
}
