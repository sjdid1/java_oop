package ru.geekbrains.lesson1;

public class Sneackers extends Product{

    private double volume; // объем
    private int fatСontent; // Содержание жирности
    private int calories; // калории

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getFatСontent() {
        return fatСontent;
    }

    public void setFatСontent(int fatСontent) {
        this.fatСontent = fatСontent;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Sneackers(String brand, String name, double price, double volume, int fatСontent) {
        super(brand, name, price);
        this.volume = volume;
        this.fatСontent = fatСontent;
    }

    @Override
    public String displayInfo() {
        return String.format("[Батончик]%s - %s - %f - [объем: %f; жирность: %d; калории: %a]", brand, name, price, volume, fatСontent, calories);
    }
}

