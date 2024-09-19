package vn.iostart.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.iostart.models.CustomUserDetail;
import vn.iostart.models.UserRole;
import vn.iostart.models.User;
@Service
public class CustomUserDetailService  implements UserDetailsService{
	@Autowired
	private UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user =userService.findByUsername(username);
			if(user==null)
			{
				throw new UsernameNotFoundException("sai");
			}
			Collection<GrantedAuthority> grantedAuthoritySet =new HashSet<>();
			Set<UserRole> roles=user.getUserRoles();
			for (UserRole userRole: roles) {
			grantedAuthoritySet.add(new SimpleGrantedAuthority (userRole.getRole().getName()));
			}
			return new CustomUserDetail(user,grantedAuthoritySet);
	}

}
