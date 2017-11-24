# {FileMock}  ![version](https://img.shields.io/badge/version-1.0.0-orange.svg?style=flat) ![License: MIT](http://img.shields.io/badge/license-MIT-blue.svg?style=flat)


FileMock is a simple yet powerful java library to convert Jason file into objects while writing unit tests. Most of the time writing unit test made difficult by creating nested service response. creating a proper input object may take hundreds of lines and hours of dev effort. `FileMock` is designed to reduce this effort by simply saving the response as JSON files and annotate the path in your test file.

### Usage 

#### Include maven dependecy 
```xml 
<dependency>
    <groupId>io.kvlabs.filemock</groupId>
    <artifactId>core</artifactId>
    <version>1.0.0</version>
</dependency>
<dependency>
    <groupId>io.kvlabs.filemock</groupId>
    <artifactId>junit</artifactId>
    <version>1.0.0</version>
</dependency>
```
#### Anotation driven 
Annotate the object need to be mocked with `@MockFile` and invoke `initMocks` on test case setup

```java
public class SampleTest {

    @MockFile(path = "/META-INF/mock/v1/get_item_response.json")
    SampleResponse sample;
    
    @Before // JUnit 
    @BeforeMethod(alwaysRun=true) // TestNG
    public void setUp() {
        FileMockAnnotations.initMocks(this);
    }
    
    @Test
    public void testInitMocks() {
        Assert.assertNotNull("sample response got set ", sample);
    }
}
```

#### JUnit Runner
Annotate the object need to be mocked with `@MockFile` and run with `FileMockJUnitRunner`
```java
@RunWith(FileMockJUnitRunner.class)
public class SampleTest {

    @MockFile(path = "/META-INF/mock/v1/get_item_response.json")
    SampleResponse sample;
    
    @Test
    public void testInitMocks() {
        Assert.assertNotNull("sample response got set ", sample);
    }
}
```

#### MockUtil
Use `FileMock.mockFile` function straight in the test method
```java
import static io.kvlabs.filemock.core.FileMock.mockFile;

public class SampleTest {
    
    @Test
    public void testInitMocks() {
        SampleResponse sample = mockFile("/META-INF/mock/v1/get_item_response.json", SampleResponse.class);
        Assert.assertNotNull("sample response got set ", sample);
    }
}
``` 