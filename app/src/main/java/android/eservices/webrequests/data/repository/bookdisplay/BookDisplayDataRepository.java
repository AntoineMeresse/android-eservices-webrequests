package android.eservices.webrequests.data.repository.bookdisplay;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;
import android.eservices.webrequests.data.database.BookEntity;
import android.eservices.webrequests.data.repository.bookdisplay.local.BookDisplayLocalDataSource;
import android.eservices.webrequests.data.repository.bookdisplay.remote.BookDisplayRemoteDataSource;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

// Demander au local ou au remote
public class BookDisplayDataRepository implements BookDisplayRepository {

    private BookDisplayRemoteDataSource bookDisplayRemoteDataSource;
    private BookDisplayLocalDataSource bookDisplayLocalDataSource;

    public BookDisplayDataRepository(BookDisplayRemoteDataSource bookDisplayRemoteDataSource, BookDisplayLocalDataSource bookDisplayLocalDataSource){
        this.bookDisplayRemoteDataSource = bookDisplayRemoteDataSource;
        this.bookDisplayLocalDataSource = bookDisplayLocalDataSource;
    }

    @Override
    public Single<BookSearchResponse> getBookSearchResponse(String keywords) {
        return bookDisplayRemoteDataSource.searchBooks(keywords);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public Flowable<List<BookEntity>> getFavoriteBooks() {
        return bookDisplayLocalDataSource.getFavoriteBooks();
    }

    @Override
    public Completable insertBook(String id) {
        // Etape 1 :
        Single<Book> book = bookDisplayRemoteDataSource.getBook(id);

        // Etape 2 :
        Single<BookEntity> bookEntitySingle = book.map(new Function<Book, BookEntity>() {
            @Override
            public BookEntity apply(Book book) throws Exception {
                // Conversion : Appel au mapper
                return null;
            }
        });

        // Etape 3 :
        Completable bookCompletable = bookEntitySingle.flatMapCompletable(new Function<BookEntity, CompletableSource>() {
            @Override
            public CompletableSource apply(BookEntity bookEntity) throws Exception {
                return bookDisplayLocalDataSource.insertBook(bookEntity);
            }
        });

        return bookCompletable;
    }

    @Override
    public Completable deleteBook(String id) {
        return null;
    }
}
