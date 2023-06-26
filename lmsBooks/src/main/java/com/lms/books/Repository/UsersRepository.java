package com.lms.books.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lms.books.Model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, String>{

}
