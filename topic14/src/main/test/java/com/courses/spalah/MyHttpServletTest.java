package com.courses.spalah;

import com.courses.spalah.MyHttpServlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Администратор on 12.04.2016.
 */
@RunWith(JUnit4.class)
public class MyHttpServletTest {
    @Test
    public void makeModelTest() {
        List model = new ArrayList<String>();
        model.add("model1");
        model.add("model2");
        assertEquals(2, MyHttpServlet.);
    }

}
