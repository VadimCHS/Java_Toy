package view.commands;

import view.ConsoleUI;

public abstract class Command {
    private String description;
    protected ConsoleUI consoleUi;

    public Command(ConsoleUI consoleUi, String description) {
        this.consoleUi = consoleUi;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
