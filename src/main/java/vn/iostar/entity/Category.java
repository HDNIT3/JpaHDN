package vn.iostar.entity;

import java.io.Serializable;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
@NamedQuery(name="Category.findAll", query="SELECT v FROM Category v")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	@Column(columnDefinition = "NVARCHAR(255)")
	private String categoryname;
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String images;
	
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public Category(int id, String categoryname) {
		super();
		this.id = id;
		this.categoryname = categoryname;
	}
	public Category() {
		super();
	}
	
}
