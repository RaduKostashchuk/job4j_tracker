package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book b1 = new Book("Head first", 600);
        Book b2 = new Book("Clean Code", 400);
        Book b3  = new Book("Core Java", 500);
        Book b4 = new Book("The complete reference", 700);
        Book temp;
        Book[] library = new Book[4];
        library[0] = b1;
        library[1] = b2;
        library[2] = b3;
        library[3] = b4;
        for (int index = 0; index < library.length; index++) {
            System.out.println("\"" + library[index].getName() + "\""
                    + " " + library[index].getSize());
        }
        System.out.println();
        temp = library[0];
        library[0] = library[3];
        library[3] = temp;
        for (int index = 0; index < library.length; index++) {
            System.out.println("\"" + library[index].getName() + "\""
                    + " " + library[index].getSize());
        }
        System.out.println();
        for (int index = 0; index < library.length; index++) {
            if ("Clean Code".equals(library[index].getName())) {
                System.out.println("\"" + library[index].getName() + "\""
                        + " " + library[index].getSize());
            }
        }
    }
}
