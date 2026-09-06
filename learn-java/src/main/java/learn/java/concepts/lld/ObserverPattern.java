package learn.java.concepts.lld;

import java.net.http.WebSocketHandshakeException;
import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    /**
     * Observer Pattern - A behavioural design pattern
     *
     * - Object(Observable or Publisher) maintains a list of dependents ( Observers )
     * - Automatically notifies dependents whenever there is a change in its state
     *
     *
     * - Applications
     * - Weather app which is subscribes by multiple end users
     * - Social media
     * - Stock market trackers
     *
     *
     * 2 Models
     *
     * Push - Observable pushes the data it wants observer to receive.
     * Pull - Observer holds observable object reference and when it got to know something updated it,
     *        pulls the data whatever it needs using observable object.
     *
     *
     *
     */




    private class WeatherData{
        String humidity;
    }


    // Push Model

    private interface Observable{

        void add(Observer o);
        void remove(Observer o);
        void notifyObservers();
        void serWeatherData(WeatherData wd);

    }

    private class WeatherStation implements Observable{

        private static List<Observer> observerList = new ArrayList<>();
        private static WeatherData wd;

        @Override
        public void add(Observer o) {
            observerList.add(o);
        }

        @Override
        public void remove(Observer o) {
            observerList.remove(o);
        }

        @Override
        public void notifyObservers() {
            for(Observer o : observerList){
                o.update(wd);
            }
        }

        @Override
        public void serWeatherData(WeatherData wb) {
            this.wd = wd;
        }
    }


    private interface Observer{
        void update(WeatherData wd);
    }

    private class CurrentDisplay implements Observer{

        @Override
        public void update(WeatherData wd) {
            // business logic
        }
    }

    private class Forecast implements Observer{

        @Override
        public void update(WeatherData wd) {
            // business logic
        }
    }


}
