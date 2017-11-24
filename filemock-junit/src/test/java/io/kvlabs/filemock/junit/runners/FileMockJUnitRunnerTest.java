package io.kvlabs.filemock.junit.runners;

import io.kvlabs.filemock.core.anotation.FileMockAnnotations;
import io.kvlabs.filemock.core.mapper.Mapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.kvlabs.filemock.testcommon.model.gson.GsonSamplePojo;
import test.kvlabs.filemock.testcommon.jackson1.Jackson1SamplePojo;
import test.kvlabs.filemock.testcommon.jackson2.Jackson2SamplePojo;
import test.kvlabs.filemock.testcommon.moshi.MoshiSamplePojo;
import io.kvlabs.filemock.core.anotation.MockFile;

/**
 *
 * @author kanchana
 */
@RunWith(FileMockJUnitRunner.class)
public class FileMockJUnitRunnerTest {

    @MockFile(path = "/META-INF/mock/sample_pojo_more.json")
    Jackson1SamplePojo jackson1SamplePojo;

    @MockFile(path = "/META-INF/mock/sample_pojo_missing.json", safeMode = false)
    Jackson1SamplePojo jackson1SamplePojo2;

    @MockFile(path = "/META-INF/mock/sample_pojo_more.json", mapper = Mapper.JACKSON_2)
    Jackson2SamplePojo jackson2SamplePojo;

    @MockFile(path = "/META-INF/mock/sample_pojo.json", safeMode = false, mapper = Mapper.JACKSON_2)
    Jackson2SamplePojo jackson2SamplePojo2;

    @MockFile(path = "/META-INF/mock/sample_pojo.json", mapper = Mapper.GSON)
    GsonSamplePojo gsonPojo;

    @MockFile(path = "/META-INF/mock/sample_pojo.json", mapper = Mapper.MOSHI)
    MoshiSamplePojo moshiSamplePojo;

    @Before
    public void setUp() {
        FileMockAnnotations.initMocks(this);
    }

