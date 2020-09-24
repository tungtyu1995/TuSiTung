package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.Service;
import org.hibernate.Session;
import org.springframework.context.annotation.Bean;

import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

public class HibernateCustomerServiceImpl implements CustomerService {

    @Bean
    public CustomerService customerService() {
        return new HibernateCustomerServiceImpl();
    }

//    @Override
//    public List<Customer> findAll() {
//        return Collections.emptyList();
//    }

    @Override
    public List<Customer> findAll() {
        Session session = null;
        List<Customer> studentList = null;
        try {
            session = Service.sessionFactory.openSession();
            studentList = session.createQuery("FROM Customer").getResultList();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return studentList;
    }

    @Override
    public Customer findOne(Long id) {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return Collections.emptyList();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public void delete(Customer customer) {
    }

    @Override
    public void delete(List<Customer> customers) {
    }

    @Override
    public void deleteAll() {
    }
}
