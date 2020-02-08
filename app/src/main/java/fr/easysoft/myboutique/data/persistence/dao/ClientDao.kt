package fr.easysoft.myboutique.data.persistence.dao

import androidx.room.*
import fr.easysoft.myboutique.model.Client
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface ClientDao : CommonDao<Client> {

    @Query(value = "SELECT * FROM Client")
    override fun findAll(): Observable<List<Client>>;

    @Query(value = "SELECT * FROM Client WHERE client_id = :id")
    override fun findById(id: Long): Observable<Client>;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun saveAll(vararg item: Client): Completable;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun save(obj: Client): Completable;

    @Delete
    override fun delete(obj: Client): Completable;


    @Query(value = "DELETE FROM Client")
    override fun deleteAll(): Completable;

    @Query(value = "DELETE FROM Client WHERE client_id = :id")
    override fun deleteById(id: Long): Completable;

    @Query(value = "SELECT COUNT(client_id) FROM Client")
    override fun count(): Long;
}