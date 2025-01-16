# Pet_Adoption_System

The Pet Adoption System is a Java-based desktop application that offers features for organizing and evaluating pet data at an adoption facility. This program displays calculated metrics such as average age, weight, and adoption fee, among others, after connecting to a database to retrieve pet-related data.

## Features
1. Retrieve all the data from the created database.
2. Calculate and display the average properties.
   - Age.
   - Weight.
   - Days spent in shelter.
   - Adoption fee of pet data.
3. Display the top pets in terms of related input.
   - Display the most weighted pets.
   - Display the oldest and youngest pets.

4. GUI
   - Buttons for different operations from different methods.
   - Text Area to display outputs.
   - Input prompts for user queries.

## Tools Used
1. Builder Pattern
   - It’s a creational design pattern that separates the construction of complex objects from their     representation, offering a cleaner approach. And provide flexibility, readability, and immutability to object creation.
   - I used to build messages for table information, appending results, and error-handling messages.
2. Metadata
   - It’s a set of descriptive, structural, and administrative data about a group of computer data (like database schema). Used to know data about data, means that database table names, columns, keys, number of databases exist, etc…
   - I used to retrieve database information, such as tables, columns, etc…
3. ResultSet
   - It’s an object that represents the result of a query executed against a database. It provides access to the rows of data retrieved from a database table or the metadata of the database (like tables and columns). Used to access query results retrieved from the relational database.
   - I used it with DatabaseMetaData to retrieve schema information about the database.
4. Statement
   - It’s an interface provided by the JDBC API to execute SQL queries against a database. It serves as a communication link between the Java application and the database.
   - I used it to send SQL queries to the database.
