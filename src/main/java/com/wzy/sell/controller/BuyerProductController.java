package com.wzy.sell.controller;

import com.wzy.sell.VO.ProductInfoVO;
import com.wzy.sell.VO.ProductVO;
import com.wzy.sell.VO.ResultVO;
import com.wzy.sell.dataobject.ProductCategory;
import com.wzy.sell.dataobject.ProductInfo;
import com.wzy.sell.service.CategoryService;
import com.wzy.sell.service.ProductService;
import com.wzy.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: sell
 * @description: ${description}
 * @author: WangZiYu
 * @create: 2019-01-12 21:18
 **/
@RestController
@RequestMapping("buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        // 1. 查询所有商家商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 2. 查询类目(一次性查询)
        List<Integer> categoryTpeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTpeList);

        // 3. 数据拼装
        ResultVO<List<ProductVO>> resultVO = new ResultVO<List<ProductVO>>();

        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVO> productInfoVOList =new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(resultVO);
    }
}
