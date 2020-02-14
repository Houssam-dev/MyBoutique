package fr.easysoft.myboutique.presentation.ui.components.product.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.easysoft.myboutique.App
import fr.easysoft.myboutique.model.Product
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class ProductDetailViewModel(productId: Long) : ViewModel() {


    var metier = App.metier;
    var product = MutableLiveData<Product>();
    var productDetailDisposable = CompositeDisposable();

    fun getProduct(productId: Long): LiveData<Product> {
        productDetailDisposable.add(metier.getProduct(productId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { it -> product.value = it},
                { error -> Timber.e("[ getProduct ] error: ${error}")}
            )
        );

        return product;
    }

    fun disposeAllDisposable() {
        productDetailDisposable.dispose();
    }
}