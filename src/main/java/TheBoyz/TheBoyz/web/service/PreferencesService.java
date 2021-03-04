package TheBoyz.TheBoyz.web.service;

import TheBoyz.TheBoyz.data.model.GeneralPreferences;
import TheBoyz.TheBoyz.data.repository.PreferencesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PreferencesService {

    private final PreferencesRepository preferencesRepository;

    public PreferencesService(PreferencesRepository preferencesRepository) {
        this.preferencesRepository = preferencesRepository;
    }


    public GeneralPreferences getPreferences(String userId){
        System.out.println("in the get preferences in the preferences service");
       GeneralPreferences generalPreferences = preferencesRepository.findByUserId(Integer.valueOf(userId));
       if(generalPreferences == null){
           return null;
       }
        return generalPreferences;
    }

    public GeneralPreferences setPreferences(GeneralPreferences preferences){
        System.out.println("preferences services...");
        System.out.println(preferences.getGeneralPreferencesId());
        System.out.println(preferences.getOnLogin());
        System.out.println(preferences.getUserId());
        GeneralPreferences savedPreference = preferencesRepository.save(preferences);
        GeneralPreferences generalPreferences = preferencesRepository.findByUserId(preferences.getUserId());
        if(savedPreference == null){
            return null;
        }
        return savedPreference;
    }

    public GeneralPreferences updatePreferences(GeneralPreferences preferences){
        GeneralPreferences generalPreferences = preferencesRepository.findByUserId(preferences.getUserId());
        if(generalPreferences == null){
            return null;
        }
        return generalPreferences;
    }
}
