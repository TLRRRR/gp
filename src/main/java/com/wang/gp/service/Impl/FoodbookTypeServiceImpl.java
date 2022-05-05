package com.wang.gp.service.Impl;

import com.wang.gp.dao.FoodbookTypeDao;
import com.wang.gp.pojo.FoodbookType;
import com.wang.gp.service.FoodbookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodbookTypeServiceImpl implements FoodbookTypeService {

    @Autowired
    FoodbookTypeDao foodbookTypeDao;

    @Override
    public List<FoodbookType> queryAllFoodbookType() {
        return foodbookTypeDao.queryAllFoodbookType();
    }

    @Override
    public int addFoodbookType(String name) {
        return foodbookTypeDao.addFoodbookType(name);
    }

    @Override
    public int deleteFoodbooktypeById(Long id) {
        return foodbookTypeDao.deleteFoodbooktypeById(id);
    }

    @Override
    public int updateFoodbookType(Long id, String name) {
        return foodbookTypeDao.updateFoodbookType(id, name);
    }
}
