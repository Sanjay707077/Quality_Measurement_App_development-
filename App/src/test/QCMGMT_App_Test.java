package test;
import Main.QCMGMT_App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QCMGMT_App_Test {

    @Test
    void testEquality_SameValue() {
        QCMGMT_App.Feet f1 = new QCMGMT_App.Feet(1.0);
        QCMGMT_App.Feet f2 = new QCMGMT_App.Feet(1.0);

        assertTrue(f1.equals(f2), "1.0 ft should equal 1.0 ft");
    }

    @Test
    void testEquality_DifferentValue() {
        QCMGMT_App.Feet f1 = new QCMGMT_App.Feet(1.0);
        QCMGMT_App.Feet f2 = new QCMGMT_App.Feet(2.0);

        assertFalse(f1.equals(f2), "1.0 ft should not equal 2.0 ft");
    }

    @Test
    void testEquality_NullComparison() {
        QCMGMT_App.Feet f1 = new QCMGMT_App.Feet(1.0);

        assertFalse(f1.equals(null), "Value should not equal null");
    }

    @Test
    void testEquality_NonNumericInput() {
        QCMGMT_App.Feet f1 = new QCMGMT_App.Feet(1.0);
        String nonNumeric = "abc";

        assertFalse(f1.equals(nonNumeric), "Should not equal non-numeric input");
    }

    @Test
    void testEquality_SameReference() {
        QCMGMT_App.Feet f1 = new QCMGMT_App.Feet(1.0);

        assertTrue(f1.equals(f1), "Same object reference should be equal");
    }
}