import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateNotLimit() {
        BonusService service = new BonusService();

        long amount = 100060;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);
        long limit = 0;

        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateEqualsLimit() {
        BonusService service = new BonusService();

        long amount = 100060;
        boolean registered = true;
        long expected = 30;
        long limit = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateRegisteredAndMinAmount() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateNotRegisteredAndMinAmount() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = false;

        long expected = 0;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateRegisteredAndMaxAmount() {
        BonusService service = new BonusService();

        long amount = 9_223_372_036_854_775_807l;
        boolean registered = true;

        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateNotRegisteredAndMaxAmount() {
        BonusService service = new BonusService();

        long amount = 9223372036854775807l;
        boolean registered = false;

        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 100060;
        boolean registered = true;

        long expected = 30;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 100060;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}