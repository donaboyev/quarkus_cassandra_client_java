package com.abbosidev;

import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.datastax.oss.driver.api.mapper.annotations.Update;

import java.util.UUID;

@Dao
public interface ProductDao {
    @Select
    Product findById(UUID productId);

    @Select
    PagingIterable<Product> findAll();

    @Update
    void update(Product product);

    @Insert
    void save(Product product);

    @Delete
    void delete(Product product);
}
