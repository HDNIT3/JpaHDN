package vn.iostar.entity;


import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable= false)
	private int role; // 1-user, 2-manager, 3-admin
	
	@OneToMany(mappedBy = "user",fetch=FetchType.EAGER)
	private List<Category> categories;
	
	
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(Category category) {
		this.categories.add(category);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
}