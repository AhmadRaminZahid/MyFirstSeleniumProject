package com.myfirstproject;

import com.github.javafaker.Faker;
import com.github.javafaker.FunnyName;
import org.junit.jupiter.api.Test;

public class Day04_JavaFaker {
  /*  Java Faker class is used for fake test data

    Intvw Q: Where do you get your test data from?
            - BA (They write the acceptance criteria)
- Test Lead
- Manual Tester
- Developer
- Database call
- API calls
- Most commonly Java Faker class is used for test data (if company allows)
    It generate data randomly

   */

@Test
    public void JavaFakerClass(){
    Faker faker = new Faker();
    //first name
    String firstName = faker.name().firstName();
    System.out.println("firstName = " + firstName);
    //last name
    String lastName= faker.name().lastName();
    System.out.println("lastName = " + lastName);
    //funny name
   String funnyName= faker.funnyName().name();
   System.out.println("funnyName = " + funnyName);
   //city
    System.out.println(faker.address().city());
    //state
    System.out.println(faker.address().state());
    //full address
    System.out.println(faker.address().fullAddress());
    //zip code
    System.out.println(faker.address().zipCode());
    //phone number
    System.out.println(faker.phoneNumber().cellPhone());
    System.out.println(faker.phoneNumber().phoneNumber());
    //email
    System.out.println(faker.internet().emailAddress());
    //random digits
    System.out.println(faker.number().digit());

}
}
