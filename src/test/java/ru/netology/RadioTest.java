package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {
    Radio rad = new Radio();
    @Test
    void createRadio() {
        String expected = "Radio";
        assertNull(rad.getName());
        rad.setName(expected);
        assertEquals(expected, rad.getName());
    }
    @Test
    void initFields(){
        assertEquals(9, rad.getMaxStation());
        assertEquals(0, rad.getMinStation());
        assertEquals(10, rad.getMaxVolume());
        assertEquals(0, rad.getMinVolume());
        assertFalse(rad.isOn());
    }

    @Test
    void shouldNotSetStationBelowMin() {
        rad.setCurrentStation(5);

        rad.setCurrentStation(-1);
        assertEquals(5, rad.getCurrentStation());
    }

    @Test
    void shouldNotSetStationAboveMax() {
        rad.setCurrentStation(9);

        rad.setCurrentStation(10);
        assertEquals(9, rad.getCurrentStation());
    }
    @Test
    void increaseStation(){
        rad.setCurrentStation(3);

        rad.increaseStation();
        assertEquals(4,rad.getCurrentStation());
    }
    @Test
    void transitionFromMaxToMinStation(){
        rad.setCurrentStation(9);

        rad.increaseStation();
        assertEquals(0,rad.getCurrentStation());
    }
    @Test
    void downStation(){
        rad.setCurrentStation(2);

        rad.downStation();
        assertEquals(1,rad.getCurrentStation());
    }
    @Test
    void transitionFromMimToMaxStation(){
        rad.setCurrentStation(0);

        rad.downStation();
        assertEquals(9,rad.getCurrentStation());
    }

    @Test
    void shouldNotSetVolumeBelowMin() {
        rad.setCurrentVolume(5);

        rad.setCurrentVolume(-1);
        assertEquals(5, rad.getCurrentVolume());
    }
    @Test
    void shouldNotSetVolumeAboveMax() {
        rad.setCurrentVolume(10);

        rad.setCurrentVolume(11);
        assertEquals(10, rad.getCurrentVolume());
    }
    @Test
    void increaseVolume(){
        rad.setCurrentVolume(6);

        rad.increaseVolume();
        assertEquals(7,rad.getCurrentVolume());
    }
    @Test
    void transitionFromMaxToMinVolume(){
        rad.setCurrentVolume(10);

        rad.increaseVolume();
        assertEquals(0,rad.getCurrentVolume());
    }
    @Test
    void downVolume(){
        rad.setCurrentVolume(6);

        rad.downVolume();
        assertEquals(5,rad.getCurrentVolume());
    }
    @Test
    void transitionFromMinToMaxVolume(){
        rad.setCurrentVolume(0);

        rad.downVolume();
        assertEquals(10,rad.getCurrentVolume());
    }

}