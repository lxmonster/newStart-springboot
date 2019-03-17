package com.restart.spmaster.service;

import com.restart.spmaster.common.BaseSupportService;
import com.restart.spmaster.domain.entity.Menu;
import com.restart.spmaster.domain.vo.MenuVo;
import com.restart.spmaster.mapper.MenuMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MenuService extends BaseSupportService<Menu> {
    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private void setCommonMapper(MenuMapper menuMapper) {
        super.setCommonMapper(menuMapper);
    }

    public List<MenuVo> getAllMenu(){
        return menuMapper.getAllMenu();
    }
}
