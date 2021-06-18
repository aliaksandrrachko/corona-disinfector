package by.ales.services;

import by.ales.api.services.Announcer;
import by.ales.api.services.Recommend;
import by.ales.core.annotations.InjectByType;
import by.ales.core.annotations.Singleton;

@Singleton
public class ConsoleAnnouncer implements Announcer {

    @InjectByType
    private Recommend recommend;

    @Override
    public void announce(String message) {
        System.out.println(message);
        recommend.recommend();
    }
}
