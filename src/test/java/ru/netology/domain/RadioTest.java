package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(9);
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 10;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void trySetVolumeOverMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(11);      // попробовали выставить громкость выше 10
        int actual = radio.getCurrentVolume();
        int expected = 10;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(10);
        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void trySetVolumeUnderMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);     // попробовали снизить громкость ниже 0
        int actual = radio.getCurrentVolume();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSetNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);     // канал на котором находится радио
        radio.nextStation();            // нажимаем кнопку "channel +"
        int actual = radio.getCurrentStation();
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSetPreviousStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);     // канал на котором находится радио
        radio.previousStation();        // нажимаем кнопку "channel -"
        int actual = radio.getCurrentStation();
        int expected = 8;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void shouldSetNextStationAfter9() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);     // канал на котором находится радио
        radio.nextStation();            // нажимаем кнопку "channel +"
        int actual = radio.getCurrentStation();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSetPreviousStationAfter0() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);     // канал на котором находится радио
        radio.previousStation();        // нажимаем кнопку "channel -"
        int actual = radio.getCurrentStation();
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }
}
