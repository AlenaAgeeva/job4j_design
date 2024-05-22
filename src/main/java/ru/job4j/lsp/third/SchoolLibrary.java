package ru.job4j.lsp.third;

public class SchoolLibrary extends Library {
    @Override
    protected void checkReader(Reader reader, Reader.Book book) {
        super.getBook(reader, book);
    }
}
