package android.eservices.webrequests.presentation.viewmodel;

import android.eservices.webrequests.data.repository.bookdisplay.BookDisplayRepository;
import android.eservices.webrequests.presentation.bookdisplay.favorite.adapter.BookDetailViewItem;
import android.eservices.webrequests.presentation.bookdisplay.favorite.mapper.BookEntityToDetailViewModelMapper;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class BookFavoriteViewModel extends ViewModel {

    private BookDisplayRepository bookDisplayRepository;
    // Composite
    private CompositeDisposable compositeDisposable;
    private BookEntityToDetailViewModelMapper bookEntityToDetailViewModelMapper;

    public BookFavoriteViewModel(BookDisplayRepository bdr) {
        this.bookDisplayRepository = bdr;
        this.compositeDisposable = new CompositeDisposable();
        this.bookEntityToDetailViewModelMapper = new BookEntityToDetailViewModelMapper();
    }


    private MutableLiveData<List<BookDetailViewItem>> favs; // adapter de favorite
    public MutableLiveData<List<BookDetailViewItem>> getFavorites() {return favs;}

    private MutableLiveData<Boolean> isDataLoading = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> getIsDataLoading() { return isDataLoading;}

    // Add Fav
    public void addToFavorite(String id){
        compositeDisposable.add(bookDisplayRepository.insertBook(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        System.out.println("========> Add to favorite");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.toString());
                    }
                })
        );
    }

    // Delete Fav
    public void removeFromFavorite(String id){
        compositeDisposable.add(bookDisplayRepository.deleteBook(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        System.out.println("========> Remove From favorite");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.toString());
                    }
                })
        );
    }
}
