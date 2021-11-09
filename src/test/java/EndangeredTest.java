import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class EndangeredTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangered_instantiatesWithName_true() {
        Endangered wild = new Endangered("wild", "Endangered", "Healthy", "newborn", "Tsavo", "Julius");
        assertEquals("wild", wild.getName());
    }
    @Test
    public void endangered_instantiatesWithHealth_true() {
        Endangered wild = new Endangered("wild", "Endangered", "ill", "Young", "Tsavo", "Julius");
        assertEquals("ill", wild.getHealth());
    }
    @Test
    public void endangered_instantiatesWithAge_true() {
        Endangered wild = new Endangered("wild", "Endangered", "Healthy", "adult", "Tsavo", "Julius");
        assertEquals("adult", wild.getAge());
    }
    @Test
    public void endangered_instantiatesWithLocation_true() {
        Endangered wild = new Endangered("wild", "Endangered", "Healthy", "Young", "Tsavo", "Julius");
        assertEquals("Tsavo", wild.getLocation());
    }
    @Test
    public void save_returnsTrueForSameDetails() {
        Endangered wild = new Endangered("wild", "Endangered", "Healthy", "newborn", "Tsavo", "Julius");
        wild.save();
        assertTrue(Endangered.all().get(0).equals(wild));
    }
    @Test
    public void getSightings_retrievesAllSightingsFromDatabase_sightingsList() {
        Endangered wild = new Endangered("Rhino", "Endangered", "Healthy", "newborn", "Tsavo", "Julius");
        wild.save();
        Sighting Amboseli = new Sighting(wild.getId(), "Amboseli", "Julius");
        Amboseli.save();
        Sighting Tsavo = new Sighting(wild.getId(), "Tsavo", "Julius");
        Tsavo.save();
        Sighting[] sightings = {Amboseli, Tsavo};
        assertTrue(wild.getSightings().containsAll(Arrays.asList(sightings)));
    }

}