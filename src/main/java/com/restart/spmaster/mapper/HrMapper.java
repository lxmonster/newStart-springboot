package com.restart.spmaster.mapper;

import com.restart.spmaster.common.CommonMapper;
import com.restart.spmaster.domain.entity.Hr;
import com.restart.spmaster.domain.entity.Role;
import com.restart.spmaster.domain.vo.HrVo;

import java.util.List;

public interface HrMapper extends CommonMapper<Hr> {
    HrVo loadUserByUsername(String username);

    List<Role> getRolesByHrId(Long id);
}
