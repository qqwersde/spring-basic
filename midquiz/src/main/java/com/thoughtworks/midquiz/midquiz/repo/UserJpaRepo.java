package com.thoughtworks.midquiz.midquiz.repo;

import com.thoughtworks.midquiz.midquiz.Model.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepo extends JpaRepository<UserTest,Long> {
}
