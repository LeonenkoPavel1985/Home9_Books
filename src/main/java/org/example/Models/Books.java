package org.example.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Books")

public class Books {
    @Id
    @Column(name = "idBooks")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "year_of_ issue")
    private int yearIssue;

    @Column(name = "book_style")
    private String bookStyle;

    @Column(name = "number_of_pages")
    private int numberPages;

    @Column(name = "description")
    private String description;

    public Books(int id, String bookName, String authorName, int yearIssue, String bookStyle, int numberPages, String description) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.yearIssue = yearIssue;
        this.bookStyle = bookStyle;
        this.numberPages = numberPages;
        this.description = description;
    }

    public Books(String bookName, String authorName, int yearIssue, String bookStyle, int numberPages, String description) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.yearIssue = yearIssue;
        this.bookStyle = bookStyle;
        this.numberPages = numberPages;
        this.description = description;
    }

    public Books() {
        bookName="noName";
        authorName="noName";
        numberPages=0;
    }

    public String toString() {
        return "bookName: " + bookName + " authorName: " + authorName + " yearIssue: " + yearIssue +
                " bookStyle: " + bookStyle + " numberPages: " + numberPages + " description: " + description + "\n";
    }

    public void setBookName(String name) {
        this.bookName = name;
    }
    public void setAuthorName(String name) {
        this.authorName = name;
    }
    public void setYearIssue(int num) {
        this.yearIssue = num;
    }
    public void setStyle(String name) {
        this.bookStyle = name;
    }
    public void setPages(int num) {
        this.numberPages = num;
    }
    public void setDescription(String name) {
        this.description = name;
    }
}
