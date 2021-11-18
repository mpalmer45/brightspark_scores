import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import java.util.List;

public class YAMLHelper {
    public static String generateYAML(List<Record> list) throws JsonProcessingException {
        if(list == null)
            return "";

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));

        return mapper.writeValueAsString(list);
    }
}
