package gbjc0.les05;

public class Employee {
    private String firstName;
    private String surName;
    private String patronymic;
    private String phoneNumber;
    private String email;
    private int salary;
    private byte age;
    private char sex;   // факультативно
    public static final int retirementAgeM = 65;  // факультативно; пенсионный возраст М (для всех одинаковый, поэтому статичный)
    public static final int retirementAgeF = 60;  // факультативно; пенсионный возраст Ж(для всех одинаковый, поэтому статичный)

    // конструктор 1 (без sex)
    public Employee(String firstName, String surName, String patronymic, String phoneNumber, String email,
                    int salary, int age) {
        this.firstName = firstName;
        this.surName = surName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.salary = salary;
        this.age = (byte)age;
    }

    // конструктор 2 (упрощенный)
    public Employee(String surName, String email, int age) {
        this.surName = surName;
        this.email = email;
        this.age = (byte)age;
    }

    // конструктор (совсем простой)
    public Employee(String surName) {
        this.surName = surName;
    }

    public String toString() {
        return surName + ", " + age + " лет";
    }

    // проверяет пенсионер ли (для примера только для мужчины, для женщины аналогично)
    public boolean isOlder40() {
        return this.age > 40;
    }

    // проверяет пенсионер ли (для примера только для мужчины, для женщины аналогично)
    public boolean isRetireeM() {
        return this.age >= retirementAgeM;
    }

    public String  getSurName() {
        return surName;
    }

    public String  getFirstName() {
        return firstName;
    }

    public String  getPatronymic() {
        return patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = (byte) age;
    }

}