    /**
     * Test of initMocks method, of class FileToMockAnnotations.
     */
    @Test
    public void testInitMocks() {
        Assert.assertNotNull("sample_pojo_missing | default annotation", jackson1SamplePojo);
        Assert.assertNotNull("sample_pojo_more | default annotation with safe mode[false] ", jackson1SamplePojo2);
        Assert.assertNotNull("sample_pojo_more | safe mode[default] and mapper as jackson2", jackson2SamplePojo);
        Assert.assertNotNull("sample_pojo | safe mode[false] and mapper as jackson2", jackson2SamplePojo2);
        Assert.assertNotNull("sample_pojo | safe mode[default] and mapper set as gson", gsonPojo);
        Assert.assertNotNull("sample_pojo | safe mode[default] and mapper set as moshi", moshiSamplePojo);
        //jackson1SamplePojo
        Assert.assertTrue(jackson1SamplePojo.getBooleanValue());
        Assert.assertEquals(123, jackson1SamplePojo.getInteger(), 1);
        Assert.assertEquals("File Mock", jackson1SamplePojo.getString());
        Assert.assertNotNull(jackson1SamplePojo.getSubObject());
        //  SubObject //
        Assert.assertEquals("b", jackson1SamplePojo.getSubObject().getA());
        Assert.assertEquals("d", jackson1SamplePojo.getSubObject().getC());
        Assert.assertEquals("f", jackson1SamplePojo.getSubObject().getE());
        Assert.assertNotNull(jackson1SamplePojo.getArray());
        //Collection
        Assert.assertEquals(3, jackson1SamplePojo.getArray().size());
        Assert.assertEquals(1, jackson1SamplePojo.getArray().get(0), 1);
        Assert.assertEquals(2, jackson1SamplePojo.getArray().get(1), 1);
        Assert.assertEquals(3, jackson1SamplePojo.getArray().get(2), 1);
        Assert.assertNotNull(jackson1SamplePojo.getMetaData());
        //MAP
        Assert.assertEquals(3, jackson1SamplePojo.getMetaData().size());
        Assert.assertEquals("b", jackson1SamplePojo.getMetaData().get("a"));
        Assert.assertEquals("d", jackson1SamplePojo.getMetaData().get("c"));
        Assert.assertEquals("f", jackson1SamplePojo.getMetaData().get("e"));

        //Generated in 2 ms
        Assert.assertTrue(jackson1SamplePojo2.getBooleanValue());
        Assert.assertEquals(123, jackson1SamplePojo2.getInteger(), 1);
        Assert.assertEquals("File Mock", jackson1SamplePojo2.getString());
        Assert.assertNotNull(jackson1SamplePojo2.getSubObject());
        //  SubObject //
        Assert.assertEquals("b", jackson1SamplePojo2.getSubObject().getA());
        Assert.assertEquals("d", jackson1SamplePojo2.getSubObject().getC());
        Assert.assertEquals("f", jackson1SamplePojo2.getSubObject().getE());
        Assert.assertNull(jackson1SamplePojo2.getArray());
        Assert.assertNull(jackson1SamplePojo2.getMetaData());
        //jackson2SamplePojo
        Assert.assertTrue(jackson2SamplePojo.getBooleanValue());
        Assert.assertEquals(123, jackson2SamplePojo.getInteger(), 1);
        Assert.assertEquals("File Mock", jackson2SamplePojo.getString());
        Assert.assertNotNull(jackson2SamplePojo.getSubObject());
        //  SubObject //
        Assert.assertEquals("b", jackson2SamplePojo.getSubObject().getA());
        Assert.assertEquals("d", jackson2SamplePojo.getSubObject().getC());
        Assert.assertEquals("f", jackson2SamplePojo.getSubObject().getE());
        Assert.assertNotNull(jackson2SamplePojo.getArray());
        //Collection
        Assert.assertEquals(3, jackson2SamplePojo.getArray().size());
        Assert.assertEquals(1, jackson2SamplePojo.getArray().get(0), 1);
        Assert.assertEquals(2, jackson2SamplePojo.getArray().get(1), 1);
        Assert.assertEquals(3, jackson2SamplePojo.getArray().get(2), 1);
        Assert.assertNotNull(jackson2SamplePojo.getMetaData());
        //MAP
        Assert.assertEquals(3, jackson2SamplePojo.getMetaData().size());
        Assert.assertEquals("b", jackson2SamplePojo.getMetaData().get("a"));
        Assert.assertEquals("d", jackson2SamplePojo.getMetaData().get("c"));
        Assert.assertEquals("f", jackson2SamplePojo.getMetaData().get("e"));

        //jackson2SamplePojo2
        Assert.assertTrue(jackson2SamplePojo2.getBooleanValue());
        Assert.assertEquals(123, jackson2SamplePojo2.getInteger(), 1);
        Assert.assertEquals("File Mock", jackson2SamplePojo2.getString());
        Assert.assertNotNull(jackson2SamplePojo2.getSubObject());
        //  SubObject //
        Assert.assertEquals("b", jackson2SamplePojo2.getSubObject().getA());
        Assert.assertEquals("d", jackson2SamplePojo2.getSubObject().getC());
        Assert.assertEquals("f", jackson2SamplePojo2.getSubObject().getE());
        Assert.assertNotNull(jackson2SamplePojo2.getArray());
        //Collection
        Assert.assertEquals(3, jackson2SamplePojo2.getArray().size());
        Assert.assertEquals(1, jackson2SamplePojo2.getArray().get(0), 1);
        Assert.assertEquals(2, jackson2SamplePojo2.getArray().get(1), 1);
        Assert.assertEquals(3, jackson2SamplePojo2.getArray().get(2), 1);
        Assert.assertNotNull(jackson2SamplePojo2.getMetaData());
        //MAP
        Assert.assertEquals(3, jackson2SamplePojo2.getMetaData().size());
        Assert.assertEquals("b", jackson2SamplePojo2.getMetaData().get("a"));
        Assert.assertEquals("d", jackson2SamplePojo2.getMetaData().get("c"));
        Assert.assertEquals("f", jackson2SamplePojo2.getMetaData().get("e"));

        //gsonPojo
        Assert.assertTrue(gsonPojo.getBooleanValue());
        Assert.assertEquals(123, gsonPojo.getInteger(), 1);
        Assert.assertEquals("File Mock", gsonPojo.getString());
        Assert.assertNotNull(gsonPojo.getSubObject());
        //  SubObject //
        Assert.assertEquals("b", gsonPojo.getSubObject().getA());
        Assert.assertEquals("d", gsonPojo.getSubObject().getC());
        Assert.assertEquals("f", gsonPojo.getSubObject().getE());
        Assert.assertNotNull(gsonPojo.getArray());
        //Collection
        Assert.assertEquals(3, gsonPojo.getArray().size());
        Assert.assertEquals(1, gsonPojo.getArray().get(0), 1);
        Assert.assertEquals(2, gsonPojo.getArray().get(1), 1);
        Assert.assertEquals(3, gsonPojo.getArray().get(2), 1);
        Assert.assertNotNull(gsonPojo.getMetaData());
        //MAP
        Assert.assertEquals(3, gsonPojo.getMetaData().size());
        Assert.assertEquals("b", gsonPojo.getMetaData().get("a"));
        Assert.assertEquals("d", gsonPojo.getMetaData().get("c"));
        Assert.assertEquals("f", gsonPojo.getMetaData().get("e"));

        //moshiSamplePojo
        Assert.assertTrue(moshiSamplePojo.getBooleanValue());
        Assert.assertEquals(123, moshiSamplePojo.getInteger(), 1);
        Assert.assertEquals("File Mock", moshiSamplePojo.getString());
        Assert.assertNotNull(moshiSamplePojo.getSubObject());
        //  SubObject //
        Assert.assertEquals("b", moshiSamplePojo.getSubObject().getA());
        Assert.assertEquals("d", moshiSamplePojo.getSubObject().getC());
        Assert.assertEquals("f", moshiSamplePojo.getSubObject().getE());
        Assert.assertNotNull(moshiSamplePojo.getArray());
        //Collection
        Assert.assertEquals(3, moshiSamplePojo.getArray().size());
        Assert.assertEquals(1, moshiSamplePojo.getArray().get(0), 1);
        Assert.assertEquals(2, moshiSamplePojo.getArray().get(1), 1);
        Assert.assertEquals(3, moshiSamplePojo.getArray().get(2), 1);
        Assert.assertNotNull(moshiSamplePojo.getMetaData());
        //MAP
        Assert.assertEquals(3, moshiSamplePojo.getMetaData().size());
        Assert.assertEquals("b", moshiSamplePojo.getMetaData().get("a"));
        Assert.assertEquals("d", moshiSamplePojo.getMetaData().get("c"));
        Assert.assertEquals("f", moshiSamplePojo.getMetaData().get("e"));

    }

}
