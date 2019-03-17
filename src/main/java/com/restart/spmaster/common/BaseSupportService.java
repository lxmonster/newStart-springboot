package com.restart.spmaster.common;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class BaseSupportService<T> implements BaseService<T> {

	protected CommonMapper<T> commonMapper;

	public void setCommonMapper(CommonMapper<T> commonMapper) {
		this.commonMapper = commonMapper;
	}

	@Override
	public PageInfo<T> selectPageList(T e, int PageIndex, int PageSize) {
		PageHelper.startPage(PageIndex, PageSize);
		List<T> list=commonMapper.select(e);
		PageInfo<T> page = new PageInfo<T>(list);
		return page;
	}

	@Override
	public List<T> selectList(T e) {
		return commonMapper.select(e);
	}

	@Override
	public T selectOne(T e) {
		return commonMapper.selectOne(e);
	}

	@Override
	public Integer update(T e) {
		return commonMapper.updateByPrimaryKeySelective(e);
	}

	@Override
	public Integer add(T e) {
		return commonMapper.insertSelective(e);
	}

	@Override
	public Integer delete(T e) {
		return commonMapper.delete(e);
	}

	@Override
	public T selectById(String id) {
		return commonMapper.selectByPrimaryKey(id);
	}

	@Override
	public int selectCount(T e) {
		return commonMapper.selectCount(e);
	}

}
