package vn.iostar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id; 
    @Column(name = "categoryname", columnDefinition = "NVARCHAR(255)", nullable = false)
    private String categoryname;

    @Column(name = "images", columnDefinition = "NVARCHAR(MAX)")
    private String images;
    
    @ManyToOne
    @JoinColumn(name = "user_id") 
    private User user;

    // Constructors
    public Category() {
        super();
    }

    public Category(int category_id, String categoryname, String images) {
        super();
        this.category_id = category_id;
        this.categoryname = categoryname;
        this.images = images;
    }

    // Getters and Setters
    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}