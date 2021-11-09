import org.junit.Rule;
import org.junit.Test;

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

}