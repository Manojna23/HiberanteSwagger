package org.hibernate.service;

import org.hibernate.dao.PersonDao;
import org.hibernate.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public void save(Person p) {
        personDao.savePerson(p);
    }

    public List<Person> getPeople()  {
        return personDao.getPeople();
    }
}
