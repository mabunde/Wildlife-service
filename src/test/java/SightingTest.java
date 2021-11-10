import org.junit.Rule;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void rangerName_returnRangerName_true() {
        Sighting sightedAnimal = new Sighting(1, "Zone A", "Julius");
        assertEquals("Julius", sightedAnimal.getRangerName());
    }
    @Test
    public void animalId_getsAnimalId() {
        Sighting sightedAnimal = new Sighting(1, "Zone A", "Julius");
        assertEquals(1, sightedAnimal.getAnimalId());
    }
    @Test
    public void get_animalsWithSameId_secondAnimal() {
        Sighting sightedAnimal = new Sighting(1, "Zone A", "Julius");
        Sighting sightedSecondAnimal = new Sighting(1, "Zone A", "Julius");
        assertTrue(sightedAnimal.equals(sightedSecondAnimal));
    }
    @Test
    public void all_returnsAllInstancesOfSighting() {
        Sighting sightedAnimal1 = new Sighting(1, "Zone A", "Julius");
        sightedAnimal1.save();
        Sighting sightedAnimal2 = new Sighting(2, "Zone B", "Mike");
        sightedAnimal2.save();
        Sighting sightedAnimal3 = new Sighting(3, "Zone C", "Tomashi");
        sightedAnimal3.save();
        assertEquals(true, Sighting.all().get(0).equals(sightedAnimal1));
        assertEquals(true, Sighting.all().get(1).equals(sightedAnimal2));
        assertEquals(true, Sighting.all().get(2).equals(sightedAnimal3));
    }
    @Test
    public void find_returnsSightingWithTheSameId() {
        Sighting sighting1 = new Sighting(1, "Zone A", "Julius");
        sighting1.save();
        Sighting sighting2 = new Sighting(2, "Zone B", "Mike");
        sighting2.save();
        assertEquals(Sighting.find(sighting2.getId()), sighting2);
    }
    @Test
    public void save_saveEndangeredIdIntoDatabase_true() {
        Animal wild = new Animal("Wild");
        wild.save();
        Sighting Amboseli = new Sighting(wild.getId(), "Zone A", "Julius");
        Amboseli.save();
        assertEquals(Amboseli.getAnimalId(), wild.getId());
    }
    @Test
    public void save_recordsTimeOfSightingInDataBase() {
        Sighting testSighting = new Sighting(1, "Tsavo", "Julius");
        testSighting.save();
        Timestamp savedSighting = Sighting.find(testSighting.getId()).getLastSighting();
        Timestamp rightNow = new Timestamp(new Date().getTime());
        assertEquals(rightNow.getDay(),savedSighting.getDay());
    }

    }