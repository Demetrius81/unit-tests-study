package org.example.homeWork.book;

public class Book {
    private String id;
    private String title;
    private String author;

    public Book(String id) {
        this.id = id;
    }

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Переопределил метод equals

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Book book = (Book) obj;

        return book.id.equals(this.id) && book.author.equals(this.author) && book.title.equals(this.title);
    }

    public boolean equals(Book book) {
        if (book == null) {
            return false;
        }

        if (book == this) {
            return true;
        }

        return book.id.equals(this.id) && book.author.equals(this.author) && book.title.equals(this.title);
    }
}
