package Persistance.Exceptions;

import Domain.Dto.NewsDto;
import Domain.Dto.ReporterNews;
import Domain.Dto.TagsById;
import Domain.Dto.TagsDto;

public class ExceptionNews extends Throwable {

    public ExceptionNews(){

    }

    public static void VerifyNewIsNullOrIncomplet(NewsDto news){
        if(news == null || !(news instanceof NewsDto)){
            throw new NullPointerException("Objet null ou du mauvais type");
        }
        if(news.getTitre() == null || news.getContenu() == null || news.getDate_news() == null || news.getId() == 0 || news.getId_reporter() == 0){
            throw new IllegalArgumentException("elements de l'objet null");
        }
    }

    public static void VerifyTagIsNullOrIncomplet(TagsById tag){
        if(tag == null || !(tag instanceof TagsById)){
            throw new NullPointerException("Objet null ou du mauvais type");
        }
        if(tag.getTitre() == null || tag.getContenu() == null || tag.getDateNews() == null || tag.getTag() == null){
            throw new IllegalArgumentException("elements de l'objet null");
        }
    }

    public static void VerifyReporterNewsIsNullOrIncomplet(ReporterNews rep){
        if(rep == null || !(rep instanceof ReporterNews)){
            throw new NullPointerException("Objet null ou du mauvais type");
        }
        if(rep.getTitre() == null || rep.getContenu() == null || rep.getDateNews() == null || rep.getIdReporter() == 0){
            throw new IllegalArgumentException("elements de l'objet null");
        }
    }
}
