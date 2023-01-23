import java.util.Random;
import java.util.Scanner;
public class KamakNojicaXartiq {
    private static final String ROCK = "Камък";
    private static final String PAPER = "Хартия";
    private static final String SCISSORS = "Ножица";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Добре дошли в играта Камък, ножица, хартия!%nМожете да спрете играта " +
                "по всяко време, като напишете end, END или може да напишете просто край.%n" +
                "Ако сте по-мързеливи, може просто да използвате бутона Х горе в дясно!%n");
        System.out.println("Ако сте готови да продължите, натиснете ENTER: ");
        String isUserReady = sc.nextLine(); // Ще, НЕ ЩЕ... играта трябва да започне... :D
        int computerWinsCounter = 0;
        int playerWinsCounter = 0;
        int wrongTimesCounter = 0;
        String playerMove = "";
        while (true) {
            //computer
            Random random = new Random();
            int computerRandomNumber = random.nextInt(4);
            String computerMove = "";
            //
            System.out.print("Изберете [к]амък, [н]ожица или [х]артия: ");
            playerMove = sc.nextLine();
            if (playerMove.equals("end") || playerMove.equals("END") || playerMove.equals("край")) {
                break;
            }
            if (playerMove.equals("к") || playerMove.equals("камък")) {
                playerMove = ROCK;
                System.out.println("Вие избрахте камък.");
            } else if (playerMove.equals("н") || playerMove.equals("ножица")) {
                playerMove = SCISSORS;
                System.out.println("Вие избрахте ножица.");
            } else if (playerMove.equals("х") || playerMove.equals("хартия")) {
                playerMove = PAPER;
                System.out.println("Вие избрахте хартия.");
            } else {
                System.out.println("Грешен вход. Опитайте Отново...");
                wrongTimesCounter++;
                if (wrongTimesCounter == 3) {
                    System.out.println("3 пъти вече написахте нещо грешно, ще играете ли или?");
                    isUserReady = sc.nextLine();
                    System.out.println("Продължете.");
                } else if (wrongTimesCounter == 6) {
                    System.out.printf("ПРЕКАЛИХТЕ.%nПРЕКАЛИХТЕ.%nПРЕКАЛИХТЕ.%nПРЕКАЛИХТЕ.%n" +
                            "КРАЙ.%nКРАЙ.%nКРАЙ.%nКРАЙ.%n");
                    break;
                }
                continue;
            }
            switch (computerRandomNumber) {
                case 0:
                    computerMove = ROCK;
                    break;
                case 1:
                    computerMove = PAPER;
                    break;
                case 2:
                    computerMove = SCISSORS;
                    break;
                case 3:
                    computerMove = PAPER;
                    break;
            }
            if (computerMove.equals(ROCK)) {
                System.out.println("Компютъра избра камък.");
            } else if (computerMove.equals(SCISSORS)) {
                System.out.println("Компютъра избра ножица.");
            } else if (computerMove.equals(PAPER)) {
                System.out.println("Компютъра избра хартия.");
            }
            if (playerMove.equals(ROCK) && computerMove.equals(SCISSORS) ||
                    (playerMove.equals(PAPER) && computerMove.equals(ROCK) ||
                            (playerMove.equals(SCISSORS) && computerMove.equals(PAPER)))) {
                System.out.println("Вие спечелихте.");
                playerWinsCounter++;
                System.out.printf("Вашите точки: %d | Точките на компютъра: %d%n", playerWinsCounter, computerWinsCounter);
            } else if (playerMove.equals(ROCK) && computerMove.equals(PAPER) ||
                    (playerMove.equals(PAPER) && computerMove.equals(SCISSORS) ||
                            (playerMove.equals(SCISSORS) && computerMove.equals(ROCK)))) {
                System.out.println("Вие загубихте.");
                computerWinsCounter++;
                System.out.printf("Вашите точки: %d | Точките на компютъра: %d%n", playerWinsCounter, computerWinsCounter);
            } else {
                System.out.println("Равенство.");
                System.out.printf("Вашите точки: %d | Точките на компютъра: %d%n", playerWinsCounter, computerWinsCounter);
            }
        }
    }
}