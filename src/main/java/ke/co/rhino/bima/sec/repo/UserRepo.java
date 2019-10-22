package ke.co.rhino.bima.sec.repo;

import ke.co.rhino.bima.sec.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
