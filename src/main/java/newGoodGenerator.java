import java.util.Scanner;

public class newGoodGenerator { // Добавить с большой буквы; Классы в JAVA с большой буквы.
    String nameToSet = "Nameless Good";
    double priceToSet = 00.00;
    double totalPrice = 00.00;
    public String allGoods = "Список всех товаров: " + "\n";

    public String generateNewGood() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название товара, чтобы добавить его");
        // String descriptionArrived = scanner.next(); Была ошибка, что считывал только до пробела и выкидывал ошибку.
        this.nameToSet = scanner.nextLine();
        do {
            System.out.println("Введите цену товара, чтобы добавить ее (рубли.копейки)");
            while (true) // Проверка на то, чтобы ввели положительное число. Можно было бы вынести в отдельный метод. Но в контексте работы, не хотелось бы.
            {
                if (scanner.hasNextDouble() || scanner.hasNextLong() || scanner.hasNextInt()) {
                    this.priceToSet = Double.parseDouble(scanner.nextLine());
                    if (this.priceToSet < 1) {
                        System.out.println("Вы ввели отрицательное число: " + this.priceToSet);
                    }
                    break;
                } else {
                    System.out.println("Вы ввели не число, повторите");
                    scanner.nextLine();
                }
            }
        } while (this.priceToSet <= 1);
        Good goodToSend = new Good(); // Создаем новый товар из класса Good;
        String goodAdded = goodToSend.goodCreated(this.nameToSet, this.priceToSet);
        this.addingNewGood(this.nameToSet, this.priceToSet);
        return goodAdded;
    }

    public boolean askingMoreGoods() { //
        Scanner scanner = new Scanner(System.in);
        System.out.println("Нужны еще товары, нажмите 'Enter'. Чтобы завершить программу введите 'Завершить'");
        String userReply = scanner.nextLine();
        if (userReply.equalsIgnoreCase("Завершить")) // Выход из цикла по условиям задачи;
        {
            return false;
        } else {
            System.out.println("Добавляем еще один товар");
            return true;
        }
    }

    public void addingNewGood(String name, double price) {
        String formattedDouble = String.format("%.2f", price); // Можно было бы вынести в отдельный метод, чтобы было DRY, но не вижу смысла;
        System.out.println("Товар был добавлен в корзину: " + formattedDouble + " " + name);
        String goodDescription = formattedDouble + " - " + name + "; ";
        totalPrice += price;
        System.out.println("Цена всего заказа: " + formattedDouble);
        allGoods = allGoods.concat(goodDescription + "\n");
        System.out.println(allGoods);
    }

    public String showTotalPrice() { // Метод показывает общую форму заказа;
        String formattedDouble = String.format("%.2f", totalPrice); // Можно было бы вынести в отдельный метод, чтобы было DRY, но не вижу смысла;
        System.out.println("Цена всего заказа: " + formattedDouble);
        return formattedDouble;
    }

    public void bill(int peopleCount) { // Метод, который выставляет счет. Он делит общую сумму на кол-во людей;
        double result = totalPrice / peopleCount;
        System.out.println(allGoods);
        System.out.printf("Каждый человек заплатит %.2f %s", result, declinationOfRub(result));
    }
    public String declinationOfRub(double result){
        int num = (int) result;
        int preLastDigit = num % 100 / 10;
        if (preLastDigit == 1)
        {
            return "рублей";
        }
        switch (num % 10)
        {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }

}