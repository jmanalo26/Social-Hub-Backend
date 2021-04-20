package TheBoyz.TheBoyz.data.repository;

import TheBoyz.TheBoyz.data.model.GeneralPreferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferencesRepository extends JpaRepository<GeneralPreferences, Long> {
    public GeneralPreferences findByUserId(int userId);
}
