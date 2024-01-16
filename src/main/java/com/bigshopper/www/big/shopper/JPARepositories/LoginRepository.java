package com.bigshopper.www.big.shopper.JPARepositories;


import com.bigshopper.www.big.shopper.Entities.LoginTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginTable, Long> {
    LoginTable findUserByName(String name);
}
