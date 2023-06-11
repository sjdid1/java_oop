package geekbrains.homework_4;

import java.util.ArrayList;

    public class Box<T extends Fruit> {
        private ArrayList<T> fruits;
    
        public Box() {
            fruits = new ArrayList<>();
        }
    
        public void addFruit(T fruit) {
            if (fruits.size() == 0 || fruit.getClass() == fruits.get(0).getClass()) {
                fruits.add(fruit);
            } else {
                System.out.println("Error: cannot add " + fruit.getClass().getSimpleName() +
                        " to a box of " + fruits.get(0).getClass().getSimpleName());
            }
        }
    
        public float getWeight() {
            float weight = 0.0f;
            for (T fruit : fruits) {
                weight += fruit.getWeight();
            }
            return weight;
        }

        public boolean compare(Box<?> box) {
            return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
        }

        public void transfer(Box<T> anotherBox) {
            if (fruits.size() == 0) {
                System.out.println("Error: cannot transfer fruits from an empty box");
                return;
            }
            if (fruits.get(0).getClass() != anotherBox.fruits.get(0).getClass()) {
                System.out.println("Error: cannot transfer fruits between boxes of different types");
                return;
            }
            anotherBox.fruits.addAll(fruits);
            fruits.clear();
        }

    }

