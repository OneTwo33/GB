package ru.company.onetwo33.javalvl1.homework7;

class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }

    public boolean isEnoughFood(int appetite) {
        if (appetite > this.food)
            return false;
        else {
            decreaseFood(appetite);
            return true;
        }
    }

    public void decreaseFood(int appetite) {
        this.food -= appetite;
    }

    public void increaseFood(int value) {
        this.food += value;
    }
}
