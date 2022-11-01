package Question3.demo;


import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import lombok.experimental.FieldNameConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URL;

@Configuration
@EnableScheduling
public class ScheduleReader {
    @Autowired
    private NewsRepository newsRepository;
   @Scheduled(cron = "* 59 23 * * *")
  //  @Scheduled(fixedDelay = 5000)

    private void reader(){

        try {
            String url = "http://www.adaderana.lk/rss.php";

            try (XmlReader reader = new XmlReader(new URL(url))) {
                SyndFeed feed = new SyndFeedInput().build(reader);


                for (SyndEntry entry : feed.getEntries()) {

                    String title= entry.getTitle();
                    String description=entry.getDescription().getValue();
                    NewsDetails news = new NewsDetails(title,description);
                    newsRepository.save(news);
                }

            }
        }  catch (Exception e) {
            e.printStackTrace();
        }


    }

}
