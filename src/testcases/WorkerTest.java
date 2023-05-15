package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Worker;
import model.WorkerStatus;

public class WorkerTest {

    @Test
    public void testGetId() {
        Worker worker = new Worker(1, "Bob Johnson", "456 Elm St", "555-5678", WorkerStatus.AVAILABLE);
        assertEquals(1, worker.getId());
    }

    @Test
    public void testGetName() {
        Worker worker = new Worker(1, "Bob Johnson", "456 Elm St", "555-5678", WorkerStatus.AVAILABLE);
        assertEquals("Bob Johnson", worker.getName());
    }

    @Test
    public void testGetAddress() {
        Worker worker = new Worker(1, "Bob Johnson", "456 Elm St", "555-5678", WorkerStatus.AVAILABLE);
        assertEquals("456 Elm St", worker.getAddress());
    }

    @Test
    public void testGetPhone() {
        Worker worker = new Worker(1, "Bob Johnson", "456 Elm St", "555-5678", WorkerStatus.AVAILABLE);
        assertEquals("555-5678", worker.getPhone());
    }

    @Test
    public void testGetStatus() {
        Worker worker = new Worker(1, "Bob Johnson", "456 Elm St", "555-5678", WorkerStatus.AVAILABLE);
        assertEquals(WorkerStatus.AVAILABLE, worker.getStatus());
    }

    @Test
    public void testSetStatus() {
        Worker worker = new Worker(1, "Bob Johnson", "456 Elm St", "555-5678", WorkerStatus.AVAILABLE);
        worker.setStatus(WorkerStatus.BUSY);
        assertEquals(WorkerStatus.BUSY, worker.getStatus());
    }

}
