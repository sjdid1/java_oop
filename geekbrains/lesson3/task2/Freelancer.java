package ru.geekbrains.lesson3.task2;


    public class Freelancer extends Employee {
    
        private int hoursWorked;
        
        public Freelancer(String name, String surname, int hoursWorked) {
            super(name, surname, 0, 0);
            this.hoursWorked = hoursWorked;
        }
        
        public int getHoursWorked() {
            return hoursWorked;
        }
        
        public void setHoursWorked(int hoursWorked) {
            this.hoursWorked = hoursWorked;
        }
        
        @Override
        public int getSalary() {
            return hoursWorked * 200 * 8 * 20;
        }
    }
    
    
    public static Employee generateEmployee() {
        String[] names = new String[] { "Anatoly", "Gleb", "Klim", "Martin", "Lazar", "Vladlen", "Klim", "Pankraty", "Ruben", "German" } ;
        String[] surnames = new String[] { "Grigoriev", "Fokin", "Shestakov", "Khokhlov", "Shubin", "Biryukov", "Kopylov", "Gorbunov", "Lytkin", "Sokolov" } ;
        
        int type = random.nextInt(4);
        
        switch(type) {
            case 0:
                int salary = random.nextInt(20000, 80000);
                int age = random.nextInt(18, 60);
                return new Worker(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], salary, age);
            case 1:
                salary = random.nextInt(40000, 120000);
                age = random.nextInt(25, 65);
                return new Manager(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], salary, age);
            case 2:
                salary = random.nextInt(80000, 200000);
                age = random.nextInt(30, 70);
                return new Executive(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], salary, age);
            case 3:
                int hoursWorked = random.nextInt(80, 200);
                return new Freelancer(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], hoursWorked);
            default:
                return null;
        }
    }
    
    int totalSalary = 0;
    for (Employee employee : employees) {
        totalSalary += employee.getSalary();
    }
    System.out.println("Total salary: " + totalSalary);

