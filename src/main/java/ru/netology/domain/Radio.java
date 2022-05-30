package ru.netology.domain;

public class Radio {

    private int currentVolume;   // задаем приватное поле для громкости

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < 0) {
            currentVolume = 0;
        }
        if (currentVolume > 10) {
            currentVolume = 10;
        }
        this.currentVolume = currentVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        int newCurrentVolume = currentVolume + 1;
        setCurrentVolume(newCurrentVolume);
    }

    public void decreaseVolume() {
        int newCurrentVolume = currentVolume - 1;
        setCurrentVolume(newCurrentVolume);
    }

    private int currentStation;      // задаем приватное поле для станции

    public void setCurrentStation(int currentStation) {
        this.currentStation = currentStation;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void nextStation() {
        int newCurrentStation;
        if (currentStation < 9) {
            newCurrentStation = currentStation + 1;
        } else {
            newCurrentStation = 0;
        }
        setCurrentStation(newCurrentStation);
    }

    public void previousStation() {
        int newCurrentStation;
        if (currentStation <= 0) {
            newCurrentStation = 9;
        } else {
            newCurrentStation = currentStation - 1;
        }
        setCurrentStation(newCurrentStation);
    }
}