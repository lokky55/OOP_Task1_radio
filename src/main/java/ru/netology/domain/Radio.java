package ru.netology.domain;

public class Radio {

    private int currentStation;      // задаем приватное поле для станции
    private int currentVolume;       // задаем приватное поле для громкости
    private int stationsQuantity;    // инициализируем поле для количества радиостанций

    public void setCurrentStation(int currentStation) {  // сеттер с проверкой на допустимость номера станции
        if (currentStation < 0) {
            return;
        }
        if (currentStation > stationsQuantity - 1) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void setCurrentVolume(int currentVolume) {   // сеттер для возможного диапозона громкости
        if (currentVolume < 0) {
            return;
        }
        if (currentVolume > 100) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public Radio(int stationsQuantity) {   // создаем констурктор, принимающий параметром желаемое кол-во радиостанций и сохраняющего это значение у себя в поле
        this.stationsQuantity = stationsQuantity;
    }

    public Radio () {                     // создаем конструктор без параметров где указано кол-во радиостанций по умолчанию
        this.stationsQuantity = 10;
    }

    public int getQuantityOfStations() {  // создадим геттер для вызова кол-ва радиостанций
        return stationsQuantity;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setAnyStation(int newStation) {  // выставление номера станции с пульта
        setCurrentStation(newStation);
    }

    public void nextStation() {           // метод переключения на следующую станцию
        int newCurrentStation;
        if (currentStation < stationsQuantity - 1) {
            newCurrentStation = currentStation + 1;
        } else {
            newCurrentStation = 0;
        }
        setCurrentStation(newCurrentStation);
    }

    public void previousStation() {        // метод переключения на предыдущую станцию
        int newCurrentStation;
        if (currentStation > 0) {
            newCurrentStation = currentStation - 1;
        } else {
            newCurrentStation = stationsQuantity - 1;
        }
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