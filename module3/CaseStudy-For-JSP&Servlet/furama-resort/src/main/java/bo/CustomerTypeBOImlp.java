package bo;

import dao.CustomerTypeDAO;
import dao.CustomerTypeDAOImpl;
import model.CustomerType;

import java.util.List;

public class CustomerTypeBOImlp implements CustomerTypeBO {
    CustomerTypeDAO customerTypeDAO = new CustomerTypeDAOImpl();
    @Override
    public List<CustomerType> findAll() {
        return this.customerTypeDAO.findAll();
    }
}
