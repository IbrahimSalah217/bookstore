/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.hibrnate.testMain;

import com.webproject.bookstore.controller.services.HomeServices;
import com.webproject.bookstore.controller.services.ServicesFactory;
import com.webproject.bookstore.controller.services.Shop;
import com.webproject.bookstore.controller.services.WishListServices;
import com.webproject.bookstore.model.dal.dto.BookBean;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.BookDao;
import com.webproject.bookstore.controller.services.UserCartServices;
import com.webproject.bookstore.model.dal.dto.BookBean;
import com.webproject.bookstore.model.dal.dto.CartBean;
import com.webproject.bookstore.model.dal.dto.DtoMapper;
import com.webproject.bookstore.model.dal.dto.OrderBean;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.CategoryDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.OfferDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserCartBookDao;
import com.webproject.bookstore.model.dal.hibrnate.entities.Book;
import com.webproject.bookstore.model.dal.hibrnate.entities.Category;
import com.webproject.bookstore.model.dal.hibrnate.entities.Offer;
import com.webproject.bookstore.model.dal.hibrnate.entities.User;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserCartBook;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserCartBookId;
import com.webproject.bookstore.model.dal.hibrnate.util.DaoFactory;
import com.webproject.bookstore.model.dal.hibrnate.util.DataBaseIntializer;
import com.webproject.bookstore.model.dal.hibrnate.util.SessionManager;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ibrahim
 */
public class MainTest {

    static Offer j;
    BookDao bookDao = DaoFactory.getBookDao();
    CategoryDao categoryDao = DaoFactory.getCategoryDao();
        OfferDao offerDao = DaoFactory.getOfferDao();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

            /* SessionFactory sessionFactory = SessionManager.getSessionFactory();
            Session session = sessionFactory.openSession();
            Category category = new Category(0, "ibrahimmmmmmmmmmmm");
            Offer offer = new Offer(0, 40, new Date());
            >>>>>>> origin/master
            
            <<<<<<< HEAD
            User user = new User(0, "dd", new Date(), "dddddd", "dddd", "ddddddddd", 50, "dddd", "ddadas", "ddd");
            
            session.beginTransaction();
            //session.persist(category);
            //session.persist(offer);
            session.getTransaction().commit();
            Book book = new Book();
            book.setAuthorName("waled");
            book.setAvailable(false);
            Category newCategory = (Category) DaoFactory.getCategoryDao().getByID(8);
            Offer newOffer = (Offer) session.get(Offer.class, 8);
            
            book.setCategory(newCategory);
            book.setDescription("d");
            book.setImg(null);
            book.setKeys(null);
            book.setOffer(newOffer);
            book.setPagesNumber(50);
            book.setPrice(50);
            book.setQuantity(20);
            book.setRate(100);
            book.setSoldAmount(1);
            book.setTitle("yaffkkfkf ffkfk");
            book.setVisits(50);
            
            session.beginTransaction();
            //session.persist(book);
            session.persist(user);
            session.getTransaction().commit();
            System.out.println("insertation done");
            //   BookDao bookDao2 = DaoFactory.getBookDao();
            // Book b = bookDao2.insert(book);
            //        bookDao2.delete(b);
            /*
            BookDao bookDao = DaoFactory.getBookDao();
            List<Book> bookList = bookDao.getAllBooks(50);
            List<Book> bookList2 = bookDao.getAllBooks(50);
            bookList.forEach(new Consumer<Book>() {
            @Override
            public void accept(Book book) {
            //                BookDao bookDao2 = DaoFactory.getBookDao();
            //                bookDao2.update(book);
            System.out.println(book.getTitle() + "      " + book.getOffer().getExpireDate() + "        " + book.getCategory().getCategoryName());
            }
            });*/
            /* UserCartBookDao userCartDao = DaoFactory.getCartBookDao();
            UserCartBook userCart =new UserCartBook();
            userCart.setId(new UserCartBookId(5,14));
            userCart.setAvailableQuantity(50);
            userCart.setReqQuantity(70);
            UserCartBook userCart2 = userCartDao.insert(userCart);
            
            System.out.println(DaoFactory.getBookDao().getBookByID(userCart2.getId().getBookId()).getAuthorName());
            System.out.println(userCart2.getUser().getAddress());
            System.out.println("insertation done /...........");
            */
            /*
            /////////////////////////////////////////test category Dao Ibrahim
            Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
            CategoryDao categoryDao = DaoFactory.getCategoryDao();
            //for (double i = 0; i < 500000050; i += .2);
            Category x =  categoryDao.insert(new Category(0, "wael222"));
            System.out.println("category inserted 1 "+ x.getCategoryName());
            }
            });
            th.start();
            Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
            CategoryDao categoryDao = DaoFactory.getCategoryDao();
            Category x = categoryDao.insert(new Category(0, "mona22222"));
            System.out.println("category inserted 2 " +x. getCategoryName());
            }
            });
            th2.start();*/
            ///////////////////////////////////////////////////////////////////category end
            
