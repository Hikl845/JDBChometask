package org.example;

import org.example.Database;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

public class DatabasePopulateService {

    public static void main(String[] args) {
        executeSqlFile("sql/populate_db.sql");
        System.out.println("Data populated!");
    }

    private static void executeSqlFile(String filePath) {
        try (Connection conn = Database.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {
            String sql = Files.readString(Paths.get(filePath));
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
