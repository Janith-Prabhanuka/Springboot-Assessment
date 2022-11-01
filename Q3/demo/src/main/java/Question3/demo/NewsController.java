package Question3.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news")
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("")
    public ResponseEntity <List <NewsDetails>> getNews(
            @RequestParam(value = "title" ,required = false) String title,
            @RequestParam(value = "description" ,required = false) String description
            ){
                List<NewsDetails> newsDet= newsRepository.findByTitleOrDescription(title,description);
                return ResponseEntity.ok(newsDet);
    }


    @GetMapping("/summary")
    public ResponseEntity<List<NewsDetails>> getNewsSummary(){
        List<NewsDetails> newsDet= newsRepository.findLatestNews();
        return ResponseEntity.ok(newsDet);
    }
}
