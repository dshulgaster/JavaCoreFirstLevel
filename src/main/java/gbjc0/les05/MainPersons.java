package gbjc0.les05;

import java.util.Random;

public class MainPersons {
    public static Random random = new Random();
    public static void main(String[] args) {
        Employee person1 = new Employee("Shulga", "ds@ds.ru", 40);
        Employee[] persArr = new Employee[5];
        persArr[0] = new Employee("Ivanov", "iv@fg.com", 50);
        persArr[1] = new Employee("Petrov", "pet@fg.com", 70);
        persArr[2] = new Employee("Sidorova", "sid@fg.com", 66);
        persArr[3] = new Employee("Popov", "pop@fg.com", 41);
        persArr[4] = new Employee("Smolov", "smol@fg.com", 35);

        System.out.println(person1.toString());
        System.out.println("Пенсионный возраст (для мужчин): " + Employee.retirementAgeM);

        // генерируем для сотрудников случайный номер телефона (последние два символа) - факультативно == для себя (для удобства)
        String endRandomPhoneNumber = "";
        for (int i = 0; i < persArr.length; i++) {
            endRandomPhoneNumber = "+7-903-";
            for (int j = 0; j < 7 ; j++) {
                endRandomPhoneNumber += Integer.toString(random.nextInt(10));
            }
            persArr[i].setPhoneNumber(endRandomPhoneNumber);
        }

        // С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        System.out.println();
        System.out.println("Сотрудники, старше 40 лет");
        for (int i = 0; i < persArr.length; i++) {
            if (persArr[i].isOlder40()) {
                System.out.println(persArr[i].toString() + ", phone: (через гетер) " + persArr[i].getPhoneNumber());
            }
        }
        
        // факультативно (для себя); с помощью цикла вывести всех пенсионеров
        System.out.println();
        System.out.println("Сотрудники, старше пенсионного возраста (факультативно == для себя");
        for (int i = 0; i < persArr.length; i++) {
            if (persArr[i].isRetireeM()) {
                System.out.println(persArr[i].toString() + ", phone: (через гетер) " + persArr[i].getPhoneNumber());
            }
        }

    }
}
