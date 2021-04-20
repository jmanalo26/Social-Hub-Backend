package TheBoyz.TheBoyz.data.repository;

import TheBoyz.TheBoyz.data.model.OnePosts;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 */
public interface OnePostRepository extends JpaRepository<OnePosts, Long> {

    public List<OnePosts> findByUserId(int userId);

}
