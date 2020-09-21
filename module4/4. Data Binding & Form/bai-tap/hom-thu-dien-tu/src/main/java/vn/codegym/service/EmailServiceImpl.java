package vn.codegym.service;

import vn.codegym.model.Email;
import vn.codegym.repository.EmailRepository;
import vn.codegym.repository.EmailRepositoryImpl;

import java.util.List;

public class EmailServiceImpl implements EmailService {

    EmailRepository emailRepository = new EmailRepositoryImpl();
    @Override
    public List<String> getLanguage() {
        return this.emailRepository.getLanguage();
    }

    @Override
    public List<String> getPageSize() {
        return this.emailRepository.getPageSize();
    }

    @Override
    public List<Email> findAll() {
        return this.emailRepository.findAll();
    }

    @Override
    public void save(Email email) {
        this.emailRepository.save(email);
    }

    @Override
    public void delete(int id) {
        this.emailRepository.delete(id);
    }

    @Override
    public Email findById(int id) {
        return this.emailRepository.findById(id);
    }
}
