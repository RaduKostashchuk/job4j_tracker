package ru.job4j.oop;

public class JukeBox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена.");
        }
    }

    public static void main(String[] args) {
        JukeBox obj = new JukeBox();
        obj.music(1);
        obj.music(2);
        obj.music(100);
    }
}
