package model;

import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

import model.List.IssueListToy;
import model.List.ListToy;
import model.List.PriorityToy;
import model.save_file.FileHandler;
import model.save_file.SaveIssue;

public class Service implements Serializable{
    private final String ISSUE_PATH = "IssueToy.txt";
    private int id;
    private PriorityToy<Toy> priorityListToy;
    private ListToy<Toy> listToy;
    private IssueListToy<Toy> issueListToy;
    private String pathToy;
    private String priorityToy;
    private FileHandler<ListToy> fileHandlerListToy;
    private FileHandler<PriorityToy> fileHandlerPriorityToy;
    private SaveIssue<IssueListToy> saveIssue;
    

    public Service(String pathToy, String  priorityToy) {
        this.priorityListToy = new PriorityToy<>();
        this.listToy = new ListToy<>();
        this.issueListToy = new IssueListToy<>();
        this.id = 1;
        this.fileHandlerListToy = new FileHandler<>();
        this.fileHandlerPriorityToy = new FileHandler<>();
        this.saveIssue = new SaveIssue<>();
        this.pathToy = pathToy;
        this.priorityToy = priorityToy;
    }

    public boolean creatToy(String name, int weight, int quantity) {
        this.listToy.addToy(new Toy(this.id++, weight, quantity, name));
        return true;
    }

    public boolean deleteToyList(int id) {
        this.listToy.removeToy(id);
        return true;
    }
    
    public boolean deleteToyPr() {
        this.priorityListToy.removeToy();
        return true;
    }
    
    public boolean play() {
        if (this.listToy.getSize() == 0) {
            return false;
        }

        int[] listId = this.listToy.getIdListToy();
        int[] listIdPlay = new int[this.listToy.getSumWeightToy()];

        for (int i = 0, k = 0; i < listId.length; i++) {
            int weight = this.listToy.getWeightToy(i);
            for (int j = weight; j > 0; j--) {
                listIdPlay[k++] = listId[i];
            }
        }

        Random rd = new Random();
        int prizePull = rd.nextInt(listIdPlay.length);
        this.priorityListToy.addToy(this.listToy.getToy(listIdPlay[prizePull]));
        this.listToy.removeToy(listIdPlay[prizePull]);
        return true;
    }

    public String getPriorityToy() {
        return this.priorityListToy.toString();
    }

    public String getListToy() {
        return this.listToy.toString();
    }

    public void saveFile() throws IOException {
        fileHandlerListToy.writeToFile(listToy, this.pathToy);
        fileHandlerPriorityToy.writeToFile(priorityListToy, this.priorityToy);
    }

    public void readFile() throws ClassNotFoundException, IOException {
        this.listToy = fileHandlerListToy.readFromFile(this.pathToy);
        this.priorityListToy = fileHandlerPriorityToy.readFromFile(this.priorityToy);
    }

    public void issueToy() throws IOException {
        if (this.priorityListToy.getSize() == 0) {
            throw new NullPointerException();
        }
        this.issueListToy.addToy(this.priorityListToy.getToy());
        this.saveIssue.writeToFile(issueListToy, this.ISSUE_PATH);
    }
}
