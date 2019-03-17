package com.restart.spmaster.common;

import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BaseService<T> {

	public PageInfo<T> selectPageList(T e, int PageIndex, int PageSize);

	public List<T> selectList(T e);

	public T selectOne(T e);

	public Integer update(T e);

	public Integer add(T e);

	public Integer delete(T e);

	public T selectById(String id);

	public int selectCount(T e);

}
