package com.ruoyi.system.response;

import java.util.List;

/**
 * @Author: ruohao
 * @Date: 2023/5/28
 **/
public class CategoryListResp {
    private Integer id;
    private String name;
    private String desc;
    private Integer level;
    private Integer parent;
    private String img;
    private List<CategoryListResp> children;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<CategoryListResp> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryListResp> children) {
        this.children = children;
    }
}
