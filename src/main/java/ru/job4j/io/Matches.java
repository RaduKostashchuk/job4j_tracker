package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 11;
        boolean turn = true;
        String player = "";
        System.out.println("Игра 11");
        while (count > 0) {
            player = turn ? "Игрок №1" : " Игрок №2";
            System.out.println(player + ", введите число от 1 джо 3");
            String num = input.nextLine();
            num = num.equals("") ? "0" : num;
            switch (num) {
                case "1", "2", "3" :
                    count -= Integer.parseInt(num);
                    turn = !turn;
                    System.out.println("На столе осталось " + Math.max(count, 0) + " спичек");
                    break;
                default :
                    System.out.println("Неверное число");
            }

        }
        System.out.println("Выиграл " + player);
    }
}