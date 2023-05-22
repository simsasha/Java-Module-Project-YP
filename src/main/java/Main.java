public class Main {
    int result;
    public static void main(String[] args) {
        CountingPeople count = new CountingPeople(); // Отдельный класс подсчета кол-ва людей;
        int result = count.calculate(); // Считаем кол-во людей;
        newGoodGenerator generator = new newGoodGenerator(); // Калькулятор из задания наывается в моем решении генератором;
        do{
            generator.generateNewGood(); // Создаем первый товар;
        } while (generator.askingMoreGoods()); // Тут спрашиваем нужны ли еще товары;
        // System.out.println("Добавили все товары, какие мы хотели");
        generator.showTotalPrice();
        generator.bill(result); // Метод проводит расчет по покупкам;
    }
}


