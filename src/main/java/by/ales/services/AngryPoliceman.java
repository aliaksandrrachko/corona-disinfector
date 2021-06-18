package by.ales.services;

import by.ales.api.services.Policeman;
import by.ales.core.annotations.Singleton;

@Singleton
public class AngryPoliceman implements Policeman {
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("I'll kill everyone!");
    }
}
