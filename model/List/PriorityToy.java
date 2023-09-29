package model.List;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Formatter;

import model.InterfaceToy;

public class PriorityToy<E extends InterfaceToy> implements Serializable{
    private Deque<E> priorityToy;

    public PriorityToy() {
        this.priorityToy = new ArrayDeque<>();
    }

    

    public boolean addToy(E toy) {
        this.priorityToy.add(toy);
        return true;
    }
    
    public boolean removeToy() {
        this.priorityToy.clear();;
        return true;
    }

    public E getToy() {
        return this.priorityToy.pollLast();
    }

    public int getSize() {
        if (this.priorityToy.isEmpty()) {
            return 0;
        }
        return this.priorityToy.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        Formatter formatter = new Formatter();
        formatter.format("%-3s %-10s    %-10s   %s",
                         "ID", "Имя", "Вес", "\n");

        for (E e : priorityToy) {
            formatter.format("%-3s %-10s    %-10s   %s",
                            e.getId(), e.getName(), e.getWeight(), "\n");
        }

        stringBuilder.append(formatter);
        return stringBuilder.toString();
    }
    
}
