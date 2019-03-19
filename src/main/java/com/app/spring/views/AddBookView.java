package com.app.spring.views;

import com.app.spring.data.Book;
import com.app.spring.implementation.BookService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Route(value = "add")
public class AddBookView extends VerticalLayout {

    @Autowired
    BookService service;

    private TextField titleTF;
    private TextField authorTF;
    private TextArea description;
    private Checkbox check;

    public AddBookView() {
        setupForm();
        add(new Button("Go to home", e -> navigateToHome()));
    }

    private void navigateToHome() {
        Optional o = getUI();
        if (o.isPresent()) {
            getUI().get().navigate("");
        }
    }

    private void setupForm() {
        titleTF = new TextField();
        authorTF = new TextField();

        this.add(new VerticalLayout(new Label("Enter title: "), titleTF));
        this.add(new VerticalLayout(new Label("Enter author: "), authorTF));

        Button addBook = new Button(new Icon(VaadinIcon.PLUS), c -> add());
        check = new Checkbox("Return home after add");

        add(addBook, check);

    }

    private void add() {

        //parsing author name
        String title = titleTF.getValue();

        String[] author = authorTF.getValue().trim().split(" ");
        Book book = new Book(author[author.length - 1], title, author[0]);
        service.addNewBook(book);
        titleTF.clear();
        authorTF.clear();
        if (check.getValue().equals(true)){
            navigateToHome();
        }
    }



}
