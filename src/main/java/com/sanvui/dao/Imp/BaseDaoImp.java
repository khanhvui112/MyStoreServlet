package com.sanvui.dao.Imp;

import com.sanvui.dao.BaseDao;
import com.sanvui.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author: VuiSK
 * @created: 05/11/2021-11:35 AM
 * @mailto: sanvankhanh@gmail.com
 */

public class BaseDaoImp<T> implements BaseDao<T> {
    private Class<T> classTyper;
    public BaseDaoImp(Class<T> classTyper) {
        this.classTyper = classTyper;
    }


    /*
     * find all
     * request: List object
     * */
    @Override
    public List findAll() {
        try (Session session = HibernateUtils.getSession()){
            return session.createQuery("FROM "+classTyper.getName(),this.classTyper).list();
        }
    }

    /*
     * find by id
     * param: int id
     * request: a object
     * */
    @Override
    public T findById(int id) {

        try (Session session = HibernateUtils.getSession()){
            return session.get(this.classTyper,id);
        }
    }

    /*
     * insert to database
     * param: List<Object>
     * if success return true else rollback and return false
     */
    @Override
    public boolean insert(List<T> list) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();
            for (T t : list){
                session.save(t);
            }
            transaction.commit();
            return true;
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            return false;
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }

    /*
     * delete object by id
     * if success return true else return false
     *
     * */
    @Override
    public boolean delete(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();
            T t = session.load(this.classTyper, id);
            if(t!= null){
                session.delete(t);
            }
            transaction.commit();
            return true;
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            return false;
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }

    /*
     * update object
     * param: a object
     * if success return true else rollback and return false
     * */
    @Override
    public boolean update(List<T> list) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();
            for (T t : list){
                session.update(t);
            }
            transaction.commit();
            return true;
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            return false;
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }
}
