package com.ohgiraffers.springdatajpa.menu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_category")
public class Category {

    @Id
    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "ref_category_code")
    private Integer refCategoryCode;

    /* ️⭐⭐⭐⭐  refCategoryCode 필드가 int 타입으로 정의되어 있어서 null 값을 허용하지 않아 계속 오류남. ⭐⭐⭐⭐
    ▶️️️ ▶️️️ ▶️️️ ▶️️️  refCategoryCode 를 int 의 래퍼 클래스 타입인 Integer 변경 후 오류 해결됨. 이는 래퍼 클래스는 null 값을 허용하기 때문     */


    public Category() {
    }

    public Category(int categoryCode, String categoryName, Integer refCategoryCode) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
    }


    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}
