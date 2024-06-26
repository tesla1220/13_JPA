package com.ohgiraffers.springdatajpa.menu.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity         // name 설정하지 않는 이유 -> 한 테이블만 갖고 할거임
@Table(name = "tbl_menu")
/* 2. @Builder lombok 라이브러리에서 제공해주는 빌더 사용 */
//@Builder(toBuilder = true)
public class Menu {

    @Id
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private int menuPrice;

    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "orderableStatus")
    private String orderableStatus;


    /* 3. 엔티티 클래스 내부에서 Builder 패턴 구현하기 */
    public Menu menuName(String var){
        this.menuName = var;
        return this;
    }

    public Menu menuPrice(int var){
        this.menuPrice = var;
        return this;
    }

    public Menu categoryCode(int var){
        this.categoryCode = var;
        return this;
    }

    public Menu orderableStatus(String var){
        this.orderableStatus = var;
        return this;
    }

    public Menu builder() {
        return new Menu(menuCode, menuName, menuPrice, categoryCode, orderableStatus);
    }


    protected Menu() {}

    public Menu(int menuCode, String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }

//    public void setMenuName(String menuName) {
//        this.menuName = menuName;
//    }
}

    /*  @GeneratedValue(strategy = GenerationType.IDENTITY)
        기존 엔티티의 menuCode 값이 변경되지 않도록 하면서도,
        새로운 엔티티의 menuCode 값을 자동으로 생성하기 위해 @GeneratedValue(strategy = GenerationType.IDENTITY)를 사용합니다.
        이 방식은 데이터베이스가 자동으로 고유한 ID 값을 관리해 주므로, 개발자가 일일이 ID 값을 신경 쓸 필요가 없습니다.
     */