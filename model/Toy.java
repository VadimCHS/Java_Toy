package model;

import java.io.Serializable;
import java.util.Formatter;

public class Toy implements InterfaceToy, Serializable{
    private int id;
    private int weight;
    private String name;
    private int quantity;

    public Toy(int id, int weight, int quantity, String name) {
        this.id = id;
        this.weight = weight;
        this.name = name;
        this.quantity = quantity;
    }

    public Toy(int id, int quantity, String name) {
        this(id, 0, quantity, name);
    }

    public int getId() {
        return this.id;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getName() {
        return this.name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("%-3s %-10s    %-10s   %-10s",
                         this.id, this.name, this.weight, this.quantity);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(formatter);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
