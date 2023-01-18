package com.example.coursemanagementplatform.database;

import com.aerospike.client.AerospikeClient;
import com.aerospike.mapper.tools.AeroMapper;

public class DbConnection {
    public static final AerospikeClient CLIENT = new AerospikeClient("172.20.0.2", 3000);
    public static final AeroMapper MAPPER = new AeroMapper.Builder(CLIENT).build();
}
