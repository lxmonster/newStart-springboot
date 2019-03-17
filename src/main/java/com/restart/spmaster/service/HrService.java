package com.restart.spmaster.service;

import com.restart.spmaster.common.BaseSupportService;
import com.restart.spmaster.domain.entity.Hr;
import com.restart.spmaster.domain.vo.HrVo;
import com.restart.spmaster.mapper.HrMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HrService extends BaseSupportService<Hr> implements UserDetailsService {
    @Autowired
    private HrMapper hrMapper;

    @Autowired
    private void setCommonMapper(HrMapper hrMapper) {
        super.setCommonMapper(hrMapper);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        HrVo hr = hrMapper.loadUserByUsername(s);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return null;
    }
}
