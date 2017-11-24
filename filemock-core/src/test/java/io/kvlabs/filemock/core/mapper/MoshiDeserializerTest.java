package io.kvlabs.filemock.core.mapper;

import test.kvlabs.filemock.testcommon.MockJSONString;
import io.kvlabs.filemock.core.mapper.MoshiDeserializer;
import org.junit.Assert;
import org.junit.Test;
import test.kvlabs.filemock.testcommon.moshi.MoshiSamplePojo;

/**
 *
 * @author kanchana
 */
public class MoshiDeserializerTest {

    MoshiDeserializer instance = new MoshiDeserializer();

    /**
     * Test of fromString method, of class MoshiDeserializer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFromString_std_safe() throws Exception {
        MoshiSamplePojo result = instance.fromString(true, MockJSONString.STANDARD, MoshiSamplePojo.class);
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
     * Test of fromString method, of class MoshiDeserializer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFromString_std_unsafe() throws Exception {
        MoshiSamplePojo result = instance.fromString(false, MockJSONString.STANDARD, MoshiSamplePojo.class);
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
     * Test of fromString method, of class MoshiDeserializer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFromString_missing_safe() throws Exception {
        MoshiSamplePojo result = instance.fromString(true, MockJSONString.SUBSET, MoshiSamplePojo.class);
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
     * Test of fromString method, of class MoshiDeserializer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFromString_missing_unsafe() throws Exception {
        MoshiSamplePojo result = instance.fromString(false, MockJSONString.SUBSET, MoshiSamplePojo.class);
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
     * Test of fromString method, of class MoshiDeserializer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFromString_more_safe() throws Exception {
        MoshiSamplePojo result = instance.fromString(true, MockJSONString.SUPER_SET, MoshiSamplePojo.class);
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
     * Test of fromString method, of class MoshiDeserializer.
     *
     * @throws java.lang.Exception
     */
    public void testFromString_more_unsafe() throws Exception {
        MoshiSamplePojo result = instance.fromString(false, MockJSONString.SUPER_SET, MoshiSamplePojo.class);
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
     * Test of fromString method, of class MoshiDeserializer.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = com.squareup.moshi.JsonEncodingException.class)
    public void testFromString_error_safe() throws Exception {
        MoshiSamplePojo result = instance.fromString(true, MockJSONString.YAMAL, MoshiSamplePojo.class);
    }

    /**
     * Test of fromString method, of class MoshiDeserializer.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = com.squareup.moshi.JsonEncodingException.class)
    public void testFromString_error_unsafe() throws Exception {
        MoshiSamplePojo result = instance.fromString(false, MockJSONString.YAMAL, MoshiSamplePojo.class);
    }

}
