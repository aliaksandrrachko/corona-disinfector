package by.ales.main;

import by.ales.entities.Room;
import by.ales.api.services.Policeman;
import by.ales.core.ApplicationContext;
import by.ales.core.Application;
import by.ales.services.AngryPoliceman;
import by.ales.services.CoronaDisinfection;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //CoronaDisinfection coronaDisinfection = ObjectFactory.getInstance().createObject(CoronaDisinfection.class);
        ApplicationContext context = Application.run("by.ales", new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));
        CoronaDisinfection coronaDisinfection = context.getObject(CoronaDisinfection.class);
        coronaDisinfection.start(new Room());
    }
}
