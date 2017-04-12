package sample.autoconfiguration;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class ProperitesTest {

    private String getJson() throws IOException {
        return IOUtils.toString(ProperitesTest.class.getClassLoader().getResource("META-INF/spring-configuration-metadata.json"), "UTF-8");
    }

    @Test
    public void testGroups() throws IOException {
        String json = getJson();
        assertThat(json, hasJsonPath("$.groups.[*]..[?(@.name == 'sample.inner')]", hasSize(1)));
    }

    @Test
    public void testProperties() throws IOException {
        String json = getJson();
        assertThat(json, hasJsonPath("$.properties.[*]..[?(@.name == 'sample.inner.enabled')]", hasSize(1)));
    }

}
