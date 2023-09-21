package question2sportsevent;

import java.util.ArrayList;



// Base class for sports events
class Question2SportsEvent {
    private String eventName;
    private String eventLocation;
    private int eventCapacity;
    private ArrayList<String> participants = new ArrayList<>();
    

    public Question2SportsEvent(String eventName, String eventLocation, int eventCapacity) {
        
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventCapacity = eventCapacity;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public int getEventCapacity() {
        return eventCapacity;
    }

    public ArrayList<String> getParticipants() {
        return participants;
    }

    public boolean isFull() {
        return participants.size() >= eventCapacity;
    }

    public boolean registerParticipant(String participantName) {
        if (!isFull()) {
            participants.add(participantName);
            return true;
        }
        return false;
    }
}

// Subclass for running races
class RunningRace extends Question2SportsEvent {
    private double distance;

    public RunningRace(String eventName, String eventLocation, int eventCapacity, double distance) {
        super(eventName, eventLocation, eventCapacity);
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }
}

// Subclass for soccer matches
class SoccerMatch extends Question2SportsEvent {
    private String homeTeam;
    private String awayTeam;

    public SoccerMatch(String eventName, String eventLocation, int eventCapacity, String homeTeam, String awayTeam) {
        super(eventName, eventLocation, eventCapacity);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }
    
}

