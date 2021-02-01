package com.hcl.login.user;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        Configuration conf= new Configuration();

        conf.addAnnotatedClass(User.class);

        conf.configure("hibernate.cfg.xml");
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(
                        conf.getProperties()
                ).build();

        sessionFactory = conf.buildSessionFactory(registry);
        return sessionFactory;
    }
}
