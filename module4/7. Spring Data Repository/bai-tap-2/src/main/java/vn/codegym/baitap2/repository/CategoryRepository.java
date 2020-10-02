package vn.codegym.baitap2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.codegym.baitap2.model.Category;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
