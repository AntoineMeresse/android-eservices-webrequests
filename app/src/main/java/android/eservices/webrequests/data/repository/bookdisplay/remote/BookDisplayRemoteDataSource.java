package android.eservices.webrequests.data.repository.bookdisplay.remote;

import android.eservices.webrequests.BookApplication;
import android.eservices.webrequests.data.api.BookDisplayService;
import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;

import io.reactivex.Single;

public class BookDisplayRemoteDataSource {

    private BookDisplayService bookDisplayService;

    public BookDisplayRemoteDataSource(BookDisplayService bookDisplayService) {
        this.bookDisplayService = bookDisplayService;
    }

    public Single<Book> getBook(String id) {
        return this.bookDisplayService.getBook(id, BookApplication.API_KEY);
    }

    public Single<BookSearchResponse> searchBooks(String keywords){
        return this.bookDisplayService.searchBooks(keywords, BookApplication.API_KEY);
    }
}
