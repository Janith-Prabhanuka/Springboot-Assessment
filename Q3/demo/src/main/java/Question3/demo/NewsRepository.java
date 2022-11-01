package Question3.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends JpaRepository <NewsDetails,Integer>{
    @Query("SELECT n FROM NewsDetails n WHERE n.title LIKE %:title% or  n.description LIKE %:description%")
    List<NewsDetails> findByTitleOrDescription(@Param("title") String title,@Param("description") String description);


    @Query(value="SELECT * FROM news_details  order by no desc limit 10",nativeQuery = true)
    List<NewsDetails> findLatestNews();


}