            //////////////////////////////////////////test Offer Dao
            /* Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
            OfferDao offerDao = DaoFactory.getOfferDao();
            //for (double i = 0; i < 500000050; i += .2);
            offerDao.insert(new Offer(79,13,new Date()));
            System.out.println("category inserted " +"        ");
            }
            });
            th.start();
            Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
            OfferDao offerDao = DaoFactory.getOfferDao();
            //for (double i = 0; i < 500000050; i += .2);
            Offer d = offerDao.getByID(77);
            System.out.println("category inserted " +d.getOfferId());
            }
            });
            th2.start();*/
            ///////////////////////////////////////////////////////////////////Offer end
            /*
            * To convert java.util.Date to String, use SimpleDateFormat class.
            */
            
            /*
            * crate new SimpleDateFormat instance with desired date format.
            * We are going to use yyyy-mm-dd hh:mm:ss here.
            */
            /*
            List<BookBean> books = shop.getFilteredBooks("rate",false,"buissness",20,10,300,true,50,100,40);
            books.forEach((t) -> {
            System.out.println(t.getOfferDate()+"       "+t.getAuthorName()+"        "+t.getCategoryName());
            });*/
//        new DataBaseIntializer().fillCategories();;
//        try {
//            new DataBaseIntializer().fillOffers();
//        } catch (ParseException ex) {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            new DataBaseIntializer().fillBooks();
//        } catch (IOException ex) {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvalidFormatException ex) {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        new WishListServices().addToUserWishList(53,296);
////        System.out.println(" "+DaoFactory.getUserDao().getUserById(53).getBooks().size());
//        System.out.println(" "+new WishListServices().getUserWishList(53).get(1).getTitle());

//        SessionFactory sessionFactory = SessionManager.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Category category = new Category(0, "prormming");
//        Offer offer = new Offer(0, 40, new Date());
//
//        User user = new User(0, "dd", new Date(), "dddddd", "dddd", "ddddddddd", 50, "dddd", "ddadas", "ddd");
//
//        /*session.beginTransaction();
//        session.persist(category);
//        session.persist(offer);
//        session.getTransaction().commit();
//        Book book = new Book();
//        book.setAuthorName("a");
//        book.setAvailable(true);
//        Category newCategory = (Category) session.get(Category.class, category.getCategoryId());
//        Offer newOffer = (Offer) session.get(Offer.class, offer.getOfferId());
//
//        book.setCategory(newCategory);
//        book.setDescription("d");
//        book.setImg("d");
//        book.setKeys("dd");
//        book.setOffer(newOffer);
//        book.setPagesNumber(50);
//        book.setPrice(50);
//        book.setQuantity(20);
//        book.setRate(50.0);
//        book.setSoldAmount(1);
//        book.setTitle("ss");
//        book.setVisits(50);
//
//        session.beginTransaction();
//        //session.persist(book);
//        session.persist(user);
//        session.getTransaction().commit();
//        System.out.println("insertation done");*/
///*
//        /////////////////////////////////////////test category Dao Ibrahim
//        Thread th = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                CategoryDao categoryDao = DaoFactory.getCategoryDao();
//                for (double i = 0; i < 500000050; i += .2);
//                int d = categoryDao.insert(new Category(0, "ll"));
//                System.out.println("category inserted " + d);
//            }
//        });
//        th.start();
//        Thread th2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                CategoryDao categoryDao = DaoFactory.getCategoryDao();
//                Category d = categoryDao.getByName("ll");
//                System.out.println("category inserted " + d.getCategoryName());
//            }
//        });
//        th2.start();
//        ///////////////////////////////////////////////////////////////////category end
//*/        
//        //////////////////////////////////////////test Offer Dao
//        Thread th = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                OfferDao offerDao = DaoFactory.getOfferDao();
//                //for (double i = 0; i < 500000050; i += .2);
//                j = offerDao.insert(new Offer(0,13,new Date()));
//                System.out.println("category inserted " + j.getOfferId()+"        ");
//            }
//        });
//        th.start();
//        Thread th2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                OfferDao offerDao = DaoFactory.getOfferDao();
//                 for (double i = 0; i < 500000050; i += .2);
//                Offer d = offerDao.getByID(j.getOfferId());
//                System.out.println("category inserted " + j.getOfferPercentage() + d.getOfferId());
//            }
//        });
//        th2.start();
//        ///////////////////////////////////////////////////////////////////Offer end
//    }
//
//}
////        User user = new User(2, "fgjgjgjgjgjgjgjgjgjggj", new Date(), "dddddd", "dddd", "ddddddddd", 50, "dddd", "ddadas", "ddd");
////        DaoFactory.getUserDao().insert(user);
//        Book book = DaoFactory.getBookDao().getBookByID(1);
//        Book book2 = DaoFactory.getBookDao().getBookByID(2);
//        BookBean bookBean = new DtoMapper().createBookBean(book);
//        BookBean bookBean2 = new DtoMapper().createBookBean(book2);
//
////            CartBean cartBean = new CartBean(bookBean,3,1);
////            CartBean cartBean2 = new CartBean(bookBean2, 2, 1);
////            List<CartBean> cartBeanList = new ArrayList<>();
////            cartBeanList.add(cartBean);
////            cartBeanList.add(cartBean2);
//        UserCartServices cartservices = new UserCartServices();
//        cartservices.addToCart(1, 1, 2);
//        cartservices.addToCart(1, 2, 3);
//        cartservices.addToCart(2, 3, 1);
//        List<CartBean> cartBeanList = cartservices.getUserCart(1);
//        cartBeanList.forEach((cart) -> {
//            System.out.println("                          "+cart.getBookBean().getTitle());
//        });
//        cartservices.checkOut(cartBeanList);4

//        DaoFactory.getBookDao().getAllBooks(300).forEach((book) -> {
////           book.setImg(book.getImg().replace("/","").replace("\\","").replace("?","")
////                   .replace(">","").replace("*","").replace("|","").replace("<","")
////                   .replace(":","").replace("\"","").replace("\'","&apos;").replace("..","."));
////           book.setImg(book.getImg().replace("―",""));
// //           book.setImg(book.getImg().replaceFirst("books","books/")); 
// //          book.setImg(book.getImg().replace("–","&#150;"));
//            book.setImg(book.getImg().replace(".",""));
//            book.setImg(book.getImg().replace("jpg",".jpg"));
//           DaoFactory.getBookDao().update(book);



//String imageName = "books/"+Arrays.stream(book.getTitle().trim().replace(":","").split(" ")).collect(Collectors.joining())+".jpg";
//String imageName = Arrays.stream(book.getTitle().trim().split(" ")).collect(Collectors.joining());
//
//DaoFactory.getBookDao().getAllBooks(300).forEach((book) -> {
//           book.setImg(book.getImg().replace("/","").replace("\\","").replace("?","")
//                   .replace(">","").replace("*","").replace("|","").replace("<","")
//                   .replace(":","").replace("\"","").replace("\'","&apos;");
//           book.setImg(book.getImg().replace("―",""));
//           book.setImg(book.getImg().replace("–","&#150;"));
//            book.setImg(book.getImg().replace(".",""));
//           DaoFactory.getBookDao().update(book);
//        });

        //ServicesFactory.getBookpageServices().getRelatedBooks(1176)

//        
//        try{
//            System.out.println("////////////////////////////"+DaoFactory.getCartBookDao().getEntityCount());
//        }catch(ClassNotFoundException  ex){}
        
        
//        ServicesFactory.getShopServices().searchForBook("Clean",300).forEach((t) -> {
//            System.out.println("//////////////////////////////"+t.getKeys());

//        });
//new DataBaseIntializer().fillBooks();
//        } catch (IOException ex) {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvalidFormatException ex) {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
   
//          try {
//           DataBaseIntializer n= new DataBaseIntializer();  
//          // n.fillCategories();
//        //   n.fillOffers();
//            n.fillBooks();
//            
//            
//        } catch (IOException ex) {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvalidFormatException ex) {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         catch (ParseException ex) {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        }

// fill Books After Update

          try {
           DataBaseIntializer n= new DataBaseIntializer();  
            n.fillBooks();
            
            
        } catch (IOException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
}
