package view.commands;

import view.ConsoleUI;

public class ReadFile extends Command{
    public ReadFile(ConsoleUI consoleUi) {
        super(consoleUi, "Загрузить файл.");
    }

    @Override
    public void execute() {
        super.consoleUi.readFile();
    }
}
