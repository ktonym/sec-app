package ke.co.rhino.bima.sec.service;

import ke.co.rhino.bima.sec.model.User;
import ke.co.rhino.bima.sec.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser = repo.findByUsername(username);
        UserDetails user = new org.springframework.security.core
                .userdetails.User(username, currentUser.getPassword()
                , true, true, true, true,
                AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }
}
