/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question2sportsevent;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author totca
 */
public class SportsEventManagementSystem { 
     private ArrayList<Question2SportsEvent> eventList = new ArrayList<>();

    // Method to add a sports event
    public void addSportsEvent(Question2SportsEvent event) {
        eventList.add(event);
        System.out.println("Sports event added successfully: " + event.getEventName());
    }

    // Method to register a participant for a sports event
    public void registerParticipant(String eventName, String participantName) {
        for (Question2SportsEvent event : eventList) {
            if (event.getEventName().equalsIgnoreCase(eventName)) {  //Checks the event name ignoring the case
                if (event.registerParticipant(participantName)) {
                    System.out.println(participantName + " registered for " + event.getEventName()); //Registering the participant
                } else {
                    System.out.println(event.getEventName() + " is already full. Cannot register " + participantName); //if there are to many people participating, you cant register as max users have been reached
                }
                return;
            }
        }
        //Error message if sports 
        System.out.println("Sports event not found: " + eventName);
    }

    // Method to display event details
    public void displayEventDetails(String eventName) {
        //Obtaining details of the event
        for (Question2SportsEvent event : eventList) {
            if (event.getEventName().equalsIgnoreCase(eventName)) {
                System.out.println("Event Name: " + event.getEventName());
                System.out.println("Location: " + event.getEventLocation());
                System.out.println("Capacity: " + event.getEventCapacity());
                System.out.println("Participants: " + event.getParticipants().size() + "/" + event.getEventCapacity());
                if (event instanceof RunningRace) {
                    RunningRace runningRace = (RunningRace) event;
                    System.out.println("Distance: " + runningRace.getDistance() + " meters");
                } else if (event instanceof SoccerMatch) {
                    SoccerMatch soccerMatch = (SoccerMatch) event;
                    System.out.println("Home Team: " + soccerMatch.getHomeTeam());
                    System.out.println("Away Team: " + soccerMatch.getAwayTeam());
                }
                return;
            }
        }
        //  Error message if event not found
        System.out.println("Sports event not found: " + eventName);
    }

    public static void main(String[] args) {
        SportsEventManagementSystem eventSystem = new SportsEventManagementSystem();
        Scanner scanner = new Scanner(System.in);
//User is given an option of 2 events, running or soccer
        while (true) {
            System.out.println("Sports Event Management System");
            System.out.println("1. Add Sports Event");
            System.out.println("2. Register Participant");
            System.out.println("3. Display Event Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                //Switch case for user to enter details regarding the event
                case 1:
                    System.out.print("Enter event name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter event location: ");
                    String eventLocation = scanner.nextLine();
                    System.out.print("Enter event capacity: ");
                    int eventCapacity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("1. Running Race\n2. Soccer Match");
                    System.out.print("Enter event type (1 or 2): ");
                    int eventType = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (eventType == 1) {
                        System.out.print("Enter race distance (in meters): ");
                        double distance = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        RunningRace runningRace = new RunningRace(eventName, eventLocation, eventCapacity, distance);
                        eventSystem.addSportsEvent(runningRace);
                    } else if (eventType == 2) {
                        System.out.print("Enter home team: ");
                        String homeTeam = scanner.nextLine();
                        System.out.print("Enter away team: ");
                        String awayTeam = scanner.nextLine();
                        SoccerMatch soccerMatch = new SoccerMatch(eventName, eventLocation, eventCapacity, homeTeam, awayTeam);
                        eventSystem.addSportsEvent(soccerMatch);
                    }
                    break;
                case 2:
                    System.out.print("Enter event name to register participant: ");
                    String eventToRegister = scanner.nextLine();
                    System.out.print("Enter participant name: ");
                    String participantName = scanner.nextLine();
                    eventSystem.registerParticipant(eventToRegister, participantName);
                    break;
                case 3:
                    System.out.print("Enter event name to display details: ");
                    String eventToDisplay = scanner.nextLine();
                    eventSystem.displayEventDetails(eventToDisplay);
                    break;
                case 4:
                    System.out.println("Exiting Sports Event Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
