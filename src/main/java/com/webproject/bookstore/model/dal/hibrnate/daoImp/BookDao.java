/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.hibrnate.daoImp;

import com.webproject.bookstore.model.dal.hibrnate.daoInt.AbstractDaoInt;
import com.webproject.bookstore.model.dal.hibrnate.entities.Book;
import com.webproject.bookstore.model.dal.hibrnate.entities.Category;
import com.webproject.bookstore.model.dal.hibrnate.util.SessionManager;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ibrahim
 */
public class BookDao extends SuperDao<Book> {

    public BookDao(Session session) throws UnsupportedOperationException {
        super(session,new Book());
    }

    @Override
    public synchronized Book insert(Book book) throws HibernateException {
        if (book.getKeys() == null) {
            book.setKeys(book.getAuthorName() +" "+ book.getTitle() +" "+ book.getCategory().getCategoryName());
        }
        book.setReviews(1);
        if(book.getImg()==null){
            String imageName = Arrays.stream(book.getTitle().trim().split(" ")).collect(Collectors.joining());
        imageName = imageName.replace("/", "").replace("\\", "").replace("?", "")
                .replace(">", "").replace("*", "").replace("|", "").replace("<", "")
                .replace(":", "").replace("\"", "").replace("\'", "&apos;").replace("..", "")
                .replace(".", "").replace("―", "").replace("/", "").replace("\\", "").replace("?", "");
        imageName="books/"+imageName+".jpg";
        book.setImg(imageName);
        }
        return super.insert(book);
    }

