package ru.job4j.lsp.third;

import java.util.List;

public class Library {
    private List<Reader> readers;
    private List<Reader.Book> books;

    protected void checkReader(Reader reader, Reader.Book book) throws Exception {
        if (!books.contains(book)) {
            throw new Exception("Library has no such a book.");
        } else if (!readers.contains(reader)) {
            throw new Exception("This reader was not registered in the library.");
        } else if (reader.getBooksBorrowed().size() > 5) {
            throw new Exception("This reader borrowed more then 5 books, so it is restricted to get another one.");
        } else if (reader.getBooksBorrowed().contains(book)) {
            throw new Exception("This reader has borrowed this book already.");
        } else {
            getBook(reader, book);
        }
    }

    void getBook(Reader reader, Reader.Book book) {
         reader.getBooksBorrowed().add(book);
    }
}
