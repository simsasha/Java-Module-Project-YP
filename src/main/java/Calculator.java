import java.util.Scanner;

class CountingPeople { // Метод спрашивает кол-во людей для выставления счета;
    int result = 0;
    public int calculate() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("На сколько человек считать счет?");
            while (true) // Проверка на то, чтобы ввели именно число. Можно было бы вынести в отдельный метод. Но в контексте работы, не хотелось бы.
            {
                if (scanner.hasNextDouble() || scanner.hasNextLong() || scanner.hasNextInt())
                {
                    result = Integer.parseInt(scanner.nextLine());
                    break;
                }
                else
                {
                    System.out.println("Вы ввели не число, так на сколько человек счет считать?");
                    scanner.nextLine();
                }}
            if (result == 1) {
                System.out.println("А что тут считать, 1 и есть 1");
            } else if (result > 1) {
                System.out.println("Понял, счет делим на " + result);
                return result;
            } else {
                System.out.println("Это некорректное значение для подсчёта, введи снова");
            }
        }
        while (result <= 1);
        return result;
    }
}
