package model.List;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import model.InterfaceToy;

public class IssueListToy <E extends InterfaceToy> implements Serializable{
    private List<E> issueListToy;

    public IssueListToy() {
        this.issueListToy = new ArrayList<>();
    }

    public void addToy(E toy) {
        this.issueListToy.add(toy);
    }

    public List<E> getListToy() {
        return this.issueListToy;
    }

    public int getSize() {
        return this.issueListToy.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter();
        
        for (E e : issueListToy) {
            formatter.format("%-3s %-10s    %-10s   %s",
                            "ID: " + e.getId(), "Имя: " + e.getName(), "Вес: " + e.getWeight(), "\n");
        }
        
        stringBuilder.append(formatter);
        return stringBuilder.toString();
    }
}
