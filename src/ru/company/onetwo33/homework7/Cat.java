package ru.company.onetwo33.homework7;

public class Cat {
    private final String name;
    private int appetite;
    private boolean isFill = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isFill() {
        return isFill;
    }

    public void setFill(boolean fill) {
        isFill = fill;
    }

    public void eat(Plate plate) {
        if (plate.isEnoughFood(getAppetite())) {
            System.out.println(this.name + " is eating...");
            setFill(true);
        } else {
            System.out.println("В тарелке недостаточно еды");
        }
    }
}
