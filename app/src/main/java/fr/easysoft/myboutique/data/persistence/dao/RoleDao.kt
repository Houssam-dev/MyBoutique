package fr.easysoft.myboutique.data.persistence.dao

import androidx.room.*
import fr.easysoft.myboutique.model.Role
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface RoleDao : CommonDao<Role> {

    @Query(value = "SELECT * FROM Role")
    override fun findAll(): Observable<List<Role>>;

    @Query(value = "SELECT * FROM Role WHERE role_id = :id")
    override fun findById(id: Long): Observable<Role>;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun saveAll(vararg item: Role): Completable;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun save(obj: Role): Completable;

    @Delete
    override fun delete(obj: Role): Completable;

    @Query(value = "DELETE FROM Role")
    override fun deleteAll(): Completable;

    @Query(value = "DELETE FROM Role WHERE role_id = :id")
    override fun deleteById(id: Long): Completable;

    @Query(value = "SELECT COUNT(role_id) FROM Role")
    override fun count(): Long;
}