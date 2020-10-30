package vn.codegym.furama.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoaiDichVu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenLoaiDichVu;


    public LoaiDichVu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenLoaiDichVu() {
        return tenLoaiDichVu;
    }

    public void setTenLoaiDichVu(String tenLoaiDichVu) {
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

}