/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.hibrnate.util;

import com.webproject.bookstore.model.dal.hibrnate.daoImp.BookDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.CategoryDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.OfferDao;
import com.webproject.bookstore.model.dal.hibrnate.entities.Book;
import com.webproject.bookstore.model.dal.hibrnate.entities.Category;
import com.webproject.bookstore.model.dal.hibrnate.entities.Offer;
import com.webproject.bookstore.model.dal.hibrnate.util.DaoFactory;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.HibernateException;

/**
 *
 * @author Ibrahim
 */
public class DataBaseIntializer {

    BookDao bookDao;
    CategoryDao categoryDao;
    OfferDao offerDao;

    public DataBaseIntializer() {
        bookDao = DaoFactory.getBookDao();
        categoryDao = DaoFactory.getCategoryDao();
        offerDao = DaoFactory.getOfferDao();
    }

    private List<Book> getListOfBooksFrpmFile(String fileName) throws IOException, InvalidFormatException
            ,HibernateException {

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        List<Book> bookList = new ArrayList<>();

        sheet.forEach((row) -> {
            try {
                String bookTitle = dataFormatter.formatCellValue(row.getCell(0)).trim();
                String authorName = dataFormatter.formatCellValue(row.getCell(2)).trim();
                String discraption = dataFormatter.formatCellValue(row.getCell(4)).trim();
                String categoryName = dataFormatter.formatCellValue(row.getCell(3)).trim().toLowerCase();
                double price = row.getCell(5).getNumericCellValue();
                int pagesNumber = new Double(row.getCell(6).getNumericCellValue()).intValue();
                int imageNumbers = new Double(row.getCell(7).getNumericCellValue()).intValue();
                int visits = generateRandom(1, 10);
                double rate = generateRandom(1, 5);
                int quantity = generateRandom(2, 7);
                int soldAmount = generateRandom(1, 5);
                int offerID = generateRandom(1, 3);
                
                boolean available = true;
                Category category = categoryDao.getByName(categoryName);
                Offer offer = offerDao.getByID(offerID);
                Book book = new Book(category, offer, bookTitle, discraption, authorName, price, null, visits,
                        rate, quantity, pagesNumber, soldAmount, available, null,imageNumbers);
                bookList.add(book);
            } catch (HibernateException ex) {
                throw ex;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        return bookList;
    }

    public int generateRandom(int start, int end) throws HibernateException{
        Random random = new Random();
        return random.ints(start, (end + 1)).findFirst().getAsInt();
    }

    public void insertListOfBooks(List<Book> bookList) throws HibernateException{
        bookList.forEach((book) -> {
            try {
                Book book1 = bookDao.insert(book);
            } catch (Exception ex) {
                Logger.getLogger(DataBaseIntializer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void fillBooks() throws IOException, InvalidFormatException ,HibernateException{
        List<Book> bookList = getListOfBooksFrpmFile("files/library.xlsx");
        insertListOfBooks(bookList);
        System.out.println("/////insertation done");
    }

    public void fillCategories() throws HibernateException {
        categoryDao.insert(new Category(1, "programming"));
        categoryDao.insert(new Category(2, "business"));
        categoryDao.insert(new Category(3, "science fiction"));
        categoryDao.insert(new Category(4, "food and cooking"));
        categoryDao.insert(new Category(5, "childeren"));
    }

    public void fillOffers() throws ParseException, HibernateException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        offerDao.insert(new Offer(1, 0, dateFormat.parse("2020-6-7")));
        offerDao.insert(new Offer(2, 20, dateFormat.parse("2019-6-7")));
        offerDao.insert(new Offer(3, 30, dateFormat.parse("2019-4-5")));
    }
}
