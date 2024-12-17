package com.bot.watsappbot.SERVISEs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bot.watsappbot.NEW.Main;
import com.bot.watsappbot.repo.MainRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MainService {

    @Autowired
    private MainRepository mainRepo;

    // Save a new Main object
    public Main saveMain(Main main) {
        return mainRepo.save(main);
    }

    // Get a Main object by ID
    public Main getMainById(int id) {
        Optional<Main> main = mainRepo.findById(id);
        return main.orElse(null);
    }

    // Get all Main objects
    public List<Main> getAllMains() {
        return mainRepo.findAll();
    }

    // Update a Main object by ID
    public Main updateMain(int id, Main mainDetails) {
        Optional<Main> mainOptional = mainRepo.findById(id);
        if (mainOptional.isPresent()) {
            Main main = mainOptional.get();
            main.setSESSIONID(mainDetails.getSESSIONID());
            main.setNMAE(mainDetails.getNMAE());
            return mainRepo.save(main);
        }
        return null;
    }

    // Delete a Main object by ID
    public void deleteMain(int id) {
        mainRepo.deleteById(id);
    }
}
