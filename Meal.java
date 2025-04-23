package oop_project;

public class Meal {
    protected String mealName;
    protected boolean vegetarian;
    protected double price;

    public Meal(String mealName, boolean vegetarian, double price) {
        this.mealName = mealName;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
