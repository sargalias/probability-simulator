package probabilitySimulator.program.information;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import probabilitySimulator.queries.Query;

class SimpleInformationTest {

    @Test
    void information_calls_query_getAllInfo_method() {
        Query mockQuery = mock(Query.class);
        SimpleInformation si = new SimpleInformation(mockQuery);
        si.information();
        verify(mockQuery).getAllInfo();
    }

    @Test
    void information_returns_obtainedResults() {
        Query mockQuery = mock(Query.class);
        String expected = "This is a test string";
        when(mockQuery.getAllInfo()).thenReturn(expected);
        SimpleInformation si = new SimpleInformation(mockQuery);
        assertEquals(expected, si.information());
    }

}