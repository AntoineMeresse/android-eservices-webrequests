package android.eservices.webrequests.data.api;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BookDisplayService {
    @GET("volumes/{id}")
    Single<Book> getBook(@Path("id") String id, @Path("key") String apikey);

    @GET("volumes")
    Single<BookSearchResponse> searchBooks(@Path("q") String keyWords, @Query("key") String apikey);
}
