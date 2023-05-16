import java.util.Scanner;

public class Calculator {
    String goodsName;
    int goodsAmount = 0;
    double total;
    int people;

    Scanner scanner = new Scanner(System.in);

    public void peopleCount() {
        int peopleNumber;
        while (true) {
            System.out.println("Введите количество гостей");
            peopleNumber = scanner.nextInt();
            if (peopleNumber <= 1) {
                System.out.println("Некорректное количество гостей, значение должно быть больше 1");
            } else {
                people = peopleNumber;
                scanner.nextLine();
                break;
            }
        }
    }

    public void addGoods() {
        String goodsName;
        double goodsPrice;
        scanner = new Scanner(System.in);
        peopleCount();
        while (true) {
            System.out.println("Введите наименование товара \n Введите 'Завершить' чтобы закончить ввод товаров");

            goodsName = scanner.nextLine();
            if (goodsName.equalsIgnoreCase("Завершить")) {
                bill();
                break;
            } else {
                while (true) {
                    System.out.println("Введите цену товара в формате рубли.копейки");
                    goodsPrice = scanner.nextDouble();
                    if (goodsPrice <= 0) {
                        System.out.println("Цена должна быть больше 0. Повторите ввод");
                        break;
                    } else {
                        total = total + goodsPrice;
                        goodsAmount++;
                    }

                }
            }
        }
    }

    public void bill() {
        double num = total / people;
        String rubleText;
        int preDigit = (int) ((num % 100) / 10);
        if (preDigit == 1) {
            rubleText = "рублей";
        } else {
            rubleText = switch ((int) (num % 10)) {
                case 1 -> "рублю";
                case 2, 3, 4 -> "рубля";
                default -> "рублей";
            };
        }
        System.out.println("Добавленные товары:" + "\n" + goodsName);
        System.out.printf("Каждый человек заплатит %.2f %s%n", total, rubleText);
    }
}

