import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "sitati", "Access");
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-3-92-119-83.compute-1.amazonaws.com:5432/d7old5hsbjkqm4", "qkobqpnyotbkek","69228f5000c01877893dc747578f59f25ba53696b3de5fef398a82f0a0cfae71" ); //!

}
