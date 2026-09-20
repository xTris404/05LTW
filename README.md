# GraphQL Product & Category – Yêu cầu 1

**Commit message đề xuất:**  
`feat: Home page - products sorted by price ASC`

## Yêu cầu đã hoàn thành

✅ Hiển thị **tất cả product có price từ thấp đến cao** trên trang Home  
✅ Sử dụng **GraphQL** (`productsByPriceAsc`)  
✅ Render bằng **AJAX** trên **Thymeleaf**

## Cấu trúc chính

| File | Vai trò |
|------|---------|
| `schema.graphqls` | Query `productsByPriceAsc` |
| `ProductRepository` | `findAllByOrderByPriceAsc()` |
| `ProductService` | Gọi repository |
| `ProductGraphQLController` | `@QueryMapping` |
| `home.html` | AJAX gọi GraphQL và hiển thị |
| `DemoApplication` | Seed data mẫu |

## Cách chạy

```bash
mvn spring-boot:run
```

### Link kiểm tra

| Mục đích | Link |
|----------|------|
| **Trang Home (Yêu cầu 1)** | http://localhost:8080/home |
| GraphiQL | http://localhost:8080/graphiql |
| H2 Console | http://localhost:8080/h2-console |

### Test nhanh trên GraphiQL

```graphql
query {
  productsByPriceAsc {
    id
    title
    price
    category { name }
  }
}
```

Kết quả sẽ trả về danh sách product đã sắp xếp theo `price` tăng dần.

## Dữ liệu mẫu (seed)

- 3 Category: Laptop, Smartphone, Gia dụng
- 7 Product với giá từ 199 → 1899

## Chưa có (sẽ làm ở các phần sau)

- Lấy product theo 1 category
- CRUD + search + pagination Product / Category
