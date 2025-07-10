import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};
        int[] buy = new int[products.length];

        showMenu(products, prices);
        productSelection(buy);
        groceryBasket(products, prices, buy);


    }

    private static void groceryBasket(String[] products, int[] prices, int[] buy) {
        int sumProducts = 0;
        System.out.println("Ваша корзина: ");

        for (int i = 0; i < products.length; i++) {
            if (buy[i] > 0) {
                int currentPrice = prices[i] * buy[i];
                sumProducts += currentPrice;
                System.out.printf("%s %d шт %d руб/шт %d руб в сумме\n",
                        products[i], buy[i], prices[i], currentPrice);
            }

        }
        System.out.printf("Итого %d руб\n", sumProducts);
    }

    private static void productSelection(int[] buy) {
        while (true) {
            System.out.println("Выберите товар и количество или введите end");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if ("end".equals(answer)) {
                break;
            }

            String[] positionAndCounter = answer.split(" ");
            int productNumber = Integer.parseInt(positionAndCounter[0]) - 1;
            int productCount = Integer.parseInt(positionAndCounter[1]);

            buy[productNumber] += productCount;

        }
    }

    private static void showMenu(String[] products, int[] prices) {
        System.out.println("Список возможных товаров для покупки: ");
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d. %s %d руб/шт.\n", i + 1, products[i], prices[i]);

        }
    }
}