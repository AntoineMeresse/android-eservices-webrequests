package android.eservices.webrequests.data.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface BookDAO {

    @Query("SELECT * FROM books_entity")
    Flowable<List<BookEntity>> getFavoriteBooks();

    @Insert
    Completable insertBook(BookEntity bookEntity);

    @Delete
    Completable deleteBook(BookEntity bookEntity);

    @Query("SELECT id FROM books_entity")
    Single<List<String>> getIdFavoriteBooks();
}
