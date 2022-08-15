package tests.day25;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;


public class C001_LoremTest {

    // belirliMetotlarinCalismasi içinde kullanmak için oluşturduk.

    @Test
    public void testLorem1(){
        Faker faker = new Faker();
        System.out.println(faker.leagueOfLegends().champion());
    }

    @Test
    public void testLorem2(){
        Faker faker = new Faker();
        System.out.println(faker.shakespeare().romeoAndJulietQuote());
    }

    @Test
    public void testLorem3(){
        Faker faker = new Faker();
        System.out.println(faker.superhero().name());
    }

}
