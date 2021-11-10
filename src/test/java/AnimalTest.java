import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animals_instantiatesCorrectly_true() {
        Animal wild = new Animal("Rhino");
        assertTrue(wild instanceof Animal);
    }
    @Test
    public void equals_returnsTrueIfNameAndIdAreEqual() {
        Animal wild = new Animal("Rhino");
        Animal tame = new Animal("Rhino");
        assertTrue(wild.equals(tame));
    }
    @Test
    public void save_insertsObjectIntoDatabase_Animal() {
        Animal wild = new Animal("Lucky");
        wild.save();
        assertTrue(Animal.all().get(0).equals(wild));
    }
    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        Animal wild = new Animal("wild");
        wild.save();
        Animal tame = new Animal("tame");
        tame.save();
        Animal anime = new Animal("anime");
        anime.save();
        assertTrue(Animal.all().get(0).equals(wild));
        assertTrue(Animal.all().get(1).equals(tame));
        assertTrue(Animal.all().get(2).equals(anime));
    }
    @Test
    public void save_assignsIdToObject() {
        Animal wild = new Animal("Lucky");
        wild.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(wild.getId(), savedAnimal.getId());
    }
    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animal wild = new Animal("Lucky");
        wild.save();
        Animal tame = new Animal("Becky");
        tame.save();
        assertEquals(Animal.find(tame.getId()), wild);
    }
    @Test
    public void getSightings_retrievesAllSightingsFromDatabase_sightingsList() {
        Animal wild = new Animal("wild");
        wild.save();
        Sighting Tsavo = new Sighting(wild.getId(), "Nairobi", "Becky");
        Tsavo.save();
        Sighting Amboseli = new Sighting(wild.getId(), "Kisumu", "Bucky");
        Amboseli.save();
        Sighting[] sightings = {Tsavo, Amboseli};
        assertTrue(wild.getSightings().containsAll(Arrays.asList(sightings)));
    }

}