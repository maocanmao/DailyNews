package philips.com.zdaily.data.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Zhou Yang on 2017/2/17.
 */

@Getter
@Setter
public class NewsEntity {
    String date;
    List<Story> stories;
    List<TopStory> top_stories;


    @Getter
   public class Story{
        String title;
        List<String> images;
        String id;
    }

    @Getter
   public class TopStory{
        String title;
        String image;
        String id;
    }
}
