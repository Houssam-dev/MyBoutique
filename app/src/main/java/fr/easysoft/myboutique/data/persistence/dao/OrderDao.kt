package fr.easysoft.myboutique.data.persistence.dao

import androidx.room.*
import fr.easysoft.myboutique.model.Order
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface OrderDao : CommonDao<Order> {

    @Query(value = "SELECT * FROM `Order`")
    override fun findAll(): Observable<List<Order>>;

    @Query(value = "SELECT * FROM `Order` WHERE order_id = :id")
    override fun findById(id: Long): Observable<Order>;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun saveAll(vararg item: Order): Completable;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun save(obj: Order): Completable;

    @Delete
    override fun delete(obj: Order): Completable;

    @Query(value = "DELETE FROM `Order`")
    override fun deleteAll(): Completable;

    @Query(value = "DELETE FROM `Order` WHERE order_id = :id")
    override fun deleteById(id: Long): Completable;

    @Query(value = "SELECT COUNT(order_id) FROM `Order`")
    override fun count(): Long;
}