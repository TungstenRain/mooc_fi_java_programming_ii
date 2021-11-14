package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    // Variables
    private String databasePath;
    
    // Constructors
    /**
     * Construct the TodoDao
     * @param databasePath 
     */
    public TodoDao(String databasePath) {
        this.databasePath = databasePath;
    }
    
    // Methods
    /**
     * Get a list of Todo items from the database
     * @return List<Todo>: the list of Todo items
     * @throws SQLException 
     */
    public List<Todo> list() throws SQLException {
        List<Todo> todos = new ArrayList<>();
        try (Connection connection = createConnectionAndEnsureDatabase();
                ResultSet results = connection.prepareStatement("SELECT * FROM Todo").executeQuery()) {
            while (results.next()) {
                todos.add(new Todo(results.getInt("id"), results.getString("name"), results.getString("description"), results.getBoolean("done")));
            }
        }
        return todos;
    }
    
    /**
     * Add the Todo to the database
     * @param todo Todo: the Todo to be added to the database
     * @throws SQLException 
     */
    public void add(Todo todo) throws SQLException {
        try (Connection connection = createConnectionAndEnsureDatabase()) {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO Todo (name, description, done) VALUES (?, ?, ?)");
            stmt.setString(1, todo.getName());
            stmt.setString(2, todo.getDescription());
            stmt.setBoolean(3, todo.getDone());
            stmt.executeUpdate();
        }
    }
    
    /**
     * Update the database to show the Todo was completed
     * @param id int: the index of the Todo
     * @throws SQLException 
     */
    public void markAsDone(int id) throws SQLException {
        try (Connection connection = createConnectionAndEnsureDatabase()) {
            PreparedStatement stmt = connection.prepareStatement("UPDATE Todo SET done = true WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    
    /**
     * Remove a Todo from the database
     * @param id int: the ID for the Todo
     * @throws SQLException 
     */
    public void remove(int id) throws SQLException {
        try (Connection connection = createConnectionAndEnsureDatabase()) {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM Todo WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    
    /**
     * Create a connection to the database
     * @return Connection: the connection to the database
     * @throws SQLException 
     */
    private Connection createConnectionAndEnsureDatabase() throws SQLException {
        Connection conn = DriverManager.getConnection(this.databasePath, "sa", "");
        try {
            conn.prepareStatement("CREATE TABLE Todo (id int auto_increment primary key, name varchar(255), description varchar(10000), done boolean)").execute();
        } catch (SQLException t) {
        }

        return conn;
    }
}
