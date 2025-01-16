package Project_Java;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Get_Average {
	
    // Method to calculate and display the average age of pets in months
    public static String displayAverageAge() throws SQLException {
        String SCHEMA_NAME = null;  // Schema name for database metadata
        StringBuilder builder = new StringBuilder();

        try (Connection connection = DatabaseConnection.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            String[] tableType = {"TABLE"}; 

            // Retrieve list of tables in the database
            try (ResultSet tables = metaData.getTables(null, SCHEMA_NAME, null, tableType)) {
                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");

                    // Skip tables other than "Pets"
                    if (!tableName.equalsIgnoreCase("Pets")) {
                        continue;
                    }

                    builder.append("Table: ").append(tableName).append("\n");

                    // Fetch data from the "Pets" table
                    try (Statement stmt = connection.createStatement()){
                         ResultSet data = stmt.executeQuery("SELECT * FROM " + tableName); 

                        int columnCount = data.getMetaData().getColumnCount();
                        boolean hasData = false;
                        double total = 0;
                        int rowCount = 0;

                        // Calculate the average age of pets
                        while (data.next()) {
                            hasData = true;
                            for (int i = 1; i <= columnCount; i++) {
                                String columnName = data.getMetaData().getColumnName(i);
                                if (columnName.equalsIgnoreCase("AgeMonths")) {
                                    try {
                                        if (data != null) {
                                            total += data.getInt(i);
                                            rowCount++;
                                        }
                                    } catch (Exception e) {
                                        builder.append("Error receiving the age data: ").append(hasData);
                                    }
                                }
                            }
                        }

                        if (rowCount > 0) {
                            double averageAge = (double) total / rowCount;
                            builder.append("Average age in months is: ").append(averageAge).append("\n");
                        } else {
                            builder.append("No data available to calculate the average.\n");
                        }

                        if (!hasData) {
                            builder.append("No data found.\n");
                        }

                    } catch (Exception e) {
                        builder.append("Error retrieving data from ").append(tableName).append(": ").append(e.getMessage()).append("\n");
                    }
                }
            }

            System.out.println(builder.toString());

        } catch (Exception e) {
            System.out.println("Error accessing database: " + e.getMessage());
        }
        return builder.toString();
    }
	
    // Method to calculate and display the average weight of pets in kilograms
    public static String displayAverageWeight() throws SQLException {
        String SCHEMA_NAME = null;
        StringBuilder builder = new StringBuilder();

        try (Connection connection = DatabaseConnection.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            String[] tableType = {"Table"};

            try (ResultSet tables = metaData.getTables(null, SCHEMA_NAME, null, tableType)) {
                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");

                   
                    if (!tableName.equalsIgnoreCase("Pets")) {
                        continue;
                    }

                    builder.append("Table: ").append(tableName).append("\n");


                    try (Statement stmt = connection.createStatement()) {
                        ResultSet data = stmt.executeQuery("SELECT * FROM " + tableName);

                        int columnCount = data.getMetaData().getColumnCount();
                        boolean hasData = false;
                        double total = 0;
                        int rowCount = 0;


                        while (data.next()) {
                            hasData = true;
                            for (int i = 1; i <= columnCount; i++) {
                                String columnName = data.getMetaData().getColumnName(i);
                                if (columnName.equals("WeightKg")) {
                                    try {
                                        if (data != null) {
                                            total += data.getDouble(i);
                                            rowCount++;
                                        }
                                    } catch (Exception e) {
                                        builder.append("Error receiving the weight data: ").append(hasData);
                                    }
                                }
                            }
                        }

                        if (rowCount > 0) {
                            double averageWeight = (double) total / rowCount;
                            builder.append("Average Weight in Kg is: ").append(averageWeight).append("\n");
                        } else {
                            builder.append("No data available to calculate the average.\n");
                        }

                        if (!hasData) {
                            builder.append("No data found.\n");
                        }
                    } catch (Exception e) {
                        builder.append("Error retrieving data from ").append(tableName).append(": ").append(e.getMessage()).append("\n");
                    }
                }

                System.out.println(builder.toString());

            } catch (Exception e) {
                System.out.println("Error accessing database: " + e.getMessage());
            }
        }
        return builder.toString();
    }
	
    // Method to calculate and display the average days spend in the shelter 
	public static String displayAverageDaysSpendInShelter() throws SQLException{
		String SCHEMA_NAME = null;
		StringBuilder builder = new StringBuilder();
		
		try(Connection connection = DatabaseConnection.getConnection()){
			DatabaseMetaData metaData = connection.getMetaData();
			String[] tableType = {"Table"};
			
			try(ResultSet tables = metaData.getTables(null, SCHEMA_NAME, null, tableType)) {
				while(tables.next()) {
					String tableName = tables.getString("Table_Name");
					
					if(!tableName.equalsIgnoreCase("Pets")) {
						continue;
					}
					
					builder.append("Table: ").append(tableName).append("\n");
					
					try(Statement stmt = connection.createStatement()){
						ResultSet data = stmt.executeQuery("SELECT * FROM " + tableName);
						
						int columnCount = data.getMetaData().getColumnCount();
						boolean hasData = false;
						double total = 0;
						int rowCount = 0;
						
						while(data.next()) {
							hasData = true;
							for(int i = 1; i <= columnCount; i++) {
								String columnName = data.getMetaData().getColumnName(i);
								if(columnName.equals("DaysInShelter"))
									try {
										if(data != null) {
											total += data.getInt(i);
											rowCount++;
										}
									}catch(Exception e) {
										builder.append("Error receiving the day data: ").append(hasData);
									}
							}
						}
						
						if(rowCount > 0) {
							double averageDaysInShelter = (double) total / rowCount;
							builder.append("Average Days in Shelter is: ").append(averageDaysInShelter).append("\n");
						}else {
						    builder.append("No data available to calculate the average.\n");
						}
						
						if(!hasData) {
							builder.append("No data found.\n"); 
						}
						
					}catch (Exception e) {
                        builder.append("Error retrieving data from ").append(tableName).append(": ").append(e.getMessage()).append("\n");
					}
				}
			}
			System.out.println(builder.toString()); 
			
		}catch(Exception e) {
			System.out.println("Error accessing database: " + e.getMessage());
		}
		return builder.toString();
	}
	
	// Method to calculate and display the average fee 
	public static String displayAdoptionFee() throws SQLException {
		String SCHEMA_NAME = null;
		StringBuilder builder = new StringBuilder();
		
		try(Connection connection = DatabaseConnection.getConnection()){
			DatabaseMetaData metaData = connection.getMetaData();
			String[] tableType = {"Table"};
			
			try(ResultSet tables = metaData.getTables(null, SCHEMA_NAME, null, tableType)){
				while(tables.next()) {
					String tableName = tables.getString("Table_Name");
					 
					if(!tableName.equalsIgnoreCase("Pets")) {
						continue;
					}
					
					builder.append("Table: ").append(tableName).append("\n");
					
					try(Statement stmt = connection.createStatement()){
						ResultSet data = stmt.executeQuery("SELECT * FROM " + tableName);
						
						int columnCount = data.getMetaData().getColumnCount();
						boolean hasData = false;
						double total = 0;
						int rowCount = 0;
						
						while(data.next()) {
							hasData = true;
							for(int i = 1; i <= columnCount; i++) {
								String columnName = data.getMetaData().getColumnName(i);
								if(columnName.equals("AdoptionFee")) {
									try {
										if(data != null) {
											total += data.getDouble(i);
											rowCount++;
										}
									}catch(Exception e) {
										builder.append("Error receiving the fee data: ").append(hasData);
									}
								}
							}
						}
						
						if(rowCount > 0) {
							double averageFee = (double) total / rowCount;
							builder.append("Average fee is: ").append(averageFee).append("\n");
						}else {
						    builder.append("No data available to calculate the average.\n");
						}
						
						if(!hasData) {
							builder.append("No data found.\n"); 
						}
						
					}catch (Exception e) {
                        builder.append("Error retrieving data from ").append(tableName).append(": ").append(e.getMessage()).append("\n");
					}
				}
				System.out.println(builder.toString()); 
			
			}catch(Exception e) {
				System.out.println("Error accessing database: " + e.getMessage()); 
			}
		}
		return builder.toString();
	}
	
	public static String displayMostWeightedPets(String input1) throws SQLException{
		String SCHEMA_NAME = null;
		StringBuilder builder = new StringBuilder();
		
		System.out.print("Enter the number of heaviest pets: ");
		int n = Integer.parseInt(input1); // Converts the 'input1' string into an integer
		
		try(Connection connection = DatabaseConnection.getConnection()) {
			DatabaseMetaData metaData = connection.getMetaData();
			String[] tableType = {"Table"};
			
			try(ResultSet tables = metaData.getTables(null, SCHEMA_NAME, null, tableType)){
				while(tables.next()) {
					String tableName = tables.getString("Table_Name");
					
					if(!tableName.equalsIgnoreCase("Pets")) {
						continue;
					}
					
					builder.append("Table: ").append(tableName).append("\n");
					builder.append("Top " + n + " Most Weighted Pets:\n");
					
					try(Statement stmt = connection.createStatement()){
						ResultSet data = stmt.executeQuery("SELECT WeightKg FROM " + tableName + " ORDER BY WeightKg DESC LIMIT " + n);
						
						int columnCount = data.getMetaData().getColumnCount();
						boolean hasData = false;
						
						while(data.next()) {
							hasData = true;
							for(int i = 1; i <= columnCount; i++) {
								String columnName = data.getMetaData().getColumnName(i);
								if(columnName.equalsIgnoreCase("WeightKg")) {
									try {
										double weight = data.getDouble(i);
										if(data != null) {
											builder.append(weight).append("\n");
										}
									}catch(Exception e) {
										builder.append("Error receiving the weight data: ").append(hasData);
									}
								}
							}
						}
						
						if (!hasData) {
                            builder.append("No data found.\n"); 
                        }
						
					}catch (Exception e) {
                        builder.append("Error retrieving data from ").append(tableName).append(": ").append(e.getMessage()).append("\n");
					}
				}
			}
			System.out.println(builder.toString()); 
			
		}catch (Exception e) {
            System.out.println("Error accessing database: " + e.getMessage()); 
        }
		return builder.toString();		
		
	}
	
	public static String displayIntervalWeightedPets(String input1, String input2) throws SQLException{
		String SCHEMA_NAME = null;
		StringBuilder builder = new StringBuilder();
		
		System.out.print("Enter the number of oldest pets: "); // Prompt for first input
		int n = Integer.parseInt(input1); // Converts the 'input1' string into an integer
		System.out.print("Enter the number of youngest pets: "); // Prompt for second input
		int m = Integer.parseInt(input2); // Converts the 'input2' string into an integer
		
		try(Connection connection = DatabaseConnection.getConnection()) {
			DatabaseMetaData metaData = connection.getMetaData();
			String[] tableType = {"Table"};
			
			// Implementations for first input
			try(ResultSet tables = metaData.getTables(null, SCHEMA_NAME, null, tableType)){
				while(tables.next()) {
					String tableName = tables.getString("Table_Name");
					
					if(!tableName.equalsIgnoreCase("Pets")) {
						continue;
					}
					
					builder.append("Table: ").append(tableName).append("\n");
					builder.append("Top " + n + " Most Oldest Pets:\n");
					
					try(Statement stmt = connection.createStatement()){
						ResultSet dataN = stmt.executeQuery("SELECT AgeMonths FROM " + tableName + " ORDER BY AgeMonths DESC LIMIT " + n);
						
						
						int columnCount = dataN.getMetaData().getColumnCount();
						boolean hasData = false;
						
						while(dataN.next()) {
							hasData = true;
							for(int i = 1; i <= columnCount; i++) {
								String columnName = dataN.getMetaData().getColumnName(i);
								if(columnName.equalsIgnoreCase("AgeMonths")) {
									try {
										double weight = dataN.getDouble(i);
										if(dataN != null) {
											builder.append(weight).append("\n");
										}
									}catch(Exception e) {
										builder.append("Error receiving the weight data: ").append(hasData);
									}
								}
							}
						}
						
						if (!hasData) {
                            builder.append("No data found.\n"); 
                        }
						
					}catch (Exception e) {
                        builder.append("Error retrieving data from ").append(tableName).append(": ").append(e.getMessage()).append("\n");
					}
					
					// Implementations for second input
					builder.append("Top " + n + " Most Youngest Pets:\n");
					try(Statement stmt = connection.createStatement()){
						ResultSet dataM = stmt.executeQuery("SELECT AgeMonths FROM " + tableName + " ORDER BY AgeMonths ASC LIMIT " + m);
						
						
						int columnCount = dataM.getMetaData().getColumnCount();
						boolean hasData = false;
						
						while(dataM.next()) {
							hasData = true;
							for(int i = 1; i <= columnCount; i++) {
								String columnName = dataM.getMetaData().getColumnName(i);
								if(columnName.equalsIgnoreCase("AgeMonths")) {
									try {
										double weight = dataM.getDouble(i);
										if(dataM != null) {
											builder.append(weight).append("\n");
										}
									}catch(Exception e) {
										builder.append("Error receiving the weight data: ").append(hasData);
									}
								}
							}
						}
						
						if (!hasData) {
                            builder.append("No data found.\n"); 
                        }
						
					}catch (Exception e) {
                        builder.append("Error retrieving data from ").append(tableName).append(": ").append(e.getMessage()).append("\n");
					}
				}
			}
			System.out.println(builder.toString()); 
			
		}catch (Exception e) {
            System.out.println("Error accessing database: " + e.getMessage()); 
        }
		return builder.toString();		
		
	}
}
	
	

