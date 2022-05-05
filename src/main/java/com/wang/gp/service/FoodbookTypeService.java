package com.wang.gp.service;

import com.wang.gp.pojo.FoodbookType;

import java.util.List;

public interface FoodbookTypeService {

    public List<FoodbookType> queryAllFoodbookType();

    public int addFoodbookType(String name);

    public int deleteFoodbooktypeById(Long id);

    public int updateFoodbookType(Long id, String name);
}
