package io.kvlabs.filemock.core.mapper;

import test.kvlabs.filemock.testcommon.MockJSONString;
import org.junit.Assert;
import org.junit.Test;
import test.kvlabs.filemock.testcommon.model.gson.GsonSamplePojo;

/**
 *
 * @author kanchana
 */
public class GsonDeserializerTest {

    GsonDeserializer instance = new GsonDeserializer();

    /**
     * Test of fromString method, of class GsonDeserializer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFromString_std_safe() throws Exception {
        GsonSamplePojo result = instance.fromString(true, MockJSONString.STANDARD, GsonSamplePojo.class);
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
     * Test of fromString method, of class GsonDeserializer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFromString_std_unsafe() throws Exception {
        GsonSamplePojo result = instance.fromString(false, MockJSONString.STANDARD, GsonSamplePojo.class);
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
     * Test of fromString method, of class GsonDeserializer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFromString_missing_safe() throws Exception {
        GsonSamplePojo result = instance.fromString(true, MockJSONString.SUBSET, GsonSamplePojo.class);
        Assert.assertTrue(result.getBooleanValue());
        Assert.assertEquals(123, result.getInteger(), 0);
        Assert.assertEquals("File Mock", result.getString());
        Assert.assertNotNull(result.getSubObject());
        //  SubObject //
        Assert.assertEquals("b", result.getSubObject().getA());
        Assert.assertEquals("d", result.getSubObject().getC());
        Assert.assertEquals("f", result.getSubObject().getE());
        //MAP
        Assert.assertNull(result.getArray());
        Assert.assertNull(result.getMetaData());
    }

    /**
     * Test of fromString method, of class GsonDeserializer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFromString_missing_unsafe() throws Exception {
        GsonSamplePojo result = instance.fromString(false, MockJSONString.SUBSET, GsonSamplePojo.class);
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
     * Test of fromString method, of class GsonDeserializer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFromString_more_safe() throws Exception {
        GsonSamplePojo result = instance.fromString(true, MockJSONString.SUPER_SET, GsonSamplePojo.class);
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
     * Test of fromString method, of class GsonDeserializer.
     *
     * @throws java.lang.Exception
     */
    public void testFromString_more_unsafe() throws Exception {
        GsonSamplePojo result = instance.fromString(false, MockJSONString.SUPER_SET, GsonSamplePojo.class);
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
     * Test of fromString method, of class GsonDeserializer.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = com.google.gson.JsonSyntaxException.class)
    public void testFromString_error_safe() throws Exception {
        GsonSamplePojo result = instance.fromString(true, MockJSONString.YAMAL, GsonSamplePojo.class);
    }

    /**
     * Test of fromString method, of class GsonDeserializer.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = com.google.gson.JsonSyntaxException.class)
    public void testFromString_error_unsafe() throws Exception {
        GsonSamplePojo result = instance.fromString(false, MockJSONString.YAMAL, GsonSamplePojo.class);
    }


}
