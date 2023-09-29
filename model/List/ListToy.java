package model.List;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import model.InterfaceToy;

public class ListToy <E extends InterfaceToy> implements Serializable{
    private List<E> listToy;

    public ListToy() {
        this.listToy = new ArrayList<>();
    }

    public void changeQuantityToy(int id, int quantity) {
        if (this.getToy(id) != null) {
            this.getToy(id).setQuantity(quantity);
        }
    }

    public boolean addToy(E toy) {
        this.listToy.add(toy);
        return true;
    }
    
    public boolean removeToy(int id) {
        if (getToy(id).getQuantity() == 1) {
            this.listToy.remove(getToy(id));
        } else {
            this.getToy(id).setQuantity(this.getToy(id).getQuantity() - 1);
        }
        return true;
    }

    public E getToy(int id) {
        for (E e : listToy) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public int getSize() {
        if (this.listToy.isEmpty()) {
            return 0;
        }
        return this.listToy.size();
    }

    public int getWeightToy(int id) {
        return this.listToy.get(id).getWeight();
    }

    public int[] getIdListToy() {
        int count = 0;
        int[] temp = new int[this.getSize()];
        for (E e : this.listToy) {
            temp[count] = e.getId();
            count++;
        }
        return temp;
    }

    public int getSumWeightToy() {
        int result = 0;
        for (E e : listToy) {
            result += e.getWeight();
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        Formatter formatter = new Formatter();
        formatter.format("%-3s %-10s    %-10s   %-10s   %s",
                         "ID", "Имя", "Вес", "Кол-во",  "\n");
        
        for (E e : listToy) {
            formatter.format("%-3s %-10s    %-10s   %-10s   %s",
                            e.getId(), e.getName(), e.getWeight(), e.getQuantity(), "\n");
        }
        
        stringBuilder.append(formatter);
        return stringBuilder.toString();
    }
}


