Create table if not exists Book (id IDENTITY primary key , title varchar (255), author_first_name varchar (255), author_last_name varchar (255));

insert into Book (title, author_first_name, author_last_name)
 values ( 'Ferdydurke', 'Witold', 'Gombrowicz'),
        ('Kasacja', 'Remigiusz', 'Mróz');

