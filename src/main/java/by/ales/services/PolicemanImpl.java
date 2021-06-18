package by.ales.services;

import by.ales.api.services.Policeman;
import by.ales.api.services.Recommend;
import by.ales.core.annotations.InjectByType;
import by.ales.core.annotations.PostConstruct;
import by.ales.core.annotations.Singleton;

@Singleton
public class PolicemanImpl implements Policeman {

    @InjectByType
    private Recommend recommend;

    @PostConstruct
    public void init() {
        System.out.println(recommend.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Go away, stupid peoples!");
    }
}
