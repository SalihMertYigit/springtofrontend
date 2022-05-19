package net.javaguides.springboot;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.bytebuddy.asm.Advice.This;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootBackendApplication.class, args);
		String url = "jdbc:sqlserver:// localhost:1433;DatabaseName=bilgiler;encrypt=true;trustServerCertificate=true";
		//String url="jdbc:sqlserver://localhost;user=mert;password=123;databaseName=Calisanlar";
		String username="mert";
		String password="123";
		UserRepository userRepository = null;
		
		try {
			Connection connection=DriverManager.getConnection(url, username, password);
			Statement statement=	connection.createStatement();
			System.out.println("connected to the sql server");
			String firstNameDb="SELECT * FROM Bilgi";
			//String lastNameDb="SELECT soyisim FROM Bilgi";
			//String emailDb="SELECT email FROM Bilgi";
			ResultSet rs=statement.executeQuery(firstNameDb);
			//ResultSet rssoyisim=statement.executeQuery(lastNameDb);
			//ResultSet rsemail=statement.executeQuery(emailDb);
			 ArrayList<String> bilgiler = new ArrayList<String>();
			while (rs.next()) {
				bilgiler.add(rs.getString("isim"));
				bilgiler.add(rs.getString("soyisim"));
				bilgiler.add(rs.getString("email"));
				
				
				//System.out.println(rssoyisim.getString("soyisim"));
				//System.out.println(rsemail.getString("email"));
			}
			System.out.println(bilgiler);
			//System.out.println(bilgiler.get(1));
			//System.out.println(bilgiler.size());
			//connection.close();
			//String isimString=bilgiler.get(1);
			//System.out.println(isimString);
			//bilgilerArrayi(bilgiler);
			
		} catch (SQLException e) {
			System.out.println("Error:"+e.getMessage());
			
		}
		
		
	}
  public static void bilgilerArrayi(ArrayList<String> bilgiler){
	  System.out.println(bilgiler);
  }
	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
	//	for(int i=0;i<bilgiler.size;i++) {
		//	this.userRepository.save(new User("bilgiler.get(i)","bilgiler.get(i+1)","bilgiler.get(i+2)"));
		//	i=i+3;
		//}
		this.userRepository.save(new User("ali","yeni","gmail"));
		
		this.userRepository.save(new User("ali", "veli", "aliveli@gmail.com"));
		this.userRepository.save(new User("veli", "yagmur", "veliyagmur@gmail.com"));
		
		
		
	}
	
	}
	


