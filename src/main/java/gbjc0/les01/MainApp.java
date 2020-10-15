package gbjc0.les01;

public class MainApp {
    public static void main(String[] args) {
        byte testByte = -18;                    // 8-битное знаковое целое число от -128 до 127
        short testShort = 350;                  // 16-битное знаковое целое число от -32768 до 32767
        int testInt = 55030;                    // 32-битное знаковое целое число от -2147483648 до 2147483647
        long testLong = -5820485928829384L;     // 64-битное знаковое целое число от -9223372036854775808 до 9223372036854775807
        float testFloat = 5.6f;                 // 32-битное знаковое число с плавающей запятой одинарной точности
        double testDouble = 5.23456;            // 64-битное знаковое число с плавающей запятой двойной точности
        char testChar = 'd';                    // 16-битный тип данных, предназначенный для хранения символов в кодировке Unicode
        // от '\u0000' или 0 до '\uffff' или 65,535
        boolean testBoolean = true;             // логический тип данных: false, true

        // 3. вывод выражения a * (b + (c / d))
        double a = 5, b = 1, c = 7.5, d = 4.3;  // если int, при делении возникнут проблемы (как вариант, можно приводить в методе int в double)
        System.out.println("3. a * (b + (c / d)) = " + mathTest(a, b, c, d));

        // 4. проверяем, что сумма чисел находится в пределах от 10 до 20
        int a1 = 5, a2 = 16;
        System.out.println("4. a1 = " + a1 + ", a2 = " + a2);
        System.out.println("Сумма чисел находится в пределах от 10 до 20? " + sumCheck(a1, a2));

        // 5. Положительное ли передаем число?
        int b1 = -15;
        System.out.println("5. Передали число = " + b1);
        System.out.println("Это число " + signNumber(b1));

        // 6. "True", если число отрицательное
        System.out.println("6. Это число отрицательное? " + signNumberTrue(b1));

        // 7. Привет, helloName()
        String name = "Dima";
        helloName(name);

        // 8. Високосный ли год?
        int year = 2000;
        System.out.println("8. " + year + " год " + leapYear(year));

    }

    // 3. метод, вычисляющий выражение a * (b + (c / d))
    public static double mathTest(double a, double b, double c, double d) {
        double res = a * (b + (c / d));
        return res;
    }

    // 4. метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20 (включительно)
    public static boolean sumCheck(int a, int b) {
        boolean res;
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            res = true;
        } else {
            res = false;
        }
        System.out.println("Сумма = " + sum);
        return res;
    }

    // 5. Метод signNumber - положительное ли передали число
    public static String signNumber(int a) {
        String res;
        if (a >= 0) {
            res = "положительное";
        } else res = "отрицательное";
        return res;
    }

    // 6. Метод signNumberTrue - "True", если число отрицательное
    public static boolean signNumberTrue(int a) {
        boolean resTrue = false;
        if (a < 0) {
            resTrue = true;
        }
        return resTrue;
    }

    // 7. Метод helloName выводит в консоль сообщение «Привет, указанное_имя!»;
    public static void helloName(String s){
        System.out.println("7. Привет, "  + s + "!");
    }

    // 8. високосный ли год?
    // 4-й год високосный: если делится на 4, то високосный, НО НИЖЕ исключения
    // - если делится на 100 без остатка, то не високосный, НО ЕСЛИ ДЕЛИТСЯ без остатка на 400,
    // ТО ВСЕ ЖЕ високосный.
    public static String leapYear(int year) {
        String leapYear;
        /* -- проверка работы программы --
        System.out.println("year :: " + year);
        System.out.println("year % 400 == 0 :: " + (year % 400));
        System.out.println("year % 4 != 0 :: " + (year % 4));
        System.out.println("year % 100 != 0 :: " + (year % 100));
        */
        if (year % 400 == 0) {
            leapYear = "високосный (кратен 400 - остаток при делении на 400 равно 0)";
        } else {
            if (year % 4 != 0) {
                leapYear = "не високосный (не кратен 4 - остаток при делении на 4 не равен 0)";
            } else {
                if (year % 100 == 0) {
                    leapYear = "не високосный (не кратен 100 - остаток при делении на 100 не равен 0)";
                } else leapYear = "високосный (исключение всего - кратен 4 и не кратен 100)";
            }
        }
        return leapYear;
    }
}
