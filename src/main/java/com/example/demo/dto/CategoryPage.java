package com.example.demo.dto;

import com.example.demo.entity.Category;
import java.util.List;

public class CategoryPage {
    private List<Category> content;
    private PageInfo pageInfo;

    public CategoryPage() {}
    public CategoryPage(List<Category> content, PageInfo pageInfo) {
        this.content = content;
        this.pageInfo = pageInfo;
    }
    public List<Category> getContent() { return content; }
    public void setContent(List<Category> content) { this.content = content; }
    public PageInfo getPageInfo() { return pageInfo; }
    public void setPageInfo(PageInfo pageInfo) { this.pageInfo = pageInfo; }
}
