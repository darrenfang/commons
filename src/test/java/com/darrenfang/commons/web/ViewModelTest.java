package com.darrenfang.commons.web;

import org.junit.Test;

import static org.junit.Assert.*;

public class ViewModelTest {
    @Test
    public void test() {
        ViewModel model = new ViewModel();
        assertEquals(200, model.getCode());
        assertEquals("", model.getMessage());

        model = new ViewModel(404, "Page Not Found");
        assertEquals(404, model.getCode());
        assertEquals("Page Not Found", model.getMessage());
    }
}
