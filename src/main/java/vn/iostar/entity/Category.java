package vn.iostar.entity;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "categoryname", columnDefinition = "NVARCHAR(255)", nullable = false)
    private String categoryname;

    @Column(name = "images", columnDefinition = "NVARCHAR(MAX)")
    private String images;

    // Constructors
    public Category() {
        super();
    }

    public Category(int id, String categoryname, String images) {
        super();
        this.id = id;
        this.categoryname = categoryname;
        this.images = images;
    }

    // Getters and Setters
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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}