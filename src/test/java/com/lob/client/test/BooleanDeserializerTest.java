package com.lob.client.test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.lob.BooleanDeserializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BooleanDeserializerTest {
    @Mock JsonParser parser;
    @Mock DeserializationContext ctx;

    private final BooleanDeserializer deserializer = new BooleanDeserializer();

    @Test
    public void deserializerTest() throws Exception {
        when(parser.getValueAsString()).thenReturn("1");
        assertTrue(deserializer.deserialize(parser, ctx));

        when(parser.getValueAsString()).thenReturn("true");
        assertTrue(deserializer.deserialize(parser, ctx));

        when(parser.getValueAsString()).thenReturn("tRuE");
        assertTrue(deserializer.deserialize(parser, ctx));

        when(parser.getValueAsString()).thenReturn("0");
        assertFalse(deserializer.deserialize(parser, ctx));

        when(parser.getValueAsString()).thenReturn("false");
        assertFalse(deserializer.deserialize(parser, ctx));

        when(parser.getValueAsString()).thenReturn("fAlSe");
        assertFalse(deserializer.deserialize(parser, ctx));

        when(parser.getValueAsString()).thenReturn("BLARGH");
        assertFalse(deserializer.deserialize(parser, ctx));
    }
}
