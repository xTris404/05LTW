# GraphQL Product & Category – Part 1

**Commit message đề xuất:**  
`init: Spring Boot + GraphQL + JPA + H2 + Thymeleaf`

## Nội dung phần này

- Project Spring Boot 3.2 + Java 17
- Dependency: Web, Thymeleaf, GraphQL, JPA, H2
- Cấu hình `application.properties`
- Schema GraphQL cơ bản (`Category`, `Product`)
- Entity `Category` và `Product` (quan hệ One-to-Many)
- Repository rỗng (`CategoryRepository`, `ProductRepository`)
- Class khởi chạy `DemoApplication`

## Chưa có (sẽ làm ở các phần sau)

- Service layer
- GraphQL Query / Mutation thực sự
- Seed data
- Thymeleaf pages + AJAX
- CRUD, search, pagination

## Cách chạy

```bash
mvn spring-boot:run
```

Sau khi chạy:
- Ứng dụng lắng nghe tại http://localhost:8080
- GraphiQL: http://localhost:8080/graphiql
- H2 Console: http://localhost:8080/h2-console  
  (JDBC URL: `jdbc:h2:mem:productdb`, User: `sa`, Password: để trống)

## Kiểm tra

Mở GraphiQL và chạy query đơn giản:

```graphql
query {
  _placeholder
}
```

(Kết quả sẽ là `null` vì chưa có resolver – đây là bình thường ở phần 1).
