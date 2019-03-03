package com.ravi.travel.budget_travel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ravi.travel.budget_travel.domain.*;
import com.ravi.travel.budget_travel.utilities.ArticleType;
import com.ravi.travel.budget_travel.utilities.SocialMedia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] zz) throws JsonProcessingException {

        Author author = new Author();
        author.setId(1);
        author.setName("Ravi Singh");
        author.setEmail("singrce@gmail.com");
        author.setPhoneNumber("1234567890");
        author.setAuthorized(false);
        author.setAuhorizedBy(SocialMedia.GOOGLE);
        author.setProfilePicUrl("../../assets/images/IMG_0477.JPG");
        author.setBriefInformation("Travel Blogger");

        List<LetsConnect> letsConnects = new ArrayList<>();

        LetsConnect facebook = new LetsConnect();
        facebook.setId(1);
        facebook.setAuthor(author);
        facebook.setSocialMedia(SocialMedia.FACEBOOK);
        facebook.setSocialMediaUrl("https://www.facebook.com/ravi.singhsw");
        letsConnects.add(facebook);

        LetsConnect google = new LetsConnect();
        google.setId(2);
        google.setAuthor(author);
        google.setSocialMedia(SocialMedia.GOOGLE);
        google.setSocialMediaUrl("https://plus.google.com/u/0/102843333311851835463");
        letsConnects.add(google);

        LetsConnect youTube = new LetsConnect();
        youTube.setId(3);
        youTube.setAuthor(author);
        youTube.setSocialMedia(SocialMedia.YOUTUBE);
        youTube.setSocialMediaUrl("https://www.youtube.com/channel/UCEo2Yu6yleHu1wloUPVpEMQ");
        letsConnects.add(youTube);

        author.setLetsConnect(letsConnects);

        ObjectMapper mapper = new ObjectMapper();
        String jsonauthor = mapper.writeValueAsString(author);

        System.out.println("Author  :: "+jsonauthor);

        Article article = new Article();
        article.setId(1);
        article.setTitle("Grahan...A Hidden Gem of Himachal Pradesh");
        article.setArticleType(ArticleType.TREK);
        article.setAuthor(author);

        Destination destination = new Destination();
        destination.setId(1);
        destination.setDestinationName("Grahan");
        destination.setCity("Kasol");
        destination.setDistrict("Shimla");

        State state = new State();
        state.setId(1);
        state.setStateName("Himachal Pradesh");
        destination.setState(state);

        Country country = new Country();
        country.setId(1);
        country.setCountryName("Name");
        destination.setCountry(country);

        article.setDestination(destination);



        ArticleDocument articleDocument = new ArticleDocument();
        articleDocument.setId(0);
        articleDocument.setArticleImage("../../assets/images/articles/grahan.jpg");

        List<Paragraph> paragraphs = new ArrayList<>();
        Paragraph paragraph1 = new Paragraph();
        paragraph1.setParagraph("Life is not about the final moment but its about the journey we take to reach the destination\". And I realized this when booked the bus ticket to Kullu from Delhi from March 30 ,2018");

        paragraphs.add(paragraph1);

        Paragraph paragraph2 = new Paragraph();
        paragraph2.setParagraph("The HRTC bus departed at 7:00PM from Kashmiri Gate Bus Terminal adn that is when our jouyney to Grahan Village also began. The bus passed through major cities like Sonipat , Panipat ,Kurusheshtra and\n" +
                "Karnal. After 13hours long journey we finally reached Bhuntar. From Bhuntar , we catched a local bus to Kasol at early in the morning at 6:30AM . Even though it was morning , but Bus was full packed with passengers");
        paragraph2.setImageUrl("../../assets/images/articles/grahan.jpg");
        paragraph2.setImageDestination("Bhuntar");
        paragraphs.add(paragraph2);

        Paragraph paragraph3 = new Paragraph();
        paragraph3.setParagraph("We reached Kasol at 8:00PM. After getting fresh finally we fed ourself with maggi and some chocolates. And then our trek to Grahan village started." +
                "In front of us, there was a dense forest and above a giant rocky mountain. I felt like they were waiting for us to show their splendid beauty.");
        paragraphs.add(paragraph3);

        Paragraph paragraph4 = new Paragraph();
        paragraph4.setParagraph("The trails were full of twist and turns . Sometimes it pases through the rocky hills where putting your foot on the right place itself was a big challenge and sometimes it passes\n" +
                "          along the tributires of Paravati river. The sound of the water in forest and hills was not less then anu musical concert. We fed lot of splendid views of majestic Himalayas to our eyes. We reached\n" +
                "          Grahan around 2:30 PM.");



        paragraphs.add(paragraph4);

        Paragraph paragraph5 = new Paragraph();
        paragraph5.setParagraph("First thing we did is we booked a home stay and given rest to our body. After two hours , we realize the place where we took rest was very different. There is no electricity in day time.\n" +
                "          and building were completely constructed with wood. They don't even had ceiling fan. We totally disconnected from the rest of world because there is not internet , mobile network and even electricity.\n" +
                "          The temprature changed dramatically at night. We felt like we entered in the month of december just after March. We stayed there for two days and witnessed the life of local people, the struggle they do for everything.");
        paragraphs.add(paragraph5);

        Paragraph paragraph6 = new Paragraph();
        paragraph6.setParagraph("Trek to Grahan was truly a special journey. I took back lot of stories and beautiful memory of lovely people of Grahan.");

        paragraphs.add(paragraph6);


        // TODO :: article
        articleDocument.setParagraphs(paragraphs);
        article.setArticleDocument(articleDocument);

        article.setArticleBrief("How often do you get a chance to wake up to the chirping of birds and view of the giantic Himalayas ?\n" +
                "Well , Let me take you to the Grahan , My last trekking destination to make that experience as feeling.");
        article.setCreatedTime(new Date());
        article.setModifiedTime(new Date());

        article.setArticleReadCount(0);
        article.setUpVote(0);
        article.setDownVote(0);








        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String articleJson = mapper.writeValueAsString(article);
        System.out.println("Article Json  :: "+articleJson);

    }
    public static void main2(String[] args) throws JsonProcessingException {

        /*Article article = new Article();
        article.setTitle("Grahan ... A Hidden Gem Of Himachal Pradesh");
        Author author = new Author();
        author.setName("Ravi Singh");
        author.setJobDescription("Travel Blogger");
        article.setAuthor(author);
        article.setCreatedTime("April 5, 2018 at 12:00 PM");

        Destination destination = new Destination();
        destination.setCountry("India");
        destination.setState("Himachal Pradesh");
        destination.setDestinationName("Grahan Village");

        article.setDestination(destination);

        article.setArticleImage("../../assets/images/articles/grahan.jpg");
        article.setArticleBrief("How often do you get a chance to wake up to the chirping of birds and view of the giantic Himalayas ?\n" +
                "Well , Let me take you to the Grahan , My last trekking destination to make that experience as feeling.");

        List<Paragraph> paragraphs = new ArrayList<>();

        paragraphs.add(new Paragraph("\"Life is not about the final moment but its about the journey we take to reach the destination\". And I realized this when booked the bus ticket to Kullu from Delhi from March 30 ,2018"));

        paragraphs.add(new Paragraph("The HRTC bus departed at 7:00PM from Kashmiri Gate Bus Terminal adn that is when our jouyney to Grahan Village also began. The bus passed through major cities like Sonipat , Panipat ,Kurusheshtra and\n" +
                "        Karnal. After 13hours long journey we finally reached Bhuntar. From Bhuntar , we catched a local bus to Kasol at early in the morning at 6:30AM . Even though it was morning , but Bus was full packed with passengers.","../../assets/images/articles/grahan.jpg"));

        paragraphs.add(new Paragraph("We reached Kasol at 8:00PM. After getting fresh finally we fed ourself with maggi and some chocolates. And then our trek to Grahan village started.\n" +
                "        In front of us, there was a dense forest and above a giant rocky mountain. I felt like they were waiting for us to show their splendid beauty."));

        paragraphs.add(new Paragraph("The trails were full of twist and turns . Sometimes it pases through the rocky hills where putting your foot on the right place itself was a big challenge and sometimes it passes\n" +
                "          along the tributires of Paravati river. The sound of the water in forest and hills was not less then anu musical concert. We fed lot of splendid views of majestic Himalayas to our eyes. We reached\n" +
                "          Grahan around 2:30 PM."));

        paragraphs.add(new Paragraph("First thing we did is we booked a home stay and given rest to our body. After two hours , we realize the place where we took rest was very different. There is no electricity in day time.\n" +
                "          and building were completely constructed with wood. They don't even had ceiling fan. We totally disconnected from the rest of world because there is not internet , mobile network and even electricity.\n" +
                "          The temprature changed dramatically at night. We felt like we entered in the month of december just after March. We stayed there for two days and witnessed the life of local people, the struggle they do for everything."));

        paragraphs.add(new Paragraph("Trek to Grahan was truly a special journey. I took back lot of stories and beautiful memory of lovely people of Grahan."));
        article.setDescription(paragraphs);

        List<Paragraph> bestTimeToVisit = new ArrayList<>();
        bestTimeToVisit.add(new Paragraph("Weather of kasol is pleasant through out the year except December end."));
        article.setBestTimeToVisit(bestTimeToVisit);

        List<Paragraph> itenary = new ArrayList<>();
        itenary.add(new Paragraph("Day1 : Evening Bus @7:00 PM from Kashmiri Gate to Kullu."));
        itenary.add(new Paragraph("Day 2: Get down at Bhuntar. Take Bus or Taxi from Bhuntar to Kasol. Prefer Local bus. Its fare will be just 50\n" +
                "              rs if you are budget traveller. Have Breakfast at kasol and start your trek as early as possible. Reached\n" +
                "              Grahan by 2 or 3. Guest house are easily available. Take some rest and roam in village.\n" +
                "              You can have your dinner at Old Kishna Gues house but Mount view owner prepared nice parantha."));

        itenary.add(new Paragraph("Day 3 : Start around 8:30 or 9:00 AM for Waterfall. Enjoy the scenic view of majestic himalaya."));
        itenary.add(new Paragraph("Day4 : Start early morning to kasol. Take shortest way to reach kasol. From Kasol you can go to manikaran or\n" +
                "              back to Bhuntar or Kullu to catch your bus."));
        article.setItenary(itenary);

        List<Paragraph> howToReach = new ArrayList<>();
        howToReach.add(new Paragraph("http://online.hrtchp.com/oprs-web/"));
        article.setHowToReach(howToReach);

        List<String> videos = new ArrayList<>();
        videos.add("https://www.youtube.com/embed/GZpr2t_Y7Fk");
        article.setVideos(videos);*/
        ObjectMapper mapper = new ObjectMapper();
       // String jsonArticle = mapper.writeValueAsString(article);

        //System.out.println("Article :: "+jsonArticle);

    }
}
