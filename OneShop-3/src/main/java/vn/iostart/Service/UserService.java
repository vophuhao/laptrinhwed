package vn.iostart.Service;




import vn.iostart.models.User;


public interface UserService  {
	
	User findByUsername(String username);
}
