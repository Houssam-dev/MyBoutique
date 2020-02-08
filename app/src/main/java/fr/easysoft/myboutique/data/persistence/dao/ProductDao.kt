package fr.easysoft.myboutique.data.persistence.dao

import androidx.room.*
import fr.easysoft.myboutique.model.Product
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface ProductDao : CommonDao<Product> {

    @Query(value = "SELECT * FROM Product")
    override fun findAll(): Observable<List<Product>>;

    @Query(value = "SELECT * FROM Product WHERE product_id = :id")
    override fun findById(id: Long): Observable<Product>;

    @Query(value = "SELECT * FROM Product WHERE designation LIKE :keyword")
    fun findByKeyword(keyword: String): Observable<List<Product>>;

    @Query(value = "SELECT * FROM Product WHERE CAT_ID = :categorieId")
    fun findByCategorie(categorieId: Long): Observable<List<Product>>;

    // TODO write method to find all products selected
    // @Query(value = "SELECT * FROM Produit WHERE selected = true or 'true'?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun saveAll(vararg item: Product): Completable;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun save(obj: Product): Completable;

    @Delete
    override fun delete(obj: Product): Completable;

    @Query(value = "DELETE FROM Product")
    override fun deleteAll(): Completable;

    @Query(value = "DELETE FROM Product WHERE product_id = :id")
    override fun deleteById(id: Long): Completable;

    @Query(value = "SELECT COUNT(product_id) FROM Product")
    override fun count(): Long;
}