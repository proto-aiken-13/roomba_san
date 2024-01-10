package roomba.testutil;

import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Executable;

public class Assert {
    public static void assertThrows(Class<? extends Throwable> expectedType,
                                    org.junit.jupiter.api.function.Executable executable) {
        Assertions.assertThrows(expectedType, executable);
    }

    public static void assertThrows(Class<? extends Throwable> expectedType, String expectedMessage,
                                    org.junit.jupiter.api.function.Executable executable) {
        Throwable thrownException = Assertions.assertThrows(expectedType, executable);
        Assertions.assertEquals(expectedMessage, thrownException.getMessage());
    }
}
