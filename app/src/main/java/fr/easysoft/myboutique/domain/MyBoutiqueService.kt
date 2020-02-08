package fr.easysoft.myboutique.domain

import fr.easysoft.myboutique.model.Categorie
import fr.easysoft.myboutique.model.Product
import io.reactivex.Observable

interface MyBoutiqueService {

    fun getCategorie(id: Long): Observable<Categorie>;

    fun listCategories(): Observable<List<Categorie>>;

    // TODO pagination instead of lists

    fun getProduct(id: Long): Observable<Product>;

    fun productsByKeyword(keyword: String): Observable<List<Product>>;

    fun listProducts(): Observable<List<Product>>;

    fun productsByCategorie(id: Long): Observable<List<Product>>;

    // TODO productsSelected: Observable<List<Product>>;

    // TODO fun saveOrder(cart: Cart, client: Client): Completable

    fun disposeAllDisposable();
}