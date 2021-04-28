package TheBoyz.TheBoyz.data.repository;

import TheBoyz.TheBoyz.data.model.InstaUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstagramRepository extends JpaRepository<InstaUser, Long> {
    public InstaUser findInstaUserByUsername(String username);
    public InstaUser findInstaUserByInstaId(int instaId);



}
