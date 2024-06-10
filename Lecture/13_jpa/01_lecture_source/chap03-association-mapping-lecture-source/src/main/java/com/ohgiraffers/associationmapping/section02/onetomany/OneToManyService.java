package com.ohgiraffers.associationmapping.section02.onetomany;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OneToManyService {

    private OneToManyRepository oneToManyRepository;

    public OneToManyService(OneToManyRepository oneToManyRepository){
        this.oneToManyRepository = oneToManyRepository;
    }

    @Transactional
    public Category findCategory(int categoryCode) {

        Category category = oneToManyRepository.find(categoryCode);
        System.out.println("category = " + category);

        return category;

    }

    @Transactional
    public void registMenu(CategoryDTO categoryDTO) {

        Category category = new Category(
                categoryDTO.getCategoryCode(),
                categoryDTO.getCategoryName(),
                categoryDTO.getRefCategoryCode(),
                null
        );

        Menu menu = new Menu(
                categoryDTO.getMenuList().get(0).getMenuCode(),
                categoryDTO.getMenuList().get(0).getMenuName(),
                categoryDTO.getMenuList().get(0).getMenuPrice(),
                categoryDTO.getMenuList().get(0).getCategoryCode(),
                categoryDTO.getMenuList().get(0).getOrderableStatus()
        );

        List<Menu> menuList = new ArrayList<>();
        menuList.add(menu);
        category.setMenuList(menuList);

        // DTO 에서 카테고리 엔티티에 다 옮긴 녀석을 등록해줘.
        oneToManyRepository.regist(category);

    }
}
