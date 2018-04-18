package probabilitySimulator.program.controllers;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import java.util.List;

public class SimpleControllerTest {

    @Test
    void name() {
        List ml = mock(List.class);
        ml.add(1);
        verify(ml).add(1);
    }
}