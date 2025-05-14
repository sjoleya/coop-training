package Worksheet.Q9;

import java.sql.SQLException;

class Service {
    private Repository repository = new Repository();

    public void processData() throws ServiceLayerException {
        try {
            repository.getData();
        } catch (SQLException e) {
            throw new ServiceLayerException("Failed to process data", e);
        }
    }
}
