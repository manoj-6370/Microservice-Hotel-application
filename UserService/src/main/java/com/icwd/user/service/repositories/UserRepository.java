package com.icwd.user.service.repositories;

import com.icwd.user.service.entities.User;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,String>
{

}
