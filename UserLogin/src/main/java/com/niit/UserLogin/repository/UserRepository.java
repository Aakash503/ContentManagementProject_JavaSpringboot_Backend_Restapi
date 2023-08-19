package com.niit.UserLogin.repository;

import com.niit.UserLogin.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String>
{
    public User findByUsernameAndPassword(String username, String password);
    public User findByUsername(String username);
    public boolean deleteByUsername(String username);
}
