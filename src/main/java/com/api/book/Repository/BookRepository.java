package com.api.book.Repository;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.api.book.entities.Book;



		@Repository
		@N1qlPrimaryIndexed
		@ViewIndexed(designDoc = "Book", viewName = "all")
		public interface BookRepository extends CouchbaseRepository<Book, Integer> {


			Book findById(int id);
			
	}


