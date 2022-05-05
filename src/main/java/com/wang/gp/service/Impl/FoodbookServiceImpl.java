package com.wang.gp.service.Impl;

import com.wang.gp.dao.FoodbookDao;
import com.wang.gp.pojo.Foodbook;
import com.wang.gp.service.FoodbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FoodbookServiceImpl implements FoodbookService {

    @Autowired
    FoodbookDao foodbookDao;

    @Override
    public int addFoodbook(String foodMenu, String description, String formula, String usagew, Date creationtime, String author, String typew) {
        return foodbookDao.addFoodbook(foodMenu, description, formula, usagew, creationtime, author, typew);
    }

    @Override
    public ArrayList<Foodbook> allAuthorFoodbook(String author) {
        return foodbookDao.allAuthorFoodbook(author);
    }

    @Override
    public ArrayList<Foodbook> allFoodbook() {
        return foodbookDao.allFoodbook();
    }

    @Override
    public int deletefoodbook(long id) {
        return foodbookDao.deletefoodbook(id);
    }

    @Override
    public int updatefoodbook(Long id, String foodMenu, String description, String formula, String usagew) {
        return foodbookDao.updatefoodbook(id, foodMenu, description, formula, usagew);
    }

    @Override
    public List showFoodbookType() {
        return foodbookDao.showFoodbookType();
    }
}
