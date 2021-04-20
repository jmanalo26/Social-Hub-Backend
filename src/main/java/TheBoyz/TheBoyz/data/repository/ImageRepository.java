package TheBoyz.TheBoyz.data.repository;

import java.util.Optional;

import TheBoyz.TheBoyz.data.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
    Optional<ImageModel> findByName(String name);
}
