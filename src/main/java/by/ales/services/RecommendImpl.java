package by.ales.services;

import by.ales.api.services.Recommend;
import by.ales.core.annotations.InjectProperty;
import by.ales.core.annotations.Singleton;
import by.ales.core.annotations.TimeBenchmark;

@Singleton
@Deprecated
public class RecommendImpl implements Recommend {
    @InjectProperty("whiskey")
    private String alcohol;

    public RecommendImpl() {
        System.out.println("recommend was create");
    }

    @Override
    @TimeBenchmark
    public void recommend() {
        System.out.println("to protect from COVID-2021, drink " + alcohol);
    }
}
