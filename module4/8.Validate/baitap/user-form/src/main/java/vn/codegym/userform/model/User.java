package vn.codegym.userform.model;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Size(message = "Nhập vào cho đúng", min = 5, max = 45)

    private String firstName;


    @Size(message = "Nhập vào cho đúng", min = 5, max = 45)

    private String lastName;

    @Column(unique = true)
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$", message = "Nhập vào cho đúng")
    private String phoneNumber;

//    @Min(value = 18, message = "Phải trên 18 tuổi")
    @Range(min = 18, max = 100, message = "Độ tuổi không phù hợp")
    private int age;

    @Pattern(regexp = "^(\\w{3,}@\\w+\\.\\w+)$", message = "Email đúng định dạng abc@abc.abc")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
