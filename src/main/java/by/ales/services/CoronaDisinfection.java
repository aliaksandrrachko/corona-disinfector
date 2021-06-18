package by.ales.services;

import by.ales.core.annotations.Singleton;
import by.ales.core.annotations.TimeBenchmark;
import by.ales.entities.Room;
import by.ales.api.services.Announcer;
import by.ales.api.services.Policeman;
import by.ales.core.annotations.InjectByType;

@Deprecated
@Singleton
public class CoronaDisinfection {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

    @TimeBenchmark
    public void start(Room room){
        announcer.announce("Start disinfecting, all away!");
        policeman.makePeopleLeaveRoom();
        disinfect(room);
        announcer.announce("Go to inside!");
    }

    private void disinfect(Room room){
        System.out.println("Process of disinfecting running!"+ room + "\n Corona went away!");
    }
}
