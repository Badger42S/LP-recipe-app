package com.springlp.recipeapp.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    Category category;
    @BeforeAll
    public void setUp(){
        category=new Category();
    }
    @Test
    void getId() {
        Long insValue=6L;
        category.setId(insValue);
        assertEquals(insValue,category.getId());
    }

    @Test
    void setId() {
    }

}