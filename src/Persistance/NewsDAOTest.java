package Persistance;

import Domain.Dto.NewsDto;
import org.junit.Assert;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class NewsDAOTest {

    @org.junit.jupiter.api.Test
    void reporterReadById() {
    }

    @org.junit.jupiter.api.Test
    void tagsReadById() {
    }

    @org.junit.jupiter.api.Test
    void insert() {
    }

    @org.junit.jupiter.api.Test
    void getByIdIsInTable() throws SQLException, ClassNotFoundException {
        NewsDAO newsDAO = new NewsDAO();
        NewsDto newsDto = new NewsDto();
        try {
            newsDto = newsDAO.getById(1);
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
        assertEquals("Titre1", newsDto.getTitre());
    }

    @org.junit.jupiter.api.Test
    void getByIdIsNotInTable() throws SQLException, ClassNotFoundException {
        NewsDAO newsDAO = new NewsDAO();
        NewsDto newsDto = new NewsDto();
        try {
            newsDto = newsDAO.getById(1);
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
        assertNotEquals("Titre2", newsDto.getTitre());
    }

    @org.junit.jupiter.api.Test
    void getByIdIsGoodObject() throws SQLException, ClassNotFoundException, ParseException {
        NewsDAO newsDAO = new NewsDAO();
        NewsDto newsDto = new NewsDto();
        NewsDto newDtoTest = new NewsDto("Titre1","blabla", new SimpleDateFormat("dd/MM/yyyy").parse("2007-12-03"),1);
        try {
            newsDto = newsDAO.getById(1);
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
        assertEquals(newDtoTest, newsDto);
    }
}