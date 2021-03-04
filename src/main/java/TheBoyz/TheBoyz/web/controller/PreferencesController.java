package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.data.model.GeneralPreferences;
import TheBoyz.TheBoyz.web.service.PreferencesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class PreferencesController {
    private final PreferencesService preferencesService;

    public PreferencesController(PreferencesService preferencesService) {
        this.preferencesService = preferencesService;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/api/preferences/retrieve/{userId}")
    public ResponseEntity<GeneralPreferences> getUserPreferences(@PathVariable String userId){
        System.out.println("in the get mapping for preferences");
        return new ResponseEntity<>(preferencesService.getPreferences(userId),HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/api/preferences/create")
    public ResponseEntity<GeneralPreferences> postUserPreferences(@RequestBody GeneralPreferences generalPreferences){
        System.out.println("in the post mapping for user preferences, PREFERENCES CONTROLLER");
        return new ResponseEntity<>(preferencesService.setPreferences(generalPreferences),HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value="/api/preferences/update")
    public ResponseEntity<GeneralPreferences> updateUserPreferences(@RequestBody GeneralPreferences generalPreferences){
        return new ResponseEntity<>(preferencesService.updatePreferences(generalPreferences),HttpStatus.OK);
    }
    
}
