import java.util.*;

public class Les3 {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();


    public static void main(String[] args) {
        System.out.println("Выберите игру (1 - угадывание числа, 0 - угадывание слова)");
        if (scanner.nextInt() == 1)
            guessNumber();//Задание 1
        else
            guessWord();//Задание 2
        scanner.close();
    }

    private static void guessNumber() {
        boolean isWantMore;
        do {
            oneGameGuessNumber();
            System.out.println("Повторить игру (1 - да, 0 - нет)");
            isWantMore = scanner.nextInt() == 1;
        } while (isWantMore);
    }

    private static void oneGameGuessNumber() {
        int attempt = 0;
        int hiddenNumber = random.nextInt(10);
        System.out.println("\nУгадайте за три попытки число от 0 до 9 (это число " + hiddenNumber + ")");
        do {
            int enteredNumber = scanner.nextInt();
            if (enteredNumber == hiddenNumber) {
                System.out.println("Правильно");
                break;
            } else
                System.out.println("Неправильно. Введите число");
            attempt++;
        } while (attempt < 3);
    }

    //Задание 2
    private static final void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};
        String hiddenWord = words[random.nextInt(words.length)];
        System.out.println("Угадайте слово (это слово " + hiddenWord + ")");
        do {
        } while (!oneTryGuessWord(hiddenWord));
    }

    private static boolean oneTryGuessWord(String hiddenWord) {
        System.out.println("Введите слово");
        String enteredWord = scanner.next();
        if (enteredWord.equals(hiddenWord)) {
            System.out.println("Правильно");
            return true;
        } else {
            System.out.println("Неправильно");
            printEqualLetters(hiddenWord, enteredWord);
            return false;
        }
    }

    private static void printEqualLetters(String hiddenWord, String enteredWord) {
        StringBuilder sb = new StringBuilder("###############");
        for (int i = 0; i < 15; i++) {
            if (i >= enteredWord.length() || i >= hiddenWord.length())
                break;
            if (enteredWord.charAt(i) == hiddenWord.charAt(i))
                sb.replace(i, i + 1, String.valueOf(enteredWord.charAt(i)));
        }
        System.out.println("Результат: " + sb);
    }
}
