package com.abbosidev;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import jakarta.inject.Singleton;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Singleton
public class Config {

    @ConfigProperty(name = "keyspace.one")
    String keyspace1;

    public CqlSession session(){
        CqlSession session = CqlSession.builder().build();
        return session;
    }

    public ProductDao productDao(){
        System.out.println("keyspace "+ keyspace1);
        InventoryMapper inventoryMapper = new InventoryMapperBuilder(session()).build();
        ProductDao dao = inventoryMapper.productDao(CqlIdentifier.fromCql(keyspace1));
        return dao;
    }
}
