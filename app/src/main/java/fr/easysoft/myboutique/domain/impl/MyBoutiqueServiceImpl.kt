package fr.easysoft.myboutique.domain.impl

import fr.easysoft.myboutique.App
import fr.easysoft.myboutique.data.persistence.dao.CategorieDao
import fr.easysoft.myboutique.data.persistence.dao.ProductDao
import fr.easysoft.myboutique.domain.MyBoutiqueService
import fr.easysoft.myboutique.model.Categorie
import fr.easysoft.myboutique.model.Product
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


data class MyBoutiqueServiceImpl(
    private var categorieDao: CategorieDao = App.db.getCategorieDao(),
    private var productDao: ProductDao = App.db.getProductDao(),
    var userDisposable: CompositeDisposable = CompositeDisposable()
) : MyBoutiqueService {

    init {
        insertFakeData();
    }

    private fun insertFakeData() {

        var listProductsForElectromenager = mutableListOf<String>(
            "LG Lave Linge",
            "Nespresso Café",
            "Whirlpool Micro ondes",
            "Bosh refrigerateur"
        );

        var listProductsForMultimedia = mutableListOf<String>(
            "Samsung SmartTv",
            "Thomson Tv",
            "Iphone X",
            "Iphone 6S",
            "HP Notebook",
            "Samsung Tablet S"
        );

        var productsElectromenager = mutableListOf<Product>();
        var productsMutlimedia = mutableListOf<Product>();

        listProductsForElectromenager
            .forEachIndexed { index, value ->
                productsElectromenager.add(
                    Product(
                        index.toLong(),
                        "name: ${value}",
                        "designation: ${value}",
                        (120 + Math.random()).toDouble(),
                        false,
                        "${value}_photo.jpg",
                        (20 + Math.random()).toInt(),
                        1L
                    )
                )
            }

        listProductsForMultimedia
            .forEachIndexed { index, value ->
                productsMutlimedia.add(
                    Product(
                        index.toLong(),
                        "name: ${value}",
                        "designation: ${value}",
                        (120 + Math.random()).toDouble(),
                        false,
                        "${value}_photo.jpg",
                        (20 + Math.random()).toInt(),
                        2L
                    )
                )
            }

        userDisposable.add(categorieDao.save(Categorie(1L, "Electromenager", "home appliance"))
            .subscribeOn(Schedulers.io())
            .andThen(
                Observable.fromIterable(productsElectromenager)
                    .concatMapCompletable { product -> productDao.save(product) }
                    .subscribeOn(Schedulers.io())
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Timber.i(">>>>>>> All products Electromenager added")},
                { error -> Timber.e("Error: ${error}")}
            )
        )

        userDisposable.add(categorieDao.save(Categorie(2L, "Multimedia", "devices high tech"))
            .subscribeOn(Schedulers.io())
            .andThen(
                Observable.fromIterable(productsMutlimedia)
                    .concatMapCompletable { product -> productDao.save(product) }
                    .subscribeOn(Schedulers.io())
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Timber.i(">>>>>>> All products Multimedia added")},
                { error -> Timber.e("Error: ${error}")}
            )
        )
    }

    override fun getCategorie(id: Long): Observable<Categorie> {
        return categorieDao.findById(id);
    }

    override fun listCategories(): Observable<List<Categorie>> {
        return categorieDao.findAll();
    }

    override fun getProduct(id: Long): Observable<Product> {
        return productDao.findById(id);
    }

    override fun productsByKeyword(keyword: String): Observable<List<Product>> {
        return productDao.findByKeyword(keyword);
    }

    override fun listProducts(): Observable<List<Product>> {
        return productDao.findAll();
    }

    override fun productsByCategorie(id: Long): Observable<List<Product>> {
        return productsByCategorie(id);
    }

    override fun disposeAllDisposable() {
        userDisposable.dispose();
    }
}
