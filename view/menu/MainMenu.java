package view.menu;

import java.util.ArrayList;
import java.util.List;

import view.ConsoleUI;
import view.commands.AddToy;
import view.commands.Back;
import view.commands.Command;
import view.commands.IssueToy;
import view.commands.Play;
import view.commands.ReadFile;
import view.commands.SaveFile;
import view.commands.ShowListToy;
import view.commands.ShowPriorityToy;

public class MainMenu implements Menu{
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        this.commandList = new ArrayList<>();
        this.commandList.add(new AddToy(consoleUI));
        this.commandList.add(new Play(consoleUI));
        this.commandList.add(new ShowPriorityToy(consoleUI));
        this.commandList.add(new ShowListToy(consoleUI));
        this.commandList.add(new IssueToy(consoleUI));
        this.commandList.add(new SaveFile(consoleUI));
        this.commandList.add(new ReadFile(consoleUI));
        this.commandList.add(new Back(consoleUI));

    }

    @Override
    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public int getSize() {
        return commandList.size();
    }

    @Override
    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }
}
