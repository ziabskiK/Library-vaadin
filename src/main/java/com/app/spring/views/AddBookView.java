package com.app.spring.views;

import com.app.spring.data.Book;
import com.app.spring.implementation.BookList;
import com.app.spring.implementation.BookServiceImplementation;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Route(value = "add")
public class AddBookView extends VerticalLayout {
    @Autowired
    BookServiceImplementation service;

    private TextField titleTF;
    private TextField authorTF;

    public AddBookView() {
        setupForm();
        add(new Button("Go to home", e-> navigateToHome()));
    }

    private void navigateToHome(){
        Optional o = getUI();
        if (o.isPresent()){
            getUI().get().navigate("home");
        }
    }
    private void setupForm(){
        //setAlignItems(Alignment.CENTER);
        titleTF = new TextField();
        authorTF = new TextField();
        this.add(new VerticalLayout(new Label("Enter title: "), titleTF));
        this.add(new VerticalLayout(new Label("Enter author: "), authorTF));
        Button addBook = new Button(new Icon(VaadinIcon.PLUS), c-> add());

        add(addBook);

    }
    private void add(){

        String title = titleTF.getValue();
        String[] author = authorTF.getValue().trim().split(" ");
        Book book = new Book(author[author.length-1],title, author[0]);
        service.addNewBook(book);
    }
}
