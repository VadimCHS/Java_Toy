package controller;

import java.io.IOException;

import model.Service;
import view.View;

public class Controller {
    private final String PATH_TOY = "Toys.out";
    private final String PATH_PRIORITY_TOY = "PriorityToys.out";

    private Service service;
    private View view;

    public Controller(View view) {
        this.service = new Service(this.PATH_TOY, this.PATH_PRIORITY_TOY);
        this.view = view;
    }

    public void addToy(String name, int weight, int quantity) {
        this.service.creatToy(name, weight, quantity);
    }

    public void play() {
        this.service.play();
    }

    public void showPriorityToy() {
        this.view.printAnswer(this.service.getPriorityToy());
    }

    public void showListToy() {
        this.view.printAnswer(this.service.getListToy());
    }

    public void saveFile() {
        try {
            this.service.saveFile();
        } catch (IOException e) {
            this.view.printAnswer("Не удалось сохранить файл\n");
        }
    }

    public void readFile() {
        try {
            this.service.readFile();
        } catch (ClassNotFoundException | IOException e) {
            this.view.printAnswer("Не удалось загрузить файл\n");
        }
    }

    public void issueToy() {
        try {
            this.service.issueToy();
        } catch (NullPointerException e) {
            this.view.printAnswer("Список на выдачу пуст.\n");
        }catch (IOException e) {
            this.view.printAnswer("Не удалось сохранить файл\n");
        }
    }
}
