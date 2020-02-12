package fr.easysoft.myboutique.presentation.ui.components.product.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.easysoft.myboutique.App
import fr.easysoft.myboutique.model.Product
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class ProductsViewModel : ViewModel() {
    val metier = App.metier;
    var products = MutableLiveData<List<Product>>();
    var productsDisposable = CompositeDisposable();

    fun getAllProducts(): LiveData<List<Product>> {
        productsDisposable.add(metier.listProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { it -> Timber.i("[ getAllProducts ] fetch all products");
                    products.value = it;
                },
                {
                    error -> Timber.e("[ getAllProduits ] Error: ${error}")
                }
            )
        );

        return products;
    }

    fun disposeAllDisposable() {
        productsDisposable.dispose();
    }
}