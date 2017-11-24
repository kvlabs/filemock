package io.kvlabs.filemock.core.mapper;

import test.kvlabs.filemock.testcommon.MockJSONString;
import io.kvlabs.filemock.core.mapper.Jackson1Deserializer;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;
import org.junit.Assert;
import org.junit.Test;
import test.kvlabs.filemock.testcommon.jackson1.Jackson1SamplePojo;

/**
 *
 * @author kanchana
 */
public class Jackson1DeserializerTest {

    Jackson1Deserializer instance = new Jackson1Deserializer();

    /**
     * Test of fromString method, of class Jackson1Deserializer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFromString_std_safe() throws Exception {
        Jackson1SamplePojo result = instance.fromString(true, MockJSONString.STANDARD, Jackson1SamplePojo.class);
        Assert.assertTrue(result.getBooleanValue());
        Assert.assertEquals(123, result.getInteger(), 0);
        Assert.assertEquals("File Mock", result.getString());
        Assert.assertNotNull(result.getSubObject());
        //  SubObject //
        Assert.assertEquals("b", result.getSubObject().getA());
        Assert.assertEquals("d", result.getSubObject().getC());
        Assert.assertEquals("f", result.getSubObject().getE());
        Assert.assertNotNull(result.getArray());
        //Collection
        Assert.assertEquals(3, result.getArray().size(), 0);
        Assert.assertEquals(1, result.getArray().get(0), 0);
        Assert.assertEquals(2, result.getArray().get(1), 0);
        Assert.assertEquals(3, result.getArray().get(2), 0);
        Assert.assertNotNull(result.getMetaData());
        //MAP
        Assert.assertEquals(3, result.getMetaData().size());
        Assert.assertEquals("b", result.getMetaData().get("a"));
        Assert.assertEquals("d", result.getMetaData().get("c"));
        Assert.assertEquals("f", result.getMetaData().get("e"));
    }

    /**
     * Test of fromString method, of class Jackson1Deserializer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFromString_std_unsafe() throws Exception {
        Jackson1SamplePojo result = instance.fromString(false, MockJSONString.STANDARD, Jackson1SamplePojo.class);
        Assert.assertTrue(result.getBooleanValue());
        Assert.assertEquals(123, result.getInteger(), 0);
        Assert.assertEquals("File Mock", result.getString());
        Assert.assertNotNull(result.getSubObject());
        //  SubObject //
        Assert.assertEquals("b", result.getSubObject().getA());
        Assert.assertEquals("d", result.getSubObject().getC());
        Assert.assertEquals("f", result.getSubObject().getE());
        Assert.assertNotNull(result.getArray());
        //Collection
        Assert.assertEquals(3, result.getArray().size());
        Assert.assertEquals(1, result.getArray().get(0), 0);
        Assert.assertEquals(2, result.getArray().get(1), 0);
        Assert.assertEquals(3, result.getArray().get(2), 0);
        Assert.assertNotNull(result.getMetaData());
        //MAP
        Assert.assertEquals(3, result.getMetaData().size());
        Assert.assertEquals("b", result.getMetaData().get("a"));
        Assert.assertEquals("d", result.getMetaData().get("c"));
        Assert.assertEquals("f", result.getMetaData().get("e"));
    }

    /**
     * Test of fromString method, of class Jackson1Deserializer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFromString_missing_safe() throws Exception {
        Jackson1SamplePojo result = instance.fromString(true, MockJSONString.SUBSET, Jackson1SamplePojo.class);
        Assert.assertTrue(result.getBooleanValue());
        Assert.assertEquals(123, result.getInteger(), 0);
        Assert.assertEquals("File Mock", result.getString());
        Assert.assertNotNull(result.getSubObject());
        //  SubObject //
        Assert.assertEquals("b", result.getSubObject().getA());
        Assert.assertEquals("d", result.getSubObject().getC());
        Assert.assertEquals("f", result.getSubObject().getE());
        Assert.assertNull(result.getArray());
        Assert.assertNull(result.getMetaData());
    }

    /**
     * Test of fromString method, of class Jackson1Deserializer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFromString_missing_unsafe() throws Exception {
        Jackson1SamplePojo result = instance.fromString(false, MockJSONString.SUBSET, Jackson1SamplePojo.class);
        Assert.assertTrue(result.getBooleanValue());
        Assert.assertEquals(123, result.getInteger(), 0);
        Assert.assertEquals("File Mock", result.getString());
        Assert.assertNotNull(result.getSubObject());
        //  SubObject //
        Assert.assertEquals("b", result.getSubObject().getA());
        Assert.assertEquals("d", result.getSubObject().getC());
        Assert.assertEquals("f", result.getSubObject().getE());
        Assert.assertNull(result.getArray());
        Assert.assertNull(result.getMetaData());
    }

    /**
     * Test of fromString method, of class Jackson1Deserializer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFromString_more_safe() throws Exception {
        Jackson1SamplePojo result = instance.fromString(true, MockJSONString.SUPER_SET, Jackson1SamplePojo.class);
        Assert.assertTrue(result.getBooleanValue());
        Assert.assertEquals(123, result.getInteger(), 0);
        Assert.assertEquals("File Mock", result.getString());
        Assert.assertNotNull(result.getSubObject());
        //  SubObject //
        Assert.assertEquals("b", result.getSubObject().getA());
        Assert.assertEquals("d", result.getSubObject().getC());
        Assert.assertEquals("f", result.getSubObject().getE());
        Assert.assertNotNull(result.getArray());
        //Collection
        Assert.assertEquals(3, result.getArray().size(), 0);
        Assert.assertEquals(1, result.getArray().get(0), 0);
        Assert.assertEquals(2, result.getArray().get(1), 0);
        Assert.assertEquals(3, result.getArray().get(2), 0);
        Assert.assertNotNull(result.getMetaData());
        //MAP
        Assert.assertEquals(3, result.getMetaData().size());
        Assert.assertEquals("b", result.getMetaData().get("a"));
        Assert.assertEquals("d", result.getMetaData().get("c"));
        Assert.assertEquals("f", result.getMetaData().get("e"));
    }

    /**
     * Test of fromString method, of class Jackson1Deserializer.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = UnrecognizedPropertyException.class)
    public void testFromString_more_unsafe() throws Exception {
        Jackson1SamplePojo result = instance.fromString(false, MockJSONString.SUPER_SET, Jackson1SamplePojo.class);
    }

    /**
     * Test of fromString method, of class Jackson1Deserializer.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = JsonParseException.class)
    public void testFromString_error_safe() throws Exception {
        Jackson1SamplePojo result = instance.fromString(true, MockJSONString.YAMAL, Jackson1SamplePojo.class);
    }

    /**
     * Test of fromString method, of class Jackson1Deserializer.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = JsonParseException.class)
    public void testFromString_error_unsafe() throws Exception {
        Jackson1SamplePojo result = instance.fromString(false, MockJSONString.YAMAL, Jackson1SamplePojo.class);
    }

}

