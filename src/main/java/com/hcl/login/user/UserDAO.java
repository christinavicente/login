package com.hcl.login.user;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import org.springframework.data.jpa.provider.HibernateUtils;

public class UserDAO {

    public void saveUser(User user){
        Transaction transaction=null;

        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(user);
            transaction.commit();
        }catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public boolean validate(String userName, String password){
        boolean result =false;
        Transaction transaction=null;
        User user;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            user=(User)session.createQuery("From User U WHERE U.userName = :userName")
                    .setParameter("username",userName).uniqueResult();
            if((user !=null)&&(user.getPassword().equals(password))){
                result=true;
            }
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }


}
