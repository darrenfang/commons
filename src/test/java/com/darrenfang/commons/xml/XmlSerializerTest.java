package com.darrenfang.commons.xml;

import com.darrenfang.commons.MockObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class XmlSerializerTest {
    @Test
    public void testSerialize() {
        XmlSerializer serializer = new XmlSerializer();
        String xml = serializer.serialize(new MockObject(404, "网页无法找到"));
        assertEquals("<mockObject>\n" +
                "   <code>404</code>\n" +
                "   <message>网页无法找到</message>\n" +
                "</mockObject>", xml);
    }

    @Test
    public void testDeserialize() {
        String xml = "<mockObject>\n" +
                "   <code>404</code>\n" +
                "   <message>网页无法找到</message>\n" +
                "</mockObject>";

        XmlSerializer serializer = new XmlSerializer();
        MockObject model = serializer.deserialize(xml, MockObject.class);
        assertEquals(404, model.getCode());
        assertEquals("网页无法找到", model.getMessage());
    }
}
