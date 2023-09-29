package view.commands;

import view.ConsoleUI;

public class Play extends Command{

    public Play(ConsoleUI consoleUi) {
        super(consoleUi, "Провести розыгрыш.");
    }

    @Override
    public void execute() {
        super.consoleUi.play();
    }
}
