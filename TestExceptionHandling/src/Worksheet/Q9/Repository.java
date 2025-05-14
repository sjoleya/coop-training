package Worksheet.Q9;

import java.sql.SQLException;

class Repository {
    public void getData() throws SQLException {
        throw new SQLException("Database connection failed");
    }
}
