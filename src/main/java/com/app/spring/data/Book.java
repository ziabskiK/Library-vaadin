package com.app.spring.data;

import javax.persistence.*;

@Entity(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;


    @Column(name = "author_first_name")

    private String authorFirstName;
    @Column(name = "author_last_name")
    private String authorLastName;





    public Book() {
    }

    public Book(String authorLastName,String title, String authorFirstName) {
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }



    @Override
    public String toString() {
        return
                "ID: " + id +" Title: " + title + " Author: " + authorFirstName +" "+authorLastName;
    }
}
