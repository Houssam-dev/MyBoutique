package fr.easysoft.myboutique.data.persistence.dao

import androidx.room.*
import fr.easysoft.myboutique.model.User
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface UserDao : CommonDao<User> {

    @Query(value = "SELECT * FROM User")
    override fun findAll(): Observable<List<User>>;

    @Query(value = "SELECT * FROM User WHERE user_id = :id")
    override fun findById(id: Long): Observable<User>;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun saveAll(vararg item: User): Completable;

    @Insert
    override fun save(obj: User): Completable;

    @Delete
    override fun delete(obj: User): Completable;

    @Query(value = "DELETE FROM User")
    override fun deleteAll(): Completable;

    @Query(value = "DELETE FROM User WHERE user_id = :id")
    override fun deleteById(id: Long): Completable;

    @Query(value = "SELECT COUNT(user_id) FROM User")
    override fun count(): Long;
}