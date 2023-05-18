package com.ruoyi.common.core.domain.entity;

/**
 * @author：liyouxin
 * @date：2023/5/18 17:51
 */
public class Category {
    private Integer id;
    private String name;
    private Integer level;
    private Integer parent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }
}
