package TheBoyz.TheBoyz.data.repository;

import TheBoyz.TheBoyz.data.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
   public Page<User> findByUserIdContainingOrderByUserId(Long userId, Pageable pageable);

   public User findUserByUsername(String username);
}
