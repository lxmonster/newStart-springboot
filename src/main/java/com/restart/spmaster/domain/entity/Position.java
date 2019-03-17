package com.restart.spmaster.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Position implements Serializable {
    private Integer id;

    /**
     * 职位
     */
    private String name;

    @Column(name = "createDate")
    private Date createdate;

    private Boolean enabled;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取职位
     *
     * @return name - 职位
     */
    public String getName() {
        return name;
    }

    /**
     * 设置职位
     *
     * @param name 职位
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return createDate
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * @return enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}