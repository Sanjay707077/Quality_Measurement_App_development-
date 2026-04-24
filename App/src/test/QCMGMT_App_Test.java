package test;

import Main.QCMGMT_App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QCMGMT_App_Test {

    // ---------- SAME UNIT TESTS ----------
    @Test
    void testYardToYard_SameValue() {
        QCMGMT_App.Yards a = new QCMGMT_App.Yards(1);
        QCMGMT_App.Yards b = new QCMGMT_App.Yards(1);
        assertTrue(a.equals(b));
    }

    @Test
    void testYardToYard_DifferentValue() {
        QCMGMT_App.Yards a = new QCMGMT_App.Yards(1);
        QCMGMT_App.Yards b = new QCMGMT_App.Yards(2);
        assertFalse(a.equals(b));
    }

    // ---------- CROSS UNIT TESTS ----------
    @Test
    void testYardToFeet() {
        QCMGMT_App.Yards yard = new QCMGMT_App.Yards(1);
        QCMGMT_App.Feet feet = new QCMGMT_App.Feet(3);
        assertTrue(yard.equals(feet));
    }

    @Test
    void testYardToInches() {
        QCMGMT_App.Yards yard = new QCMGMT_App.Yards(1);
        QCMGMT_App.Inches inch = new QCMGMT_App.Inches(36);
        assertTrue(yard.equals(inch));
    }

    @Test
    void testCmToCm() {
        QCMGMT_App.Centimeters a = new QCMGMT_App.Centimeters(2);
        QCMGMT_App.Centimeters b = new QCMGMT_App.Centimeters(2);
        assertTrue(a.equals(b));
    }

    @Test
    void testCmToInch() {
        QCMGMT_App.Centimeters cm = new QCMGMT_App.Centimeters(1);
        QCMGMT_App.Inches inch = new QCMGMT_App.Inches(0.393701);
        assertTrue(cm.equals(inch));
    }

    @Test
    void testCmToFeet_NotEqual() {
        QCMGMT_App.Centimeters cm = new QCMGMT_App.Centimeters(1);
        QCMGMT_App.Feet feet = new QCMGMT_App.Feet(1);
        assertFalse(cm.equals(feet));
    }

    // ---------- EQUALITY CONTRACT TESTS ----------
    @Test
    void testTransitiveProperty() {
        QCMGMT_App.Yards yard = new QCMGMT_App.Yards(1);
        QCMGMT_App.Feet feet = new QCMGMT_App.Feet(3);
        QCMGMT_App.Inches inch = new QCMGMT_App.Inches(36);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inch));
        assertTrue(yard.equals(inch));
    }

    @Test
    void testSameReference() {
        QCMGMT_App.Yards a = new QCMGMT_App.Yards(1);
        assertTrue(a.equals(a));
    }

    @Test
    void testNullComparison() {
        QCMGMT_App.Yards a = new QCMGMT_App.Yards(1);
        assertFalse(a.equals(null));
    }

    @Test
    void testInvalidTypeComparison() {
        QCMGMT_App.Inches i = new QCMGMT_App.Inches(1);
        String text = "abc";
        assertFalse(i.equals(text));
    }

    // ---------- HASHCODE TEST ----------
    @Test
    void testHashCodeConsistency() {
        QCMGMT_App.Yards yard = new QCMGMT_App.Yards(1);
        QCMGMT_App.Feet feet = new QCMGMT_App.Feet(3);

        assertTrue(yard.equals(feet));
        assertEquals(yard.hashCode(), feet.hashCode());
    }
}