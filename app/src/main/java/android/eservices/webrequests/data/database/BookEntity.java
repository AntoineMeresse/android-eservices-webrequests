package android.eservices.webrequests.data.database;

import android.eservices.webrequests.data.api.model.BookInfo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "books_entity")
public class BookEntity {
    @PrimaryKey
    public String id;

    @ColumnInfo(name = "volume_info")
    private BookInfo volumeInfo;

    @ColumnInfo(name = "is_favorite")
    private boolean isFavorite;
}
