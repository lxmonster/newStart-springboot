package com.restart.spmaster.domain.vo;

import com.restart.spmaster.domain.entity.Menu;
import com.restart.spmaster.domain.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MenuVo extends Menu {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<Role> roles;
}
