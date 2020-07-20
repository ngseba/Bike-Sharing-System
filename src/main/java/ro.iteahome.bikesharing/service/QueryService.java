package ro.iteahome.bikesharing.service;

import ro.iteahome.bikesharing.dao.QueryDAO;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Query;

public class QueryService {
    public void printQuery(Query query) throws BikeSharingTechnicalException {
        QueryDAO queryDAO = new QueryDAO();
        queryDAO.writeQuery(query);
    }
}
