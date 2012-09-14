/**
 *  File: DDLGenerator
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 26.02.12
 */
package com.irsatools.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;

/**
 * Create persistence unit in order generate DDL scripts from JPA entities
 */
public final class DDLGenerator {

    private static final int APP_LOCATION_PARAMETER_INDEX = 0;
    private static final int DATABASE_NAME_PARAMETER_INDEX = 1;

    private static final String DROP_DATABASE_SQL_NAME = "1-db-drop.sql";
    private static final String DROP_DATABASE_STATEMENT = "drop database if exists {0};";
    private static final String CREATE_DATABASE_STATEMENT = "create database {0} template=template0 encoding=''UTF-8'';";

    private static void generateSQL(String[] args) throws IOException {
        File dropDatabase = new File(args[APP_LOCATION_PARAMETER_INDEX], DROP_DATABASE_SQL_NAME);
        BufferedWriter writer = new BufferedWriter(new FileWriter(dropDatabase, false));
        writer.write(MessageFormat.format(DROP_DATABASE_STATEMENT, args[DATABASE_NAME_PARAMETER_INDEX]));
        writer.newLine();
        writer.write(MessageFormat.format(CREATE_DATABASE_STATEMENT, args[DATABASE_NAME_PARAMETER_INDEX]));
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) {
        try {
            generateSQL(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
