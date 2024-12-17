package com.bot.watsappbot.SERVISEs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bot.watsappbot.SERVISEs.SessionIdService;
import com.bot.watsappbot.NEW.SessionId;
import com.bot.watsappbot.repo.SessionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SessionIdService {

    @Autowired
    private SessionRepository sessionIdRepo;


    // Save a new SessionId object
    public SessionId saveSessionId(SessionId sessionId) {
        return sessionIdRepo.save(sessionId);
    }

    // Get a SessionId object by ID
    public SessionId getSessionIdById(int id) {
        System.out.println("before......................");
        Optional<SessionId> sessionId = sessionIdRepo.findById(id);
        System.out.println(sessionId);
        return sessionId.orElse(null);
    }

    // Get all SessionId objects
    public List<SessionId> getAllSessionIds() {
        return sessionIdRepo.findAll();
    }

    // Update a SessionId object by ID
    public SessionId updateSessionId(int id, SessionId sessionIdDetails) {
        Optional<SessionId> sessionIdOptional = sessionIdRepo.findById(id);
        if (sessionIdOptional.isPresent()) {
            SessionId sessionId = sessionIdOptional.get();
            sessionId.setSessionId(sessionIdDetails.getSessionId());
            sessionId.setSender(sessionIdDetails.getSender());
            sessionId.setStatus(sessionIdDetails.getStatus());
            return sessionIdRepo.save(sessionId);
        }
        return null;
    }

    // Delete a SessionId object by ID
    public void deleteSessionId(int id) {
        sessionIdRepo.deleteById(id);
    }



    public String getSessionIdBySender(String sender) {
        System.out.println("Function invoked....................................");

        SessionId existingSession = sessionIdRepo.findBySender(sender);

        if (existingSession != null) {
            return existingSession.getSessionId();
        } else {
            SessionId newSession = new SessionId();
            newSession.setSender(sender);
            newSession.setSessionId("home");
            newSession.setStatus(0);
            sessionIdRepo.save(newSession);
            return "home";
        }
    }
    
    

    public String updateSessionIdBySender(String sender, String newSessionId) {
        // Fetch existing session by sender
        Optional<SessionId> existingSession = Optional.ofNullable(sessionIdRepo.findBySender(sender));

        if (existingSession.isPresent()) {
            // Update the sessionId for the existing session
            SessionId session = existingSession.get();
            session.setSessionId(newSessionId);  // Update sessionId field
            sessionIdRepo.save(session);  // Save the updated session
            return session.getSessionId();  // Return the updated sessionId
        } else {
            // Optionally, create a new session if no existing session is found
            SessionId newSession = new SessionId();
            newSession.setSender(sender);
            newSession.setSessionId("home");  // Set new sessionId
            newSession.setStatus(0);  // You can set the default status value here
            sessionIdRepo.save(newSession);  // Save new session
            return newSession.getSessionId();  // Return the newly created sessionId
        }
    }
    
    
}