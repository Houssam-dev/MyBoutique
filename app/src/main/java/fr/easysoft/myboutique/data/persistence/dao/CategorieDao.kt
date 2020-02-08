package fr.easysoft.myboutique.data.persistence.dao

import androidx.room.*
import fr.easysoft.myboutique.model.Categorie
import fr.easysoft.myboutique.model.CategoriesWithProducts
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface CategorieDao : CommonDao<Categorie> {

    @Query(value = "SELECT * FROM Categorie")
    override fun findAll(): Observable<List<Categorie>>;

    @Query(value = "SELECT * FROM Categorie WHERE categorie_id = :id")
    override fun findById(id: Long): Observable<Categorie>;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun saveAll(vararg item: Categorie): Completable;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun save(obj: Categorie): Completable;

    @Delete
    override fun delete(obj: Categorie): Completable;

    @Query(value = "DELETE FROM Categorie")
    override fun deleteAll(): Completable;

    @Query(value = "DELETE FROM Categorie WHERE categorie_id = :id")
    override fun deleteById(id: Long): Completable;

    @Query(value = "SELECT COUNT(categorie_id) FROM Categorie")
    override fun count(): Long;

    //////////////////////////////////////
    // TRANSACTIONS
    @Transaction
    @Query(value = "SELECT * FROM Categorie")
    fun getCategoriesWithProducts(): Observable<List<CategoriesWithProducts>>;
}