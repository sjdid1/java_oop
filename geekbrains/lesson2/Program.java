package ru.geekbrains.lesson2;

public class Program {

    public class Cat {
        private String name;
        private int appetite;
        private boolean satiety;
        
        public Cat(String name, int appetite) {
            this.name = name;
            this.appetite = appetite;
            this.satiety = false;
        }
        
        public void eat(Plate plate) {
            if (plate.getFood() >= appetite) { 
                plate.decreaseFood(appetite); 
                satiety = true; 
                System.out.println(name + " ate " + appetite + " units of food and is now full.");
            } else {
                System.out.println(name + " is hungry and there is not enough food in the plate.");
            }
        }
        
        public boolean isSatiety() {
            return satiety;
        }
   }
   
   public class Plate {
        private int food;
        
        public Plate(int food) {
            this.food = food;
        }
        
        public void info() {
            System.out.println("Plate: " + food);
        }
        
        public void decreaseFood(int amount) {
            if (food - amount >= 0) { 
                food -= amount;
            } else {
                System.out.println("Cannot decrease food by " + amount + ". Not enough food in the plate.");
            }
        }
        
        public void addFood(int amount) {
            food += amount;
        }
        
        public int getFood() {
            return food;
        }
   }
   
   public class MainClass {
        public static void main(String[] args) {
            Cat cat1 = new Cat("Barsik", 5);
            Cat cat2 = new Cat("Tom", 3);
            Plate plate = new Plate(10);
            plate.info(); 
            cat1.eat(plate); 
            cat2.eat(plate);
            plate.info(); 
            cat1.eat(plate); 
            plate.info();
            plate.decreaseFood(3);
            plate.addFood(5);
            plate.info(); 
        }
   }

}
