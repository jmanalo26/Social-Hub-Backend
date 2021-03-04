package TheBoyz.TheBoyz.data.repository;

import TheBoyz.TheBoyz.data.model.SecureTwitter;
import TheBoyz.TheBoyz.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TwitterRepository extends JpaRepository<SecureTwitter, Long> {

    public SecureTwitter findSecureTwitterByUserId(int userId);
}
