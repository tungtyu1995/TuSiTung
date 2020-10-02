package vn.codegym.baitap2.model;


import javax.persistence.*;
import java.util.Collection;


@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategory;

    private String nameCategory;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<Blog> blogs;


    public Category() {
    }

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setName(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Collection<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Collection<Blog> blogs) {
        this.blogs = blogs;
    }
}
