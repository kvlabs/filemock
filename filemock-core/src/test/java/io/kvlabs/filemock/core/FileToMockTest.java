package io.kvlabs.filemock.core;

import io.kvlabs.filemock.core.mapper.Mapper;
import org.junit.Assert;
import org.junit.Test;
import test.kvlabs.filemock.testcommon.model.gson.GsonSamplePojo;
import test.kvlabs.filemock.testcommon.jackson1.Jackson1SamplePojo;
import test.kvlabs.filemock.testcommon.jackson2.Jackson2SamplePojo;
import test.kvlabs.filemock.testcommon.moshi.MoshiSamplePojo;

/**
 *
 * @author kanchana
 */
public class FileToMockTest {

    private final static String BASE = "/META-INF/mock/";
    private final static String SAMPLE_POJO = BASE + "sample_pojo.json";
    private final static String SAMPLE_POJO_MISSING = BASE + "sample_pojo_missing.json";
    private final static String SAMPLE_POJO_MORE = BASE + "sample_pojo_more.json";
    private final static String PARSE_ERROR = BASE + "parse_error.json";

    /**
     * Test of mock method, of class FileToMock.
     */
    @Test
    public void testMock_default_jackson1() {
        Jackson1SamplePojo result = FileMock.mockFile(SAMPLE_POJO_MORE, Jackson1SamplePojo.class);
        //--
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
     * Test of mock method, of class FileToMock.
     */
    @Test
    public void testMock_mapper_jackson1() {
        Jackson1SamplePojo result = FileMock.mockFile(SAMPLE_POJO_MORE, Mapper.JACKSON_1, Jackson1SamplePojo.class);
        //--
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
     * Test of mock method, of class FileToMock.
     */
    @Test
    public void testMock_unsafe_jackson1() {
        Jackson1SamplePojo result = FileMock.mockFile(SAMPLE_POJO_MORE, Mapper.JACKSON_1, true, Jackson1SamplePojo.class);
        //--
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
     * Test of mock method, of class FileToMock.
     */
    @Test(expected = io.kvlabs.filemock.core.exception.JsonMappingException.class)
    public void testMock_unsafe_jackson1_more() {
        Jackson1SamplePojo result = FileMock.mockFile(SAMPLE_POJO_MORE, Mapper.JACKSON_1, false, Jackson1SamplePojo.class);
    }

    /**
     * Test of mock method, of class FileToMock.
     */
    @Test(expected = io.kvlabs.filemock.core.exception.JsonMappingException.class)
    public void testMock_unsafe_jackson1_error() {
        Jackson1SamplePojo result = FileMock.mockFile(PARSE_ERROR, Mapper.JACKSON_1, false, Jackson1SamplePojo.class);
    }


    /**
     * Test of mock method, of class FileToMock.
     */
    @Test(expected = io.kvlabs.filemock.core.exception.FileNotFoundException.class)
    public void testMock_noSuchFile() {
        Jackson1SamplePojo result = FileMock.mockFile("nosuhfile.json", Mapper.JACKSON_1, false, Jackson1SamplePojo.class);
    }

    /**
     * Test of mock method, of class FileToMock.
     */
    @Test
    public void testMock_safe_jackson2() {
        Jackson2SamplePojo result = FileMock.mockFile(SAMPLE_POJO_MISSING, Mapper.JACKSON_2, true, Jackson2SamplePojo.class);

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
     * Test of mock method, of class FileToMock.
     */
    @Test
    public void testMock_safe_gson() {
        GsonSamplePojo result = FileMock.mockFile(SAMPLE_POJO, Mapper.GSON, true, GsonSamplePojo.class);
        //--
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
     * Test of mock method, of class FileToMock.
     */
    @Test
    public void testMock_safe_moshi() {
        MoshiSamplePojo result = FileMock.mockFile(SAMPLE_POJO, Mapper.MOSHI, true, MoshiSamplePojo.class);
        //--
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

}
