package com.lucaffo.dinotodo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/// Repository stand for JPA Repository
/// This interface will be used to access user data table with the
/// most common query. You can implement a custom query in different ways
/// [JPA Custom Query](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html)
@Repository
public interface UserRepository extends JpaRepository<User, Long> {}