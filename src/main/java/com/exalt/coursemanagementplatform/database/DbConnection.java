package com.exalt.coursemanagementplatform.database;

import com.aerospike.client.AerospikeClient;
import com.aerospike.mapper.tools.AeroMapper;
import java.util.Properties;


/**
 * The DbConnection is a class for connecting to database.
 */
public class DbConnection {
    public static final String FILE_NAME = "app.properties";
    public static final String HOST = "db.host";
    public static final String PORT = "db.port";

    public static final AerospikeClient CLIENT;
    public static final AeroMapper MAPPER;

    static {
        Properties properties = new Properties();

        try {
            properties.load(DbConnection.class.getClassLoader().getResourceAsStream(FILE_NAME));
        }
        catch (Exception e){}

        String dbHost = properties.getProperty(HOST);
        int dbPort = Integer.parseInt(properties.getProperty(PORT));

        CLIENT = new AerospikeClient(dbHost, dbPort);
        MAPPER = new AeroMapper.Builder(CLIENT).build();
    }
}
