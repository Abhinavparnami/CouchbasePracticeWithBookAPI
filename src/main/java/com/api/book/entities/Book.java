package com.api.book.entities;







import org.hibernate.envers.Audited;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.lang.annotation.Documented;

@Entity
@Table(name="BookManagement")
@Audited
@Document
public class Book implements Serializable {

	private static final long serialVersionUI=1l;

@Id
@GeneratedValue
private int id;
@Field
private String title;
@Field
private String author;
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public Book(int i, String title, String author) {

	this.id = i;
	this.title = title;
	this.author = author;
}

@Override
public String toString() {
	return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
}


}
