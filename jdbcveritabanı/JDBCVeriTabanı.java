package jdbcveritabanı;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JDBCVeriTabanı {
    
    public static void main(String[] args)throws SQLException{
        /*Connection connection = null;
        DbHelper helper = new DbHelper("kullanıcılar");
        //DbHelper helper1 = new DbHelper("sakila");
        
        //SQL cümleciklerinin JDBC deki karşılığı statement dır.Statement bizim sql cümleleri ile ilgili işlemleri yapacak.
        PreparedStatement statement = null;
        //ResultSet sonuçlar topluluğu demek.Veritabanında oluşan data resultSet olarak javada karşılanıyor.
        ResultSet resultSet;
        try{
            //Bağlantı burda kuruluyor
            connection = helper.getConnection();
            //statement = connection.prepareStatement("INSERT INTO kullanıcıbilgileri (isim, soyisim, telNo) values (\"zehra\", \"oğuz\", \"05533358156\")");
            
            //Kullanıcıdan bilgi girilmesi istendiğinde bu şekilde yapılıyor.
            String sql = "delete from kullanıcıbilgileri where isim =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "mert");
            
            statement.executeUpdate();
            System.out.println("Kayıt silindi");
    }catch(SQLException e){
            helper.showErrorMessage(e);
    }finally{
            statement.close();
            connection.close();
        }*/
        System.out.println("Yapmak istediğiniz işlemi seçin:\n ");
        System.out.println("1-Veritabanına kayıt ekleme ");
        System.out.println("1-Veritabanında kayıt güncelleme ");
        System.out.println("1-Veritabanından kayıt silme\n ");
        
        Scanner sc = new Scanner(System.in);
        int secim = sc.nextInt();
        
        switch (secim) {
            case 1:
                insertData();
                break;
            case 2:
                updateData();
                break;
            case 3: 
                deleteData();
                break;
            default:
                System.out.println("Veritabanı işlemleri için yukarıdaki 1,2,3 işlemlerinden birini seçin!!!");
                break;
        }
    }
    
    //insert update delete işlemleri yapmak normal sorgu yazmaktan daha kısa. nomal sorgu yaparken statement
    //insert işlemi yaparken Prepared statement oluşturuluyor.insert işlemi yaparken Connection oluşturup preprared
    //statement oluşturup sorguyu yazıp daha sonra statement ı execute update ediyoruz. Yani çalıştırıyoruz.
    
    public static void selectDemo() throws SQLException{
        Connection connection = null;
        DbHelper helper = new DbHelper("kullanıcılar");
        //DbHelper helper1 = new DbHelper("sakila");
        
        //SQL cümleciklerinin JDBC deki karşılığı statement dır.Statement bizim sql cümleleri ile ilgili işlemleri yapacak.
        Statement statement = null;
        //ResultSet sonuçlar topluluğu demek.Veritabanında oluşan data resultSet olarak javada karşılanıyor.
        ResultSet resultSet;
        try{
            //Bağlantı burda kuruluyor
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM kullanıcılar.kullanıcıbilgileri");  //SQL cümleciğini çalıştır.
            ArrayList<KullanıcıBilgileri> bilgiler = new ArrayList<KullanıcıBilgileri>();
            while (resultSet.next()) {                
                bilgiler.add(new KullanıcıBilgileri(
                resultSet.getString("isim"),
                resultSet.getString("soyisim"),
                resultSet.getString("telNo")));
            }
            System.out.println(bilgiler.size());
    }catch(SQLException e){
            helper.showErrorMessage(e);
    }finally{
            connection.close();
        }
     
      
    }
    
    public static void insertData()throws SQLException{
        Connection connection = null;
        DbHelper helper = new DbHelper("kullanıcılar");
        //DbHelper helper1 = new DbHelper("sakila");
        
        //SQL cümleciklerinin JDBC deki karşılığı statement dır.Statement bizim sql cümleleri ile ilgili işlemleri yapacak.
        Statement statement = null;
        //ResultSet sonuçlar topluluğu demek.Veritabanında oluşan data resultSet olarak javada karşılanıyor.
        ResultSet resultSet;
        try{
            //Bağlantı burda kuruluyor
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM kullanıcılar.kullanıcıbilgileri");  //SQL cümleciğini çalıştır.
            ArrayList<KullanıcıBilgileri> bilgiler = new ArrayList<KullanıcıBilgileri>();
            while (resultSet.next()) {                
                bilgiler.add(new KullanıcıBilgileri(
                resultSet.getString("isim"),
                resultSet.getString("soyisim"),
                resultSet.getString("telNo")));
            }
            //System.out.println(bilgiler.size());
            System.out.println("Kayıt eklendi");
    }catch(SQLException e){
            helper.showErrorMessage(e);
    }finally{
            connection.close();
    }
        
    }
    
    
    public static void updateData()throws SQLException{
        Connection connection = null;
        DbHelper helper = new DbHelper("kullanıcılar");
        //DbHelper helper1 = new DbHelper("sakila");
        
        //SQL cümleciklerinin JDBC deki karşılığı statement dır.Statement bizim sql cümleleri ile ilgili işlemleri yapacak.
        Statement statement = null;
        //ResultSet sonuçlar topluluğu demek.Veritabanında oluşan data resultSet olarak javada karşılanıyor.
        ResultSet resultSet;
        try{
            //Bağlantı burda kuruluyor
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM kullanıcılar.kullanıcıbilgileri");  //SQL cümleciğini çalıştır.
            ArrayList<KullanıcıBilgileri> bilgiler = new ArrayList<KullanıcıBilgileri>();
            while (resultSet.next()) {                
                bilgiler.add(new KullanıcıBilgileri(
                resultSet.getString("isim"),
                resultSet.getString("soyisim"),
                resultSet.getString("telNo")));
            }
            //System.out.println(bilgiler.size());
            System.out.println("Kayıt güncellendi");
    }catch(SQLException e){
            helper.showErrorMessage(e);
    }finally{
            connection.close();
        }
    }
    
    public static void deleteData() throws SQLException{
        Connection connection = null;
        DbHelper helper = new DbHelper("kullanıcılar");
        //DbHelper helper1 = new DbHelper("sakila");
        
        //SQL cümleciklerinin JDBC deki karşılığı statement dır.Statement bizim sql cümleleri ile ilgili işlemleri yapacak.
        PreparedStatement statement = null;
        //ResultSet sonuçlar topluluğu demek.Veritabanında oluşan data resultSet olarak javada karşılanıyor.
        ResultSet resultSet;
        try{
            //Bağlantı burda kuruluyor
            connection = helper.getConnection();
            //statement = connection.prepareStatement("INSERT INTO kullanıcıbilgileri (isim, soyisim, telNo) values (\"zehra\", \"oğuz\", \"05533358156\")");
            
            //Kullanıcıdan bilgi girilmesi istendiğinde bu şekilde yapılıyor.
            String sql = "delete from kullanıcıbilgileri where isim =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "mert");
            
            statement.executeUpdate();
            System.out.println("Kayıt silindi");
    }catch(SQLException e){
            helper.showErrorMessage(e);
    }finally{
            statement.close();
            connection.close();
        }
    }
}

   
