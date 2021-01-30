package Урок3.Lesson3;

import java.util.Random;
import java.util.Scanner;
public class Main {
    public static Scanner sc = new Scanner(System.in);

    // №1
    public static void main(String[] args) {

        game("Загадываем число");
        {
            int rpt = getNumberFromScanner("Повторить игру еще раз? 1 – да / 0 – нет", 0, 1);
            if (rpt == 1) {
                game("Играем ещё раз!");
            } else {
                System.out.println("Спасибо за участие!");
            }
        }
        mainSec("Игра №2");
    }

    public static int gainNum() {
        Random num = new Random();
        int k = num.nextInt(9);
        return k;
    }

    public static void game(String message) {
        int q = gainNum();
        boolean corr = false;
        for (int i = 0; i < 3; i++) {
            int answer = getNumberFromScanner("Угадайте число от 0 до 9", 0, 9);

            if (answer == q) {
                System.out.println("Верно!");
                corr = true;
                break;
            } else if (answer > q) {
                System.out.println("Число слишком большое");
                corr = false;
            } else {
                System.out.println("Число слишком маленькое");
                corr = false;
            }
        }
        if (corr = true) {
            System.out.println("Вы угадали!");
        } else {
            System.out.println("Вы не смогли угадать :(" +
                    "Правильный ответ - " + q);
        }
    }

    public static int getNumberFromScanner(String message, int min, int max) {
        int x;
        do {
            System.out.println(message);
            x = sc.nextInt();
        } while (x < min || x > max);
        return x;
    }

    //№2
    public static void mainSec(String args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random r = new Random();
        String theWord = words[r.nextInt(words.length)];
        String guess = hide(theWord);
        System.out.println("Угадайте слово!");
        String answer = sc.next();
        // Какая-то ошибка в сравнении, не могу найти её.
        while (true){
            theWord = answer;
            if(guess.equals(answer)){
                System.out.println("Правильно! Слово -" + theWord);
                break;
            } else {
                String result = "";
                for (int i = 0; i < guess.length()-1; i++) {
                    if(guess.charAt(i) == answer.charAt(i)){
                        result += guess.charAt(i);
                    } else { result += "#";
                    }
                    System.out.println(result);
                    System.out.println("Попробуйте ещё раз!");
                }
            }
        }
    }

    public static String hide(String x) {
        String c = "###############";
        for (int i = x.length() - 1; i < c.length() - 1; i++) {
            x += c.charAt(i);
        }
        return x;
    }}