package com.app.spring.views;

import com.app.spring.data.Book;
import com.app.spring.implementation.BookService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridSingleSelectionModel;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Route()
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class MainView extends VerticalLayout {


    @Autowired
    private BookService bookList;

    private Button searchForCustomers;
    private VerticalLayout bookLayout;

    private Grid<Book> grid;


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


        grid = new Grid<>(Book.class);

        List<Book> customers = bookList.findAll();


        grid.setItems(customers);


      //  grid.addItemDoubleClickListener(e -> setBookDetailsView(grid.getSelectionModel().getFirstSelectedItem()));


        bookLayout.add(grid);
        add(bookLayout);


    }

    private void navigateToAddNewBook() {
        Optional optional = getUI();
        if (optional.isPresent()) {
            getUI().get().navigate("add");
        }
    }


    private void setBookDetailsView(Optional<Book> bookSet) {
        removeAll();

        if (bookSet.isPresent()) {
            add(new Label(bookSet.toString()));
        }
    }


}
