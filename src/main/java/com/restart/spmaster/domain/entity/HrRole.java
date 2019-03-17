package com.restart.spmaster.domain.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "hr_role")
public class HrRole implements Serializable {
    @Id
    private Integer id;

    private Integer hrid;

    private Integer rid;

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
     * @return hrid
     */
    public Integer getHrid() {
        return hrid;
    }

    /**
     * @param hrid
     */
    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }

    /**
     * @return rid
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * @param rid
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }
}