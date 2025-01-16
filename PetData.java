package Project_Java;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

public class PetData {

    public static String displayPets() {
    	String SCHEMA_NAME = null;  // Set schema name if required
        StringBuilder builder = new StringBuilder();

        try (Connection connection = DatabaseConnection.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData(); // Get metadata of the database
            String[] tableType = {"TABLE"}; // Filters to get only tables 

            // Get tables in the schema
            try (ResultSet tables = metaData.getTables(null, SCHEMA_NAME, null, tableType)) {
                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME"); // Get the name of the current table
                    
                    if(!tableName.equalsIgnoreCase("Pets")) {
                    	continue;
                    }
                    
                    builder.append("Table: ").append(tableName).append("\n");
                    
                    // Fetch and display data from the table
                    try (Statement stmt = connection.createStatement();
                         ResultSet data = stmt.executeQuery("SELECT * FROM " + tableName)) {

                        int columnCount = data.getMetaData().getColumnCount(); // Get number of columns
                        boolean hasData = false; // Flag to check if any data exists

                        // Loop through rows in the result set
                        while (data.next()) {
                            hasData = true;
                            // Loop through columns in the row
                            for (int i = 1; i <= columnCount; i++) {
                                builder.append(data.getString(i)).append("\t"); // Append column data to builder
                            }
                            builder.append("\n"); // Newline after each row
                        }

                        if (!hasData) {
                            builder.append("No data found.\n"); // No data found message
                        }

                    } catch (Exception e) {
                        builder.append("Error retrieving data from ").append(tableName)
                               .append(": ").append(e.getMessage()).append("\n");
                    }
                }
            }

            System.out.println(builder.toString()); // Print the entire builder content

        } catch (Exception e) {
            System.out.println("Error accessing database: " + e.getMessage()); // Handle connection errors
        }
		return builder.toString();
    }
}
