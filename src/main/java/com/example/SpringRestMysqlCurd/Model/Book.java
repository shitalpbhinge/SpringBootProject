package com.example.SpringRestMysqlCurd.Model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books1")

public class Book 
{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column(name="uuid")
		private String uuid="d6a36cff-72c1-4a61-9622-affac180aa27";
		@Column(name="version")
		private long version;
		@Column
		private String book_name;
		@Column
		private String author_name;
		@Column
		private String isbn;
		
		
		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Book(String uuid, String book_name, String author_name, String isbn) 
		{
			
			this.uuid=uuid;
	    	this.version = Instant.now().toEpochMilli();
			this.book_name=book_name;
			this.author_name=author_name;
			this.isbn=isbn;
		}
		
		
		 public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public long getVersion() {
			return version;
		}

		public String  getUuid() 
		 {
			 return uuid;
		 }
		 public void setUuid(String uuid) 
		 {
				this.uuid = uuid;
		}

	
		public String getBook_name() 
		{
			return book_name;
		}
		
		public void setBook_name(String book_name) 
		{
			this.book_name = book_name;
		}
		
		public String getAuthor_name() 
		{
			return author_name;
		}
		
		public void setAuthor_name(String author_name) 
		{
			this.author_name = author_name;
		}
		
		public String getIsbn() 
		{
			return isbn;
		}
		
		public void setIsbn(String isbn) 
		{
			this.isbn = isbn;
		}

		public void setVersion(long version2) {
			// TODO Auto-generated method stub
			
		}


		public static Book fromString(String message) {
			// TODO Auto-generated method stub
			return null;
		}

		

}