package com.example.SpringRestMysqlCurd.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.SpringRestMysqlCurd.Model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long>
{
	  
	   
	   @Query(value = "SELECT * FROM books1 ORDER BY version DESC LIMIT 1", nativeQuery = true)
	   public Book getLatestByAppUuid(String appUuid);


}