package ru.netology.domain;

public class Radio {

    private int currentStation;      // задаем приватное поле для станции
    private int currentVolume;       // задаем приватное поле для громкости

    public void setCurrentStation(int currentStation) {  // сеттер с проверкой на допустимость номера станции
        if (currentStation < 0) {
            return;
        }
        if (currentStation > 9) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void setCurrentVolume(int currentVolume) {   // сеттер для возможного диапозона громкости
        if (currentVolume < 0) {
            return;
        }
        if (currentVolume > 10) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setAnyStation(int newStation) {  // метод проверки корректности номера вводимой станции - пункт 4 условия задачи
        setCurrentStation(newStation);
    }

    public void nextStation() {           // метод переключения на следующую станцию
        int newCurrentStation;
        if (currentStation < 9) {
            newCurrentStation = currentStation + 1;
        } else newCurrentStation = 0;
        setCurrentStation(newCurrentStation);
    }

    public void previousStation() {        // метод переключения на предыдущую станцию
        int newCurrentStation;
        if (currentStation > 0) {
            newCurrentStation = currentStation - 1;
        } else newCurrentStation = 9;
        setCurrentStation(newCurrentStation);
    }

    public void increaseVolume() {          // метод для увеличения громкости
        int newCurrentVolume = currentVolume + 1;
        setCurrentVolume(newCurrentVolume);
    }

    public void decreaseVolume() {          // метод для уменьшения громкости
        int newCurrentVolume = currentVolume - 1;
        setCurrentVolume(newCurrentVolume);
    }
}