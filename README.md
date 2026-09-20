# GraphQL Product & Category – Full (Yêu cầu 1 + 2 + 3)

**Commit message đề xuất:**  
`feat: CRUD + search + pagination for Product and Category`

## Yêu cầu đã hoàn thành

✅ **Yêu cầu 1**: Products sorted by price ASC trên Home  
✅ **Yêu cầu 2**: Products theo 1 category trên Home  
✅ **Yêu cầu 3**: CRUD + tìm kiếm + phân trang cho **Product** và **Category**

Tất cả dùng **GraphQL + AJAX + Thymeleaf**.

## Cách chạy

```bash
mvn spring-boot:run
```

### Link kiểm tra

| Trang | Link |
|-------|------|
| Home (YC1 + YC2) | http://localhost:8080/home |
| Product CRUD | http://localhost:8080/products |
| Category CRUD | http://localhost:8080/categories |
| GraphiQL | http://localhost:8080/graphiql |
| H2 Console | http://localhost:8080/h2-console |

## GraphQL chính

```graphql
# Query
productsByPriceAsc
productsByCategory(categoryId)
products(page, size, keyword)
categoriesPage(page, size, keyword)

# Mutation
createProduct / updateProduct / deleteProduct
createCategory / updateCategory / deleteCategory
```
