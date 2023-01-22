package net.javacontact.Dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import net.javacontact.mode.Contact;

class ContactDaoTest {

	private DriverManagerDataSource dataSource;
	private ContactDao dao;
	
	@BeforeEach
	void setUpBeforeEach() {
		
        dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		dao= new ContactDaoImp(dataSource);	
	}
	@Test
	void testSave() {
		
		Contact contact = new Contact("Alexis Ngoga", "r.alexisngoga202gmail.com", "Kigali", "0784720789");
	     int result=dao.save(contact);
		
	     assertTrue(result>0);
	}
	@Test
	void testUpdate() {
		Contact contact = new Contact(5,"Ishimwe Claude", "r.alexisngoga202gmail.com", "Kigali", "0784720789");
	    
		int result = dao.update(contact);
		assertTrue(result>0);
		
	}

	@Test
	void testGet() {
		Integer id=5;
		Contact contact=dao.get(id);
		if(contact !=null) {
			System.out.println(contact);
		}
		assertNotNull(contact);
	}

	@Test
	void testDelete() {
		Integer id= 6;
		int result=dao.delete(id);
		
		assertTrue(result>0);
	}

	@Test
	void testList() {
		List<Contact> ls = dao.list();
		for(Contact c:ls) {
			System.out.println(c);
		}
		assertTrue(!ls.isEmpty()); 
	}

}
