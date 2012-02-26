/**
 *  File: DDLGenerator
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 26.02.12
 */
package com.irsatools.util;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.config.PersistenceUnitProperties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.*;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Create persistence unit in order generate DDL scripts from JPA entities
 */
public final class DDLGenerator {

    private static final String SQL_DELIMITER = ";";
    private static final int APP_LOCATION_PARAMETER_INDEX = 0;
    private static final int JDBC_DRIVER_PARAMETER_INDEX = 1;
    private static final int JDBC_URL_LOCATION_PARAMETER_INDEX = 2;
    private static final int JDBC_USER_LOCATION_PARAMETER_INDEX = 3;
    private static final int JDBC_PASSWORD_LOCATION_PARAMETER_INDEX = 4;
    private static final int DATABASE_NAME_PARAMETER_INDEX = 5;
    private static final String DROP_DATABASE_SQL_NAME = "1-db-drop.sql";
    private static final String DROP_DATABASE_STATEMENT = "drop database if exists {0};";
    private static final String CREATE_DATABASE_STATEMENT = "create database {0} template=template0 encoding=''UTF-8'';";

    public static void main(String[] args) throws Exception {
        try {
            generateSQL(args);
            processSQL(new File(args[APP_LOCATION_PARAMETER_INDEX]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate two sql script files: "1-db-drop.sql" and "2-db-create.sql"
     * @param args
     * @throws IOException
     */
    private static void generateSQL(String[] args) throws IOException {
        //Generate SQL-Drop script
        File dropDatabase = new File(args[APP_LOCATION_PARAMETER_INDEX], DROP_DATABASE_SQL_NAME);
        BufferedWriter writer = new BufferedWriter(new FileWriter(dropDatabase, false));
        writer.write(MessageFormat.format(DROP_DATABASE_STATEMENT, args[DATABASE_NAME_PARAMETER_INDEX]));
        writer.newLine();
        writer.write(MessageFormat.format(CREATE_DATABASE_STATEMENT, args[DATABASE_NAME_PARAMETER_INDEX]));
        writer.flush();
        writer.close();
        //Generate SQL-Create script via EntityManager
        Map<String, String> persistProperties = new HashMap<String, String>();
        persistProperties.put(PersistenceUnitProperties.APP_LOCATION, args[APP_LOCATION_PARAMETER_INDEX]);
        persistProperties.put(PersistenceUnitProperties.JDBC_DRIVER, args[JDBC_DRIVER_PARAMETER_INDEX]);
        persistProperties.put(PersistenceUnitProperties.JDBC_URL, args[JDBC_URL_LOCATION_PARAMETER_INDEX]);
        persistProperties.put(PersistenceUnitProperties.JDBC_USER, args[JDBC_USER_LOCATION_PARAMETER_INDEX]);
        persistProperties.put(PersistenceUnitProperties.JDBC_PASSWORD, args[JDBC_PASSWORD_LOCATION_PARAMETER_INDEX]);
        // Create EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.irsatools.ddl", persistProperties);
        EntityManager entityManager = emf.createEntityManager();
        entityManager.close();
        emf.close();
    }

    /**
     * Add SQL_DELIMITER to the end of each string
     * @param file the file to process
     * @throws Exception
     */
    private static void processSQL(File file) throws Exception {
        for (File sqlFile : file.listFiles()) {
            if (sqlFile.getName().startsWith("2")) {
                BufferedReader reader = new BufferedReader(new FileReader(sqlFile));
                StringBuilder builder = new StringBuilder((int) sqlFile.length());
                String line;
                while ((line = reader.readLine()) != null) {
                    if (StringUtils.isNotBlank(line)) {
                        builder.append(line.concat(SQL_DELIMITER).concat("\n"));
                    }
                }
                reader.close();
                BufferedWriter writer = new BufferedWriter(new FileWriter(sqlFile, false));
                writer.write(builder.toString());
                writer.flush();
                writer.close();
            }
        }
    }
}
