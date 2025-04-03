package jpademo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Author {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="author")
	private List<Book> books=new ArrayList<>();
	public Author() {
		
	}
	
	public Author(String name) {
		super();

		this.name=name;
		
	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		
		books.add(book);
		book.setAuthor(this);
		
	}
	
	
	
	

}
