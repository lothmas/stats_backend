package com.stats.utilities;

import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kwk
 * @param <E>
 * @param <I>
 */
public interface AbstractDao<E, I extends Serializable> {

    /**
     *
     * @param id
     * @return
     */
    E findById(I id);

    /**
     *
     * @param e
     */
    void saveOrUpdate(E e);
//    boolean saveObject(E e);

    void delete(E e);

    void saveOrUpdateForTransaction(E e);

    void merge(E e);

    /**
     *
     * @param criterion
     * @return
     */
    List<E> findByCriteria(Criterion criterion);

    public void beginTransaction();

    /**
     *
     */
    public void transactionCommit();

    /**
     *
     */
    public void transactionRollBack();

    public Transaction getTransaction();

}
