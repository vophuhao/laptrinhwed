package vn.iostart.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import vn.iostart.models.User;



public interface UserRepository extends JpaRepository<User, Long> {
	User  findByUserName(String userName);
	
}
