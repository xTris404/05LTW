package com.example.demo.dto;

import com.example.demo.entity.Product;
import java.util.List;

public class ProductPage {
    private List<Product> content;
    private PageInfo pageInfo;

    public ProductPage() {}
    public ProductPage(List<Product> content, PageInfo pageInfo) {
        this.content = content;
        this.pageInfo = pageInfo;
    }
    public List<Product> getContent() { return content; }
    public void setContent(List<Product> content) { this.content = content; }
    public PageInfo getPageInfo() { return pageInfo; }
    public void setPageInfo(PageInfo pageInfo) { this.pageInfo = pageInfo; }
}
