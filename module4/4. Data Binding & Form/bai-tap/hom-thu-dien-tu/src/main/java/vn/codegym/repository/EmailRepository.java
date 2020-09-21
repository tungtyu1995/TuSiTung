package vn.codegym.repository;

import vn.codegym.model.Email;

import java.util.List;

public interface EmailRepository extends Repository<Email> {

    List<String> getLanguage();
    List<String> getPageSize();
}
