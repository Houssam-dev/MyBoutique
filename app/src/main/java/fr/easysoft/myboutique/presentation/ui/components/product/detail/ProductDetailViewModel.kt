package fr.easysoft.myboutique.presentation.ui.components.product.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.easysoft.myboutique.App
import fr.easysoft.myboutique.model.Product
import io.reactivex.disposables.CompositeDisposable

class ProductDetailViewModel(productId: Long) : ViewModel() {
    var metier = App.metier;
    var product = MutableLiveData<Product>();
    var productDetailDisposable = CompositeDisposable();


}