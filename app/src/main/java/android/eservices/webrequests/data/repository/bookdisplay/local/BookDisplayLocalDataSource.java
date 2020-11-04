package android.eservices.webrequests.data.repository.bookdisplay.local;

import android.eservices.webrequests.data.database.BookDAO;
import android.eservices.webrequests.data.database.BookDatabase;
import android.eservices.webrequests.data.database.BookEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class BookDisplayLocalDataSource {

    private BookDatabase bookDatabase;
    private BookDAO bookDAO;

    public BookDisplayLocalDataSource(BookDatabase bookDatabase){
        this.bookDatabase = bookDatabase;
        this.bookDAO = bookDatabase.bookDAO();
    }

    // getFavoriteBooks
    public Flowable<List<BookEntity>> getFavoriteBooks() { return this.bookDAO.getFavoriteBooks();}

    // insertBook
    public Completable insertBook(BookEntity bookEntity) { return this.bookDAO.insertBook(bookEntity);}

    // deleteBook
    public Completable deleteBook(BookEntity bookEntity) { return this.bookDAO.deleteBook(bookEntity);}
}
