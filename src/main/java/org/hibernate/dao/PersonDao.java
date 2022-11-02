package org.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        if(session == null) {
            sessionFactory.openSession();
        }
        return session;
    }

    public void savePerson(Person person) {
        getSession().save(person);
    }

    @SuppressWarnings("unchecked")
    public List<Person> getPeople() {
        return getSession().createCriteria(Person.class).list();
    }
}
