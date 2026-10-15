import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertieDAOxml implements PropertieDAO {
    @Override
    public Properties load() {
        try (BufferedReader br = new BufferedReader(new FileReader("conf.properties"))) {

        } catch (IOException e) {

        }
    }

    @Override
    public void save() {
        try () {

        }

    }
}
