package fr.easysoft.myboutique.presentation.ui.components.product.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProductDetailViewModelFactory(private val productId: Long)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductDetailViewModel(productId) as T;
    }
}