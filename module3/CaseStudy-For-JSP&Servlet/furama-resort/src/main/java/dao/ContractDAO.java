package dao;

import model.Contract;

import java.util.List;

public interface ContractDAO {
    List<Contract> findAll();
    void add(Contract contract);
}
