package com.wang.gp.dao;

import com.wang.gp.pojo.FoodbookType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodbookTypeDao {

    public List<FoodbookType> queryAllFoodbookType();

    public int addFoodbookType(String name);

    public int deleteFoodbooktypeById(Long id);

    public int updateFoodbookType(Long id, String name);
}