    public Book getBookByID(int id) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(Book.class).add(Restrictions.idEq(id));
        Book book = (Book) bookCriteria.uniqueResult();
        session.getTransaction().commit();
        return book;
    }

    public Book getBookByName(String bookName) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(Book.class)
                .add(Restrictions.eq("title", bookName));
        Book book = (Book) bookCriteria.uniqueResult();
        session.getTransaction().commit();
        return book;
    }

    public List<Book> getAllBooksforAuthor(String author, int returnedMaxNumber) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(Book.class)
                .add(Restrictions.eq("authorName", author)).setMaxResults(returnedMaxNumber);
        List<Book> bookList = bookCriteria.list();
        session.getTransaction().commit();
        return bookList;
    }

    public List<Book> getAllBooksInCategory(String categoryName, int returnedMaxNumber) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(Book.class)
                .createCriteria("category")
                .add(Restrictions.eq("categoryName", categoryName)).setMaxResults(returnedMaxNumber);
        List<Book> bookList = bookCriteria.list();
        session.getTransaction().commit();
        return bookList;
    }

    public List<Book> getAvailableBooks(int returnedMaxNumber) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(Book.class)
                .add(Restrictions.eq("available", true)).setMaxResults(returnedMaxNumber);
        List<Book> bookList = bookCriteria.list();
        session.getTransaction().commit();
        return bookList;
    }

    public List<Book> getTopRatedBooks(int returnedMaxNumber) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(Book.class)
                .addOrder(Order.desc("rate")).setMaxResults(returnedMaxNumber);
        List<Book> bookList = bookCriteria.list();
        session.getTransaction().commit();
        return bookList;
    }

    public List<Book> getBestSeller(int returnedMaxNumber) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(Book.class)
                .addOrder(Order.desc("soldAmount")).setMaxResults(returnedMaxNumber);
        List<Book> bookList = bookCriteria.list();
        session.getTransaction().commit();
        return bookList;
    }

    public List<Book> getBooksByRate(double rate, int returnedMaxNumber) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(Book.class)
                .add(Restrictions.eq("rate", rate))
                .addOrder(Order.desc("rate")).setMaxResults(returnedMaxNumber);
        List<Book> bookList = bookCriteria.list();

        return bookList;
    }

    public List<Book> getAllBooks(int returnedMaxNumber) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(Book.class).setMaxResults(returnedMaxNumber);
        List<Book> bookList = bookCriteria.list();
        session.getTransaction().commit();
        return bookList;
    }

    public List<Book> searchForBooks(String keyWord, int returnedMaxNumber) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(Book.class)
                .add(Restrictions.like("keys", keyWord, MatchMode.ANYWHERE).ignoreCase()).setMaxResults(returnedMaxNumber);
        List<Book> bookList = bookCriteria.list();
        session.getTransaction().commit();
        return bookList;
    }

    public List<Book> filterByPrice(int minPrice, int maxPrice, int returnedMaxNumber) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(Book.class)
                .add(Restrictions.and(Restrictions.ge("price", minPrice), Restrictions.le("price", maxPrice))).setMaxResults(returnedMaxNumber);
        List<Book> bookList = bookCriteria.list();
        session.getTransaction().commit();
        return bookList;
    }

    public List<Book> FilterByProperty(String orderType, boolean orderAscen, int returnedMaxNumber,
            Object propertyValue[], String... propertyName) throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(Book.class);

        for (int i = 0, j = 0; i < propertyName.length; i++, j++) {
            switch (propertyName[i]) {
                case "price":
                case "rate": {
                    bookCriteria = bookCriteria.add(Restrictions.and(Restrictions.ge(propertyName[i], propertyValue[j]),
                            Restrictions.le(propertyName[i], propertyValue[j + 1])));
                    j++;
                    break;
                }
                case "visits": {
                    bookCriteria = bookCriteria.add(Restrictions.ge(propertyName[i], propertyValue[j]));
                    break;
                }
                case "keys":{
                    bookCriteria = bookCriteria.add(Restrictions.like("keys",(String)propertyValue[j], MatchMode.ANYWHERE).ignoreCase());
                    break;
                }
                default: {
                    bookCriteria = bookCriteria.add(Restrictions.eq(propertyName[i], propertyValue[j]));
                    break;
                }
            }
        }
        if (orderAscen) {
            bookCriteria = bookCriteria.addOrder(Order.asc(orderType)).setMaxResults(returnedMaxNumber);
        } else {
            bookCriteria = bookCriteria.addOrder(Order.desc(orderType)).setMaxResults(returnedMaxNumber);
        }
        List<Book> bookList = bookCriteria.list();
        session.getTransaction().commit();
        return bookList;
    }
    
    public List<Book> getMostVisitedBooks(int returnedMaxNumber) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(Book.class)
                .addOrder(Order.desc("visits")).setMaxResults(returnedMaxNumber);
        List<Book> bookList = bookCriteria.list();
        session.getTransaction().commit();
        return bookList;
    }
    
    public List<Book> getBookinSales(int returnedMaxNumber) throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(Book.class)
                .createCriteria("offer")
                .add(Restrictions.ne("offerId",1)).setMaxResults(returnedMaxNumber);
        List<Book> bookList = bookCriteria.list();
        session.getTransaction().commit();
        return bookList;
    }
    
    public List<Book> getUserWishList(int userID) throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(Book.class)
                .createCriteria("users")
                .add(Restrictions.idEq(userID));
        List<Book> bookList = bookCriteria.list();
        session.getTransaction().commit();
        return bookList;
    }
    
    public long getSalesCount() throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        long entityCount;
        session.beginTransaction();
        entityCount = (long) session.createCriteria(Book.class)
                .setProjection(Projections.sum("soldAmount")).uniqueResult();
        session.getTransaction().commit();
        return entityCount;
    }

    public long getAvailableCounts() throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        long entityCount;
        session.beginTransaction();
        entityCount = (long) session.createCriteria(Book.class)
                .add(Restrictions.eq("available",true))
                .setProjection(Projections.rowCount()).uniqueResult();
        session.getTransaction().commit();
        return entityCount;
    }
    
    public long getAuthorsCounts() throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        long entityCount;
        session.beginTransaction();
        entityCount = (long) session.createCriteria(Book.class)
                .setProjection(Projections.countDistinct("authorName")).uniqueResult();
        session.getTransaction().commit();
        return entityCount;
    }

}
