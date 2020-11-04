package android.eservices.webrequests.data.repository.bookdisplay;

import android.eservices.webrequests.data.api.model.BookSearchResponse;
import android.eservices.webrequests.data.database.BookEntity;
import android.eservices.webrequests.data.repository.bookdisplay.local.BookDisplayLocalDataSource;
import android.eservices.webrequests.data.repository.bookdisplay.remote.BookDisplayRemoteDataSource;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

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
        return null;
    }

    @Override
    public Completable insertBook(String id) {
        return null;
    }

    @Override
    public Completable deleteBook(String id) {
        return null;
    }
}
