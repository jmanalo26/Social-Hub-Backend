package TheBoyz.TheBoyz.data.repository;

import TheBoyz.TheBoyz.data.model.TwitterData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TwitterDataRepository extends JpaRepository<TwitterData, Long> {

    public TwitterData findByUserId(int id);

    public TwitterData findByTwitterHandle(String twitterHandle);
}
