package Abduvaliev_Abbos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ApplicationContext appContext;

    private  DefaultListableBeanFactory beanFactory =
            new DefaultListableBeanFactory();

    @GetMapping(value = "/show")
    public @ResponseBody List<String> getBeanList() {
        return Arrays.asList(beanFactory.getBeanDefinitionNames());
    }


    @RequestMapping(value = "/beans" , method = RequestMethod.POST, produces = "application/json")
    public void insertUser(@RequestBody File file ) {
        String filepath = "D:\\\\БелГУ\\\\JavaLabs\\\\DataLab2.csv";
        if (file.getFileName() != null){
            filepath = file.getFileName();
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line = null;
            Scanner scanner = null;
            Card card = new Card();
            int index = 0;

            BeanDefinitionBuilder cardBean = BeanDefinitionBuilder.rootBeanDefinition(Card.class);
            BeanDefinitionBuilder personBean = BeanDefinitionBuilder.rootBeanDefinition(Person.class);


            while ((line = reader.readLine()) != null) {
                scanner = new Scanner(line);
                scanner.useDelimiter(";");
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    if (index == 0) {
                        System.out.println(data);
                        personBean.addPropertyValue("name", data);
                    }else if (index == 1)
                        personBean.addPropertyValue("age", Integer.parseInt(data));
                    else if (index == 2)
                        cardBean.addPropertyValue("type", data);
                    else if (index == 3)
                        cardBean.addPropertyValue("accountNumber", data);
                    else if (index == 4) {
                        Date date1=new SimpleDateFormat("dd.MM.yyyy").parse(data);
                        cardBean.addPropertyValue("endDate", date1);
                    }else
                        System.out.println("Некорректные данные::" + data);
                    index++;
                }
                beanFactory.registerBeanDefinition("cardBean", cardBean.getBeanDefinition());
                Card bean = beanFactory.getBean(Card.class);
                personBean.addPropertyValue("cards", bean);

                beanFactory.registerBeanDefinition("personBean", personBean.getBeanDefinition());
                index = 0;


            }
            Person person = beanFactory.getBean(Person.class);
            person.showAll();

            //закрываем наш ридер
            reader.close();

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
