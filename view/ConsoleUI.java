package view;

import java.util.Scanner;

import controller.Controller;
import view.menu.MainMenu;
import view.menu.Menu;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Controller controller;
    private int countMenu;
    private boolean work;
    private Menu mainMenu;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.controller = new Controller(this);
        this.mainMenu = new MainMenu(this);
        this.work = true;
        this.countMenu = 0;
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        menu(mainMenu);
    }

    public void menu(Menu menu) {
        countMenu++;
        while (work) {
            printMenu(menu);
            execute(menu);
        }
        countMenu--;
        if (countMenu != 0) {
            work = true;
        }
    }

    public void finish() {
        System.out.println("Всего доброго!");
        work = false;
    }

    // private int getNumber() {
    //     int chois = -1;
    //     boolean flag = true;
    //     while (flag) {
    //         String temp = scanner.nextLine();
    //         if (checkTextForInt(temp)) {
    //             chois = Integer.parseInt(temp);
    //             flag = false;
    //         }
    //     }
    //     return chois;
    // }

    private void hello() {
        System.out.println("Добро пожаловать в семейное дерево!");
    }

    private void execute(Menu menu) {
        String line = scanner.nextLine();
        System.out.println();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand, menu)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand, Menu menu) {
        if (numCommand <= menu.getSize() && numCommand > 0) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(Menu menu) {
        System.out.println(menu.menu());
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

    public void addToy() {
        boolean flag = true;
        String weight = "";
        String quantity = "";

        System.out.print("Введите имя игрушки: ");
        String name = scanner.nextLine();
        while (flag) {
            System.out.print("Укажите вес игрушки(от 1 до 9): ");
            weight = scanner.nextLine();
            if (checkNumber(weight, 0, 9)) {
                flag = false;
            }
        }

        flag = true;
        while (flag) {
            System.out.print("Укажите кол-во игрушек: ");
            quantity = scanner.nextLine();
            if (checkNumber(quantity, 0, 999999)) {
                flag = false;
            }
        }
        System.out.println();
        this.controller.addToy(name, Integer.parseInt(weight), Integer.parseInt(quantity));
    }

    private boolean checkNumber(String text, int minNumber, int maxNumber) {
        if (text.matches("\\d+")) {
            if (Integer.parseInt(text) > minNumber && Integer.parseInt(text) < maxNumber) {
                return true;
            }
        }
        inputError();
        return false;
    }

    public void play() {
        this.controller.play();
    }

    public void showPriorityToy() {
        this.controller.showPriorityToy();
    }

    public void showListToy() {
        this.controller.showListToy();
    }

    public void saveFile() {
        this.controller.saveFile();
    }

    public void readFile() {
        this.controller.readFile();
    }

    public void back() {
        this.work = false;
    }

    public void issueToy() {
        this.controller.issueToy();
    }

}

