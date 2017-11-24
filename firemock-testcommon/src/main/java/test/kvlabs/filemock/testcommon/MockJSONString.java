package test.kvlabs.filemock.testcommon;

/**
 *
 * @author kanchana
 */
public class MockJSONString {

    public static final String STANDARD = "{\n"
            + "  \"boolean\": true,\n"
            + "  \"integer\": 123,\n"
            + "  \"string\": \"File Mock\",\n"
            + "  \"array\": [\n"
            + "    1,\n"
            + "    2,\n"
            + "    3\n"
            + "  ],\n"
            + "  \"sub_object\": {\n"
            + "    \"a\": \"b\",\n"
            + "    \"c\": \"d\",\n"
            + "    \"e\": \"f\"\n"
            + "  },\n"
            + "  \"meta_data\": {\n"
            + "    \"a\": \"b\",\n"
            + "    \"c\": \"d\",\n"
            + "    \"e\": \"f\"\n"
            + "  }\n"
            + "}";
    
    public static final String SUBSET = "{\n"
            + "  \"boolean\": true,\n"
            + "  \"integer\": 123,\n"
            + "  \"string\": \"File Mock\",\n"
            + "  \"sub_object\": {\n"
            + "    \"a\": \"b\",\n"
            + "    \"c\": \"d\",\n"
            + "    \"e\": \"f\"\n"
            + "  }\n"
            + "}";
    
    public static final String SUPER_SET = "{\n"
            + "  \"boolean\": true,\n"
            + "  \"name\" :\"kanchana\",\n"
            + "  \"integer\": 123,\n"
            + "  \"string\": \"File Mock\",\n"
            + "  \"array\": [\n"
            + "    1,\n"
            + "    2,\n"
            + "    3\n"
            + "  ],\n"
            + "  \"sub_object\": {\n"
            + "    \"a\": \"b\",\n"
            + "    \"c\": \"d\",\n"
            + "    \"e\": \"f\"\n"
            + "  },\n"
            + "  \"meta_data\": {\n"
            + "    \"a\": \"b\",\n"
            + "    \"c\": \"d\",\n"
            + "    \"e\": \"f\"\n"
            + "  }\n"
            + "}";
    
    public static final String YAMAL = "---\n"
            + "boolean: true\n"
            + "integer: 123\n"
            + "string: File Mock\n"
            + "array:\n"
            + "- 1\n"
            + "- 2\n"
            + "- 3\n"
            + "sub_object:\n"
            + "  a: b\n"
            + "  c: d\n"
            + "  e: f\n"
            + "meta_data:\n"
            + "  a: b\n"
            + "  c: d\n"
            + "  e: f\n"
            + "";
}
