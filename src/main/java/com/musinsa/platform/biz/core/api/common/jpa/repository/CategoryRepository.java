package com.musinsa.platform.biz.core.api.common.jpa.repository;

import com.musinsa.platform.biz.core.api.common.jpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.useYn = 'Y'")
    List<Category> findAllCategories();

    @Query("SELECT c FROM Category c WHERE c.categoryNo = :categoryNo AND c.useYn = 'Y'")
    Optional<Category> findByCategoryNo(@Param("categoryNo") Long categoryNo);

    @Query("SELECT c FROM Category c WHERE c.categoryName = :categoryName AND c.useYn = 'Y'")
    Optional<Category> findByCategoryName(@Param("categoryName") String categoryName);
}
