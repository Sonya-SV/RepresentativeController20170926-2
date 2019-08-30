package com.company.model.dao.impl;

import com.company.model.dao.DaoFactory;
import com.company.model.dao.NoteBookDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    @Override
    public NoteBookDao createNoteBookDao() {
        return new JDBCNotebookDao(getConnection());
    }

    private Connection getConnection() {
        {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Ops!");
            }
            Connection connection;
            try {

                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/rf002db ?serverTimezone=UTC",
                        "root",
                        "root");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return connection;
        }
    }


}
