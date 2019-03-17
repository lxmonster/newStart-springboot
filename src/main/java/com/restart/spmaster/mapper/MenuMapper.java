package com.restart.spmaster.mapper;

import com.restart.spmaster.common.CommonMapper;
import com.restart.spmaster.domain.entity.Menu;
import com.restart.spmaster.domain.vo.MenuVo;

import java.util.List;

public interface MenuMapper extends CommonMapper<Menu> {
    List<MenuVo> getAllMenu();
}
