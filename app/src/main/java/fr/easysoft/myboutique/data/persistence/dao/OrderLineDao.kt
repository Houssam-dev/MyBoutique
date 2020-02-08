package fr.easysoft.myboutique.data.persistence.dao

import androidx.room.*
import fr.easysoft.myboutique.model.OrderLine
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface OrderLineDao : CommonDao<OrderLine> {

    @Query(value = "SELECT * FROM OrderLine")
    override fun findAll(): Observable<List<OrderLine>>;

    @Query(value = "SELECT * FROM OrderLine WHERE orderline_id = :id")
    override fun findById(id: Long): Observable<OrderLine>;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun saveAll(vararg item: OrderLine): Completable;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun save(obj: OrderLine): Completable;

    @Delete
    override fun delete(obj: OrderLine): Completable;

    @Query(value = "DELETE FROM OrderLine")
    override fun deleteAll(): Completable;

    @Query(value = "DELETE FROM OrderLine WHERE orderline_id = :id")
    override fun deleteById(id: Long): Completable;

    @Query(value = "SELECT COUNT(orderline_id) FROM OrderLine")
    override fun count(): Long;
}