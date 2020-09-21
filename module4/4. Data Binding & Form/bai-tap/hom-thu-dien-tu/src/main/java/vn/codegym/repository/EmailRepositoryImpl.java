package vn.codegym.repository;

import vn.codegym.model.Email;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailRepositoryImpl implements EmailRepository {

    private static final Map<Integer, Email> emails;

    static {
        emails = new HashMap<>();
        emails.put(1, new Email(1, "English", "10", "Enable", "King"));
        emails.put(2, new Email(2, "Vietnamese", "15", "Enable", "King"));
        emails.put(3, new Email(3, "Japanese", "25", "Enable", "King"));
    }

    @Override
    public List<String> getLanguage() {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        return languageList;
    }

    @Override
    public List<String> getPageSize() {
        List<String> pageSizeList = new ArrayList<>();
        pageSizeList.add("5");
        pageSizeList.add("10");
        pageSizeList.add("15");
        pageSizeList.add("25");
        pageSizeList.add("50");
        pageSizeList.add("100");
        return pageSizeList;
    }

    @Override
    public List<Email> findAll() {
        return new ArrayList<>(emails.values());
    }

    @Override
    public void save(Email email) {
        emails.put(email.getId(), email);
    }


    @Override
    public void delete(int id) {
        emails.remove(id);
    }

    @Override
    public Email findById(int id) {
        return emails.get(id);
    }
}
