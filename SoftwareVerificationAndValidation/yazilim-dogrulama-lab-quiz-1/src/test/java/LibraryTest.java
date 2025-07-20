import org.example.Author;
import org.example.Book;
import org.example.Library;
import org.example.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    public Library kutuphane;
    public Book kitap1;
    public Book kitap2;
    public Member uye;

    @BeforeEach // bu annotation ı önceden ayarlama yapmak için kullandım. Hepsinden önce çalışsın
    //testler için uygun ortam olsun diye kullandım.
    public void ayarYap() {
        kutuphane = new Library();

        Author yazar1 = new Author();
        yazar1.setName("Sabahattin");
        yazar1.setSurname("Ali");

        kitap1 = new Book();
        kitap1.setBookName("Kuyucaklı Yusuf");
        kitap1.setAuthor(yazar1);

        Author yazar2 = new Author();
        yazar2.setName("Charles");
        yazar2.setSurname("Dickens");

        kitap2 = new Book();
        kitap2.setBookName("Büyük Umutlar");
        kitap2.setAuthor(yazar2);

        uye = new Member();
        uye.setMemberName("Ahmet Hakan");
        uye.setMemberSurname("Yılmaz");
    }

    @Test
    public void kitapEklemeTesti() {
        kutuphane.addBook(kitap1);
        assertEquals(kitap1, kutuphane.findBookByName("Kuyucaklı Yusuf"));
    }

    @Test
    public void kitapSilmeTesti() {
        kutuphane.addBook(kitap1);
        kutuphane.removeBook(kitap1);
        assertNull(kutuphane.findBookByName("Kuyucaklı Yusuf"));
    }

    @Test
    public void kitapYazarGuncellemeTesti() {
        kutuphane.addBook(kitap1);
        kutuphane.editBook(kitap1, "Guncellenmis Yazar");
        assertEquals("Guncellenmis Yazar", kitap1.getAuthor().getName());
    }

    @Test
    public void kitapIsmineGoreBulmaTesti() {
        kutuphane.addBook(kitap1);
        kutuphane.addBook(kitap2);
        assertEquals(kitap2, kutuphane.findBookByName("Büyük Umutlar"));
    }

    @Test
    public void kitapMusaitMiTesti() {
        kutuphane.addBook(kitap1);
        assertTrue(kutuphane.mesgulmu(kitap1));
        kutuphane.reserveBook(kitap1, uye);
        assertFalse(kutuphane.mesgulmu(kitap1));
    }

    @Test
    public void kitapRezerveEtmeTesti() {
        kutuphane.addBook(kitap1);
        kutuphane.reserveBook(kitap1, uye);
        assertEquals(uye, kitap1.getReservation());
    }

    @Test
    public void rezerveEdilmisKitabiTekrarRezerveEtmeTesti() {
        kutuphane.addBook(kitap1);
        kutuphane.reserveBook(kitap1, uye);

        Member baskaUye = new Member();
        baskaUye.setMemberName("Sadullah");
        baskaUye.setMemberSurname("Kara");

        kutuphane.reserveBook(kitap1, baskaUye);

        assertEquals(uye, kitap1.getReservation());
    }

    @Test
    public void kitapRezervasyonIptalTesti() {
        kutuphane.addBook(kitap1);
        kutuphane.reserveBook(kitap1, uye);
        assertEquals(uye, kitap1.getReservation());

        kitap1.setReservation(null);
        assertNull(kitap1.getReservation());
    }

    @Test
    public void kitapEklemeCikarmaSayisiKontrolTesti() {
        assertEquals(0, kutuphane.getBooks().size());

        kutuphane.addBook(kitap1);
        assertEquals(1, kutuphane.getBooks().size());

        kutuphane.addBook(kitap2);
        assertEquals(2, kutuphane.getBooks().size());

        kutuphane.removeBook(kitap1);
        assertEquals(1, kutuphane.getBooks().size());
    }

    @Test
    public void nullKitapEklemeTesti() {
        assertThrows(NullPointerException.class, () -> kutuphane.addBook(null));
    }

    @Test
    public void nullKitapSilmeTesti() {
        //Yaptığım teste hatasını aldım.
        assertThrows(NullPointerException.class, () -> kutuphane.removeBook(null));
    }

    @Test
    public void nullYazarGuncellemeTesti() {
        assertThrows(NullPointerException.class, () -> kutuphane.editBook(null, "Yeni Yazar"));
    }

    @Test
    public void nullRezervasyonTesti() {
        assertThrows(NullPointerException.class, () -> kutuphane.reserveBook(null, uye));
        assertThrows(NullPointerException.class, () -> kutuphane.reserveBook(kitap1, null));
    }
}
