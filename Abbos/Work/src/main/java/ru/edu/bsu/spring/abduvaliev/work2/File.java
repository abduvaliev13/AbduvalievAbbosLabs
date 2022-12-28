package ru.edu.bsu.spring.abduvaliev.work2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class File {
    private final List<String> FileNames = new ArrayList<>();
    private final ApplicationContext context;
    private final ObjectMapper mapper;
    public File(ApplicationContext context, ObjectMapper mapper) {
        this.context = context;
        this.mapper = mapper;
    }
    @SuppressWarnings("unchecked")
    public <A extends Object> List<ObjectNode> create(String fileName) throws IOException, CsvException, ClassNotFoundException {
        List<ObjectNode> list = new ArrayList<>();
        CSVParser csvParser = new CSVParserBuilder().withSeparator('|').build();
        java.io.File file = ResourceUtils.getFile(fileName);
        LogManager.getLogger().warn(file.getPath());
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(csvParser).withSkipLines(1).build()) {
            List<String[]> lines = reader.readAll();
            for (String[] line : lines) {
                String name = line[0];
                Class<A> clazz = (Class<A>) Class.forName(line[1]);
                A value;
                if (clazz == Person.class) {
                    value = mapper.readValue(line[2], clazz);
                } else {
                    value = mapper.convertValue(line[2], clazz);
                }
                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(clazz, () -> value);
                BeanDefinition definition = builder.getBeanDefinition();
                BeanDefinitionRegistry factory = (BeanDefinitionRegistry) context.getAutowireCapableBeanFactory();
                factory.registerBeanDefinition(name, definition);
                FileNames.add(name);
            }
            for (String[] line : lines) {
                String name = line[0];
                Object bean = context.getBean(name);
                ObjectNode json = mapper.createObjectNode();
                json.put(name, bean.toString());
                list.add(json);
            }
        }
        return list;
    }
}