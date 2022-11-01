package Question3.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class NewsDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int no;
        private String title;
        @Lob
        @Column
        private String description;

        public NewsDetails(String title, String description) {
                this.title = title;
                this.description = description;
        }
}
