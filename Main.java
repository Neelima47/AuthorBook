package jpademo;
 
import java.util.List;

import jakarta.persistence.EntityManager;



public class Main {
 
	public static void main(String[] args) {
		
		EntityManager em=JPAUtil.getEntityManager();
		
		 em.getTransaction().begin();
		
		/*Author author = new Author("George Orwell");
	        author.addBook(new Book("1983"));
	        em.persist(author);*/
		
		 /*Author a1=new Author("vishnu");
		 Author a2=new Author("Sai");
		  
		  em.persist(a1);
		  em.persist(a2);
		
		 Book b1=new Book("DSA",a1);
		 Book b2=new Book("C",a2);
		 em.persist(b1);
		 em.persist(b2);
		
		 em.getTransaction().commit();
		 em.getTransaction().begin();
		
		Book fetchedBook = em.find(Book.class,b1.getId());
		 System.out.println("Book: " + fetchedBook.getTitle());
 
	        System.out.println("Accessing Author...");
	        
	        System.out.println(fetchedBook.getAuthor().getName());
	        em.getTransaction().commit();*/
		 
		 em.persist(new User("Alice","alice@example.com","ACTIVE"));
		 em.persist(new User("Bob","bob@example.com","INACTIVE"));
		 em.persist(new User("Charlie","charlie@example.com","ACTIVE"));
		 em.getTransaction().commit();
		 
		 List<User> users1=em.createQuery("select u from User u where u.name=:name",User.class)
		 	.setParameter("name","Bob").getResultList();
		 	
		 	for(User u:users1) {
		 		System.out.println(u.getName());
		 	}
		 	
		List<User> users2=em.createNamedQuery("User.findByEmail",User.class)
				 	.setParameter("email","alice@example.com").getResultList();
				 	
				 	for(User u:users2) {
				 		System.out.println(u.getEmail());
				 	}
		List<User> activeUsers=em.createNamedQuery("User.findByStatus",User.class)
					.setParameter(1,"ACTIVE").getResultList();
						 	
					for(User u:activeUsers){
						System.out.println(u.getName());
					}
		 	
	        em.close();
	        JPAUtil.close();
		
		
 
	}
 
}
 
 