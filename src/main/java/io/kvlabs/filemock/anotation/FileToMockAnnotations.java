package io.kvlabs.filemock.anotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import static io.kvlabs.filemock.FileToMock.mockFile;

/**
 * @author kanchana-prasanth
 */
public class FileToMockAnnotations {

    /**
     * Initializes objects annotated with FileMock annotations for given
     * testClass: {@link io.kvlabs.filemock.anotation.MockFromFile}
     *
     * @param testClass
     */
    public static void initMocks(Object testClass) {
        if (testClass == null) {
            throw new IllegalArgumentException("testClass cannot be null. For info how to use @MockFromFile annotations see examples in javadoc for FileMockAnnotations class");
        }
        //all is well 
        try {
            Class<?> clazz = testClass.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                for (Annotation annotation : field.getAnnotations()) {
                    //evaluate only mock
                    if (MockFromFile.class == annotation.annotationType()) {
                        MockFromFile mockAnotation = field.getAnnotation(MockFromFile.class);
                        //Deserialize 
                        Object fieldValue = mockFile(mockAnotation.path(), mockAnotation.mapper(), mockAnotation.safeMode(), field.getType());
                        if (fieldValue != null) {
                            //set accessible
                            field.setAccessible(true);
                            field.set(testClass, fieldValue);
                        }
                    }
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException ex) {
            throw new RuntimeException("faild to access fileds");
        }
    }
}
