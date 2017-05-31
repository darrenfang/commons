package com.darrenfang.commons.xml;

import com.darrenfang.commons.web.ViewModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class XmlSerializerTest {
    @Test
    public void testSerialize() {
        XmlSerializer serializer = new XmlSerializer();
        String xml = serializer.serialize(new ViewModel(404, "网页无法找到"));
        assertEquals("<viewModel>\n" +
                "   <code>404</code>\n" +
                "   <message>网页无法找到</message>\n" +
                "</viewModel>", xml);
    }

    @Test
    public void testDeserialize() {
        String xml = "<viewModel>\n" +
                "   <code>404</code>\n" +
                "   <message>网页无法找到</message>\n" +
                "</viewModel>";

        XmlSerializer serializer = new XmlSerializer();
        ViewModel model = serializer.deserialize(xml, ViewModel.class);
        assertEquals(404, model.getCode());
        assertEquals("网页无法找到", model.getMessage());
    }
}
