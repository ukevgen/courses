package com.courses.spalah;

import com.courses.spalah.Customer.Ad;
import com.courses.spalah.Customer.Car;
import com.courses.spalah.Customer.Owner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Администратор on 12.04.2016.
 */
@RunWith(JUnit4.class)
public class MyHttpServletTest {
    private static final String jsonOwner = "/Owner.json";
    private static final String jsonCar = "/Car.json";
    private static final String jsonAd = "/Ad.json";
    private Owner owner;
    private Car car;
    private Ad ad;

    @Before
    public void init() {
        owner = new Owner("Evgen", "Ukevgen", "+380631111");
        car = new Car("Mazda", "Mazda3", "2015", "test vin", "text");
        ad = new Ad("Mazda3", "10_000");
    }

    @Test
    public void makeAdTest() throws ParseException {
        String s = readFile(jsonAd).replaceAll("\\s+", "");
        JSONParser parser = new JSONParser();
        JSONObject jsonAd = (JSONObject) parser.parse(s);
        assertEquals(ad.toString(), jsonAd.toString());
    }

    @Test
    public void makeOwnerTest() throws ParseException {
        String s = readFile(jsonOwner).replaceAll("\\s+", "");
        JSONParser parser = new JSONParser();
        JSONObject jOwner = (JSONObject) parser.parse(s);
        assertEquals(owner.toString(), jOwner.toString());
    }

    @Test
    public void makeCarTest() throws ParseException {
        String s = readFile(jsonCar).replaceAll("\\s+", "");
        JSONParser parser = new JSONParser();
        JSONObject jCar = (JSONObject) parser.parse(s);
        assertEquals(car.toString(), jCar.toString());
    }

    public String readFile(String fileName) {
        String s = "";
        try {
            URL url = this.getClass().getResource(fileName);
            byte[] bytes = Files.readAllBytes(Paths.get(url.toURI()));
            s = new String(bytes, "UTF-8");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return s;
    }

}
