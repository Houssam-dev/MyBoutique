package fr.easysoft.myboutique.data.persistence.dao

import io.reactivex.Completable
import io.reactivex.Observable

interface CommonDao<T> {

    fun findAll(): Observable<List<T>>;

    fun findById(id: Long): Observable<T>;

    fun saveAll(vararg item: T): Completable;

    fun save(obj: T): Completable;

    fun delete(obj: T): Completable;

    fun deleteAll(): Completable;

    fun deleteById(id: Long): Completable;

    fun count(): Long;
}