/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package question2sportsevent;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author totca
 */
public class SportsEventManagementSystemIT {
    
    public SportsEventManagementSystemIT() {
    }
   

    @Test
    public void testAddSportsEvent() {
        System.out.println("addSportsEvent");
        Question2SportsEvent event = null;
        SportsEventManagementSystem instance = new SportsEventManagementSystem();
        instance.addSportsEvent(event);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegisterParticipant() {
        System.out.println("registerParticipant");
        String eventName = "Fun Run";
        String participantName = "Michael";
        SportsEventManagementSystem instance = new SportsEventManagementSystem();
        instance.registerParticipant(eventName, participantName);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDisplayEventDetails() {
        System.out.println("displayEventDetails");
        String eventName = "Fun Run";
        SportsEventManagementSystem instance = new SportsEventManagementSystem();
        instance.displayEventDetails(eventName);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SportsEventManagementSystem.main(args);
        fail("The test case is a prototype.");
    }
    
}
