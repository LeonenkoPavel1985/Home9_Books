package org.example.Controllers;

import org.example.HibernateSessionGet;
import org.example.Models.Books;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ControllerBooks {

    public ControllerBooks() {}

    public Books getBooksById(int id) {
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Books books = session.get(Books.class, id);
        tx.commit();
        return books;
    }

    public boolean addBooks(Books books) {
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(books);
        tx.commit();
        return true;
    }

    public boolean addBooks(String bookName, String authorName, int yearIssue, String bookStyle, int numberPages, String description) {
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        session.persist(new Books(bookName, authorName, yearIssue, bookStyle, numberPages, description));
        tx.commit();
        return true;
    }

    public boolean removeBooksById(int id) {
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        boolean test = false;
        Books books = session.get(Books.class, id);
        if (books != null) {
            session.remove(books);
            test = true;
        }
        tx.commit();
        return test;
    }

    public boolean updateBooksById(int id, String bookName, String authorName, int yearIssue, String bookStyle, int numberPages, String description) {
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Books books = session.get(Books.class, id);
        if (!bookName.isEmpty() || bookName!=null) books.setBookName(bookName);
        if (!authorName.isEmpty() || authorName!=null) books.setAuthorName(authorName);
        if (yearIssue > 0) books.setYearIssue(yearIssue);
        if (!bookStyle.isEmpty() || bookStyle!=null) books.setStyle(bookStyle);
        if (numberPages > 0) books.setPages(numberPages);
        if (!description.isEmpty() || description!=null) books.setDescription(description);
        tx.commit();
        return true;
    }

    public List<Books> getBooksByBookName(String bookName) {
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        List<Books> results = session.createQuery("FROM Books WHERE bookName='" + bookName + "'").list();
        tx.commit();
        if (results.size() >0 )
            return results;
            else return null;
    }
}
