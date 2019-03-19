package com.app.spring.views;

import com.app.spring.data.Book;
import com.app.spring.implementation.BookService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Route()
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class MainView extends VerticalLayout {


    @Autowired
    private BookService bookList;

    private Button searchForCustomers;
    private VerticalLayout bookLayout;


    public MainView() {


        setupLayout();

    }

    private void setupLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        bookLayout = new VerticalLayout();

        Label label = new Label("Welcome in basic CRUD application using Spring and Vaadin!");
        label.setHeight("20");

        Button searchForCustomers = new Button("Browse library", click -> searchBooks());

        Button addNewCustomer = new Button("Add new book", click -> navigateToAddNewBook());

        layout.add(searchForCustomers, addNewCustomer);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setAlignItems(Alignment.CENTER);


        this.add(label, layout, bookLayout);


    }

    private void searchBooks() {
        remove(bookLayout);
        bookLayout.removeAll();


        Grid<Book> grid = new Grid<>(Book.class);

        List<Book> customers = bookList.findAll();


        grid.setItems(customers);
//        Grid.Column<Book> titleColumn = grid.addColumn(Book::getTitle).setHeader("Title").setWidth("25%");
//        Grid.Column<Book> firstNameCol = grid.addColumn(Book::getAuthorFirstName).setHeader("Author first name").setWidth("33%");
//        Grid.Column<Book> lastNameCol = grid.addColumn(Book::getAuthorLastName).setHeader("Author last name").setWidth("25%");

        grid.addItemDoubleClickListener(e -> getDetailsOfBook());


        bookLayout.add(grid);
        add(bookLayout);


    }

    private void navigateToAddNewBook() {
        Optional optional = getUI();
        if (optional.isPresent()) {
            getUI().get().navigate("add");
        }
    }

    private void getDetailsOfBook() {
        Optional o = getUI();
        if (o.isPresent()) {
            getUI().get().navigate("book");
        }
    }


}
