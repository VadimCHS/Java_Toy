package view.commands;

import view.ConsoleUI;

public class SaveFile extends Command{
    public SaveFile(ConsoleUI consoleUi) {
        super(consoleUi, "Сохранить файл.");
    }

    @Override
    public void execute() {
        super.consoleUi.saveFile();
    }
}
