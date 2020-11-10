package android.eservices.webrequests.data.repository.bookdisplay;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.database.BookEntity;

import java.util.List;

public class BookToBookEntityMapper {

    public static BookEntity convertBook(Book book){
        BookEntity res = new BookEntity();
        res.setId(book.getId()); // id

        // Volume Infos
        res.setTitle(book.getVolumeInfo().getTitle()); // title
        res.setUrlImage(book.getVolumeInfo().getImageLinks().getSmallThumbnail()); // url
        res.setDescription(book.getVolumeInfo().getDescription()); // description

        String authors_infos = "Inconnu";
        List<String> authors = book.getVolumeInfo().getAuthorList();
        if(authors != null){
            authors_infos = "";
            for (int i = 0; i< authors.size(); i++) {
                authors_infos += authors.get(i);
                if (i != authors.size()-1) {
                    authors_infos += ",";
                }
            }
        }
        res.setAuthors(authors_infos); // authors

        return res;
    }
}
