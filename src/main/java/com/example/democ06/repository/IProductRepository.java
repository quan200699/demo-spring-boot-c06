package com.example.democ06.repository;

import com.example.democ06.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> findByNameContaining(String name, Pageable pageable);
    @Query(value = "call insertProduct(?1, ?2)", nativeQuery = true) //native query = true => gọi SQL
    void insertProductUsingProcedure(String name, double price);

    @Query(value = "select p.name from Product as p where p.id = ?1") // mặc định native query = false => gọi HQL
    String getProductWithNameHQL(Long id);

    @Query(value = "select products.*, category.name " +
            "from products join category on products.category_id = category.id " +
            "where category.id = ?1;", nativeQuery = true)
    String getProductWithNameSQL(Long id);
}
