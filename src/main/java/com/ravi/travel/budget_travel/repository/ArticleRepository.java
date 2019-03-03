package com.ravi.travel.budget_travel.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ravi.travel.budget_travel.domain.Article;
import com.ravi.travel.budget_travel.domain.Author;
import com.ravi.travel.budget_travel.domain.Destination;
import com.ravi.travel.budget_travel.domain.Paragraph;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

//@Component
public class ArticleRepository {

    private static AtomicLong count = new AtomicLong(0);

    private static List<Article> articles = new ArrayList<>();

    private static Map<String,List<Article>> authorMap = new HashMap<>();

    static {
    /*  articles.add(new Article(count.getAndIncrement(),"Rishikesh Trip","rahul" ,0L));
      articles.add(new Article(count.getAndIncrement(),"Hyderbad Trip","laxmi" ,0L));
      articles.add(new Article(count.getAndIncrement(),"Pune Trip","laxmi" ,0L));
      articles.add(new Article(count.getAndIncrement(),"Bhramtal Trip","rishi" ,0L));
      articles.add(new Article(count.getAndIncrement(),"Kasol Trip","ravi" ,0L));
      articles.forEach(ArticleRepository::addArticleInMap
      );*/
  }

    public  List<Article> getArticles() {
        return articles;
    }

    public Article saveArticle(Article article){
        //article.setId(count.getAndIncrement());
        articles.add(article);
        addArticleInMap(article);
        return article;
    }

    public List<Article> getArticle(String author){
        return authorMap.get(author);
    }

    @NonNull
    private static void addArticleInMap(Article article) {
        if (Objects.nonNull(authorMap.get(article.getAuthor()))) {
            authorMap.get(article.getAuthor()).add(article);
        }else {
            List<Article> articles = new ArrayList<>();
            articles.add(article);
            authorMap.put(article.getAuthor().getName(),articles);
        }
    }

    public Article getArticleByTitleAndAuthor(){
        Article article = new Article();
        article.setTitle("Grahan ... A Hidden Gem Of Himachal Pradesh");
        Author author = new Author();
        author.setName("Ravi Singh");
        //author.setJobDescription("Travel Blogger");
        article.setAuthor(author);
        //article.setCreatedTime("April 5, 2018 at 12:00 PM");

        Destination destination = new Destination();
        //destination.setCountry("India");
        //destination.setState("Himachal Pradesh");
        destination.setDestinationName("Grahan Village");

        article.setDestination(destination);

       //article.setArticleImage("../../assets/images/articles/grahan.jpg");
        article.setArticleBrief("How often do you get a chance to wake up to the chirping of birds and view of the giantic Himalayas ?\n" +
                "Well , Let me take you to the Grahan , My last trekking destination to make that experience as feeling.");

        List<Paragraph> paragraphs = new ArrayList<>();

        paragraphs.add(new Paragraph("\"Life is not about the final moment but its about the journey we take to reach the destination\". And I realized this when booked the bus ticket to Kullu from Delhi from March 30 ,2018"));

        /*paragraphs.add(new Paragraph("The HRTC bus departed at 7:00PM from Kashmiri Gate Bus Terminal adn that is when our jouyney to Grahan Village also began. The bus passed through major cities like Sonipat , Panipat ,Kurusheshtra and\n" +
                "        Karnal. After 13hours long journey we finally reached Bhuntar. From Bhuntar , we catched a local bus to Kasol at early in the morning at 6:30AM . Even though it was morning , but Bus was full packed with passengers.","../../assets/images/articles/grahan.jpg"));
*/
        paragraphs.add(new Paragraph("We reached Kasol at 8:00PM. After getting fresh finally we fed ourself with maggi and some chocolates. And then our trek to Grahan village started.\n" +
                "        In front of us, there was a dense forest and above a giant rocky mountain. I felt like they were waiting for us to show their splendid beauty."));

        paragraphs.add(new Paragraph("The trails were full of twist and turns . Sometimes it pases through the rocky hills where putting your foot on the right place itself was a big challenge and sometimes it passes\n" +
                "          along the tributires of Paravati river. The sound of the water in forest and hills was not less then anu musical concert. We fed lot of splendid views of majestic Himalayas to our eyes. We reached\n" +
                "          Grahan around 2:30 PM."));

        paragraphs.add(new Paragraph("First thing we did is we booked a home stay and given rest to our body. After two hours , we realize the place where we took rest was very different. There is no electricity in day time.\n" +
                "          and building were completely constructed with wood. They don't even had ceiling fan. We totally disconnected from the rest of world because there is not internet , mobile network and even electricity.\n" +
                "          The temprature changed dramatically at night. We felt like we entered in the month of december just after March. We stayed there for two days and witnessed the life of local people, the struggle they do for everything."));

        paragraphs.add(new Paragraph("Trek to Grahan was truly a special journey. I took back lot of stories and beautiful memory of lovely people of Grahan."));
        //article.setDescription(paragraphs);

        List<Paragraph> bestTimeToVisit = new ArrayList<>();
        bestTimeToVisit.add(new Paragraph("Weather of kasol is pleasant through out the year except December end."));
        //article.setBestTimeToVisit(bestTimeToVisit);

        List<Paragraph> itenary = new ArrayList<>();
        itenary.add(new Paragraph("Day1 : Evening Bus @7:00 PM from Kashmiri Gate to Kullu."));
        itenary.add(new Paragraph("Day 2: Get down at Bhuntar. Take Bus or Taxi from Bhuntar to Kasol. Prefer Local bus. Its fare will be just 50\n" +
                "              rs if you are budget traveller. Have Breakfast at kasol and start your trek as early as possible. Reached\n" +
                "              Grahan by 2 or 3. Guest house are easily available. Take some rest and roam in village.\n" +
                "              You can have your dinner at Old Kishna Gues house but Mount view owner prepared nice parantha."));

        itenary.add(new Paragraph("Day 3 : Start around 8:30 or 9:00 AM for Waterfall. Enjoy the scenic view of majestic himalaya."));
        itenary.add(new Paragraph("Day4 : Start early morning to kasol. Take shortest way to reach kasol. From Kasol you can go to manikaran or\n" +
                "              back to Bhuntar or Kullu to catch your bus."));
        //article.setItenary(itenary);

        List<Paragraph> howToReach = new ArrayList<>();
        howToReach.add(new Paragraph("http://online.hrtchp.com/oprs-web/"));
        //article.setHowToReach(howToReach);

        List<String> videos = new ArrayList<>();
        videos.add("https://www.youtube.com/embed/GZpr2t_Y7Fk");
        //article.setVideos(videos);

        return article;

    }
}
