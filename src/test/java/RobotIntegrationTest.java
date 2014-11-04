import com.rea.model.Direction;
import com.rea.model.Robot;
import com.rea.service.RobotAdapter;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RobotIntegrationTest {
    private RobotAdapter adapter;

    @Before
    public void before() {
        adapter = new RobotAdapter();
    }

    @Test
    public void shouldPlace() throws Exception {
        adapter.input("PLACE 0,0,NORTH");
        assertEquals("0,0,NORTH", adapter.input("REPORT"));
    }

    @Test
    public void shouldPlaceAndMove() throws Exception {
        adapter.input("PLACE 0,0,NORTH");
        adapter.input("MOVE");
        assertEquals("0,1,NORTH", adapter.input("REPORT"));
    }

    @Test
    public void shouldPlaceAndRotate() throws Exception {
        adapter.input("PLACE 0,0,NORTH");
        adapter.input("LEFT");
        assertEquals("0,0,WEST", adapter.input("REPORT"));
    }

    @Test
    public void shouldPlaceAndReplace() throws Exception {
        adapter.input("PLACE 0,0,NORTH");
        adapter.input("MOVE");
        adapter.input("PLACE 3,4,SOUTH");
        assertEquals("3,4,SOUTH", adapter.input("REPORT"));
    }

    @Test
    public void shouldMoveAndRotate() throws Exception {
        adapter.input("PLACE 1,2,EAST");
        adapter.input("MOVE");
        adapter.input("MOVE");
        adapter.input("LEFT");
        adapter.input("MOVE");
        assertEquals("3,3,NORTH", adapter.input("REPORT"));
    }

    @Test
    public void shouldIgnoreInputsBeforeValidPlace() throws Exception {
        adapter.input("PLACE -1,0,NORTH");
        adapter.input("LEFT");
        assertEquals("", adapter.input("REPORT"));
    }

    @Test
    public void shouldNotFallOffTable() throws Exception {
        adapter.input("PLACE 10,2,EAST");
        adapter.input("MOVE");
        adapter.input("PLACE 4,4,NORTH");
        adapter.input("MOVE");
        adapter.input("LEFT");

        for (int i = 0; i < 7; i++) {
            adapter.input("MOVE");
        }

        assertEquals("0,4,WEST", adapter.input("REPORT"));
    }

    @Test
    public void shouldReturnEmptyStringOnPlace() throws Exception {
        assertEquals("", adapter.input("PLACE 0,0,NORTH"));
    }

    @Test
    public void shouldReturnEmptyStringOnLeft() throws Exception {
        assertEquals("", adapter.input("LEFT"));
    }

    @Test
    public void shouldReturnEmptyStringOnRight() throws Exception {
        assertEquals("", adapter.input("RIGHT"));
    }

    @Test
    public void shouldReturnEmptyStringOnMOVE() throws Exception {
        assertEquals("", adapter.input("MOVE"));
    }
}