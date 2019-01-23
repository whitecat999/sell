package com.wzy.sell.repository;

import com.wzy.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: sell
 * @description: ${description}
 * @author: WangZiYu
 * @create: 2019-01-10 21:22
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
