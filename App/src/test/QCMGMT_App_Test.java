package test;

import Main.QCMGMT_App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QCMGMT_App_Test {

    double eps = 1e-6;

    // ---------- CONVERSION TESTS ----------
    @Test
    void testConversion_FeetToInches() {
        QCMGMT_App.Feet f = new QCMGMT_App.Feet(1);
        assertEquals(12.0, f.toInches(), eps);
    }

    @Test
    void testConversion_InchesToFeet() {
        QCMGMT_App.Inches i = new QCMGMT_App.Inches(24);
        assertEquals(2.0, i.toInches() / 12.0, eps);
    }

    @Test
    void testConversion_YardsToInches() {
        QCMGMT_App.Yards y = new QCMGMT_App.Yards(1);
        assertEquals(36.0, y.toInches(), eps);
    }

    @Test
    void testConversion_FeetToYards() {
        QCMGMT_App.Feet f = new QCMGMT_App.Feet(6);
        assertEquals(2.0, f.toInches() / 36.0, eps);
    }

    @Test
    void testConversion_CmToInches() {
        QCMGMT_App.Centimeters cm = new QCMGMT_App.Centimeters(2.54);
        assertEquals(1.0, cm.toInches(), 1e-4);
    }

    // ---------- ROUND TRIP ----------
    @Test
    void testRoundTrip() {
        double x = 5.5;

        QCMGMT_App.Feet f = new QCMGMT_App.Feet(x);
        double cm = f.toInches() / 0.393701;

        QCMGMT_App.Centimeters cmObj = new QCMGMT_App.Centimeters(cm);
        double back = cmObj.toInches() / 12.0;

        assertEquals(x, back, 1e-5);
    }

    // ---------- EDGE CASES ----------
    @Test
    void testZero() {
        QCMGMT_App.Feet f = new QCMGMT_App.Feet(0);
        assertEquals(0.0, f.toInches(), eps);
    }

    @Test
    void testNegative() {
        QCMGMT_App.Feet f = new QCMGMT_App.Feet(-1);
        assertEquals(-12.0, f.toInches(), eps);
    }

    @Test
    void testSameUnit() {
        QCMGMT_App.Feet f = new QCMGMT_App.Feet(5);
        assertEquals(5.0, f.toInches() / 12.0, eps);
    }

    // ---------- VALIDATION ----------
    @Test
    void testInvalidValue_NaN() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new QCMGMT_App.Feet(Double.NaN)
        );
    }

    @Test
    void testInvalidValue_Infinite() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new QCMGMT_App.Inches(Double.POSITIVE_INFINITY)
        );
    }
}