package ru.geekbrains.lesson3.task2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Comparator;

public class Program {

    static Random random = new Random();

    /**
     * TODO: Переработать метод generateEmployee в рамках домашнего задания,
     *  метод должен генерировать рабочих (Employee) разных типов.
     * @return
     */
    // static Worker generateEmployee(){
    //     String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
    //     String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

    //     int salary = random.nextInt(20000, 80000);
    //     return new Worker(names[random.nextInt(2)], surnames[random.nextInt(surnames.length)], salary);
    // }
    
        
        // public static Employee generateEmployee() {
        //     String[] names = new String[] { "Anatoly", "Gleb", "Klim", "Martin", "Lazar", "Vladlen", "Klim", "Pankraty", "Ruben", "German" } ;
        //     String[] surnames = new String[] { "Grigoriev", "Fokin", "Shestakov", "Khokhlov", "Shubin", "Biryukov", "Kopylov", "Gorbunov", "Lytkin", "Sokolov" } ;
            
        //     int salary = random.nextInt(20000, 80000);
        //     int type = random.nextInt(3);
            
        //     switch(type) {
        //         case 0:
        //             return new Worker(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], salary);
        //         case 1:
        //             return new Manager(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], salary);
        //         case 2:
        //             return new Executive(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], salary);
        //         default:
        //             return null;
        //     }
        // }
        public class EmployeeAgeComparator implements Comparator<Employee> {

            @Override
            public int compare(Employee e1, Employee e2) {
                if (e1.getAge() < e2.getAge()) {
                    return -1;
                } else if (e1.getAge() > e2.getAge()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        
        
        private int age;
        
       
        public Employee(String name, String surname, int salary, int age) {
            this.name = name;
            this.surname = surname;
            this.salary = salary;
            this.age = age;
        }
        
      
        public int getAge() {
            return age;
        }
        
        
        public Worker(String name, String surname, int salary, int age) {
            super(name, surname, salary, age);
        }
        
        public Manager(String name, String surname, int salary, int age) {
            super(name, surname, salary, age);
        }
        
        public Executive(String name, String surname, int salary, int age) {
            super(name, surname, salary, age);
        }
        
       
        public static Employee generateEmployee() {
            String[] names = new String[] { "Anatoly", "Gleb", "Klim", "Martin", "Lazar", "Vladlen", "Klim", "Pankraty", "Ruben", "German" } ;
            String[] surnames = new String[] { "Grigoriev", "Fokin", "Shestakov", "Khokhlov", "Shubin", "Biryukov", "Kopylov", "Gorbunov", "Lytkin", "Sokolov" } ;
            
            int salary = random.nextInt(20000, 80000);
            int age = random.nextInt(18, 60);
            int type = random.nextInt(3);
            
            switch(type) {
                case 0:
                    return new Worker(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], salary, age);
                case 1:
                    return new Manager(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], salary, age);
                case 2:
                    return new Executive(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], salary, age);
                default:
                    return null;
            }
        }
        
        
        Arrays.sort(employees, new EmployeeAgeComparator());
    /**
     * TODO: Придумать новые состояния для наших сотрудников
     *   Придумать несколько Comparator'ов для сортировки сотрудников
     *   по фамилии + имени или по возрасту + уровню зп.
     * @param args
     */
    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++)
        {
            employees[i] = generateEmployee();
        }

        Arrays.sort(employees);

        for (Employee employee: employees) {
            System.out.println(employee);
        }



    }
    

}
