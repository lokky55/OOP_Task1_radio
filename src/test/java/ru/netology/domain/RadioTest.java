package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    Radio radio = new Radio();

    @Test
    void setQuantityOfStations() {       // создадим тест для проверки задания необходимо кол-ва радиостанций
        Radio radio = new Radio(10);
        int actual = radio.getStationsQuantity();
        int expected = 10;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setNumberOutOfRangeUnderMin() {
        radio.setAnyStation(-1);       // пробуем выставить станцию с пульта на -1
        int actual = radio.getCurrentStation();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setNumberOutOfRangeOverMax() {
        radio.setAnyStation(10);       // пробуем выставить станцию с пульта на 10
        int actual = radio.getCurrentStation();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSetNextStation() {
        radio.setCurrentStation(8);     // канал на котором находится радио
        radio.nextStation();            // нажимаем кнопку "next"
        int actual = radio.getCurrentStation();
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSetPreviousStation() {
        radio.setCurrentStation(1);     // канал на котором находится радио
        radio.previousStation();        // нажимаем кнопку "prev"
        int actual = radio.getCurrentStation();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSet0StationAfter9WhenIncrease() {
        radio.setCurrentStation(9);     // канал на котором находится радио
        radio.nextStation();            // нажимаем кнопку "next"
        int actual = radio.getCurrentStation();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSet9StationAfter0WhenDecrease() {
        radio.setCurrentStation(0);     // канал на котором находится радио
        radio.previousStation();        // нажимаем кнопку "prev"
        int actual = radio.getCurrentStation();
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolume() {
        radio.setCurrentVolume(9);       // актуальная громкость
        radio.increaseVolume();          // увеличиваем громкость
        int actual = radio.getCurrentVolume();
        int expected = 10;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void trySetVolumeOverMax() {
        radio.setCurrentVolume(100);   // выставлена максимальная громкость
        radio.increaseVolume();        // пробуем увеличить громкость
        int actual = radio.getCurrentVolume();
        int expected = 100;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolume() {
        radio.setCurrentVolume(10);     // актуальная громкость
        radio.decreaseVolume();         // уменьшаем громкость
        int actual = radio.getCurrentVolume();
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void trySetVolumeUnderMin() {
        radio.setCurrentVolume(0);     // выставлена минимальная громкость
        radio.decreaseVolume();        // пробуем уменьшить громкость
        int actual = radio.getCurrentVolume();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }
}
