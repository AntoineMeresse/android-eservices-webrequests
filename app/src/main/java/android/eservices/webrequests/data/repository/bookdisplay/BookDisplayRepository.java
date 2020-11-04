package android.eservices.webrequests.data.repository.bookdisplay;

import android.eservices.webrequests.data.api.model.BookSearchResponse;
import android.eservices.webrequests.data.database.BookEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public interface BookDisplayRepository {
    // Remote
    Single<BookSearchResponse> getBookSearchResponse(String keywords);

    // Local
    Flowable<List<BookEntity>> getFavoriteBooks();
    Completable insertBook(String id);
    Completable deleteBook(String id);
}
