package org.example;

import org.example.Controllers.ControllerBooks;
import org.example.Models.Books;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        ControllerBooks cb = new ControllerBooks();

        //Заполнение БД.
        //cb.addBooks(new Books("book_name", "author_name", 0,"book_style",0, "cool"));
        cb.addBooks("Collected Works", "Alexander Pushkin", 2001, "Poetry", 250, "Collection of the best works");
        cb.addBooks("Collected Works 2 ", "Alexander Pushkin", 2007, "Poetry", 150, "Collection of the best works");

        //Демонстрация БД.
        System.out.println(cb.getBooksById(1).toString());
        System.out.println(cb.getBooksById(5).toString());


        String bookName =  "Collected Works3";
        List<Books> resultsBookName = cb.getBooksByBookName(bookName);
        if (resultsBookName.size() > 0 || resultsBookName !=null) {
            for(Books c : resultsBookName) {
                System.out.println(c.toString());
            }
        }
        else {System.out.println("Books with title -  " + bookName + " not found.");}
    }
}