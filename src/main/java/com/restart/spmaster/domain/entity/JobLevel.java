package com.restart.spmaster.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class JobLevel implements Serializable {
    private Integer id;

    /**
     * 职称名称
     */
    private String name;

    @Column(name = "titleLevel")
    private String titlelevel;

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
     * 获取职称名称
     *
     * @return name - 职称名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置职称名称
     *
     * @param name 职称名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return titleLevel
     */
    public String getTitlelevel() {
        return titlelevel;
    }

    /**
     * @param titlelevel
     */
    public void setTitlelevel(String titlelevel) {
        this.titlelevel = titlelevel == null ? null : titlelevel.trim();
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