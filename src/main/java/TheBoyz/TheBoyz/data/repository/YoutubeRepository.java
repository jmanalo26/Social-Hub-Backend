package TheBoyz.TheBoyz.data.repository;

import TheBoyz.TheBoyz.data.model.Youtube;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YoutubeRepository extends JpaRepository<Youtube, Long> {
    public Youtube findUserByChannelId(String username);
    public Youtube findUserByUsernameSH(String s);
}