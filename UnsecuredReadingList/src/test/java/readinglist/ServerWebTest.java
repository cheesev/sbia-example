package readinglist;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ReadingListApplication.class, webEnvironment=WebEnvironment.RANDOM_PORT)
public class ServerWebTest {
  
  @Value("${local.server.port}")
  private int port;
  
  @Test
  public void testSomething() throws Exception {
    
    RestTemplate template = new RestTemplate();
    String s = template.getForObject("http://localhost:{port}", String.class, port);
    System.out.println(s);
//    ResponseEntity<String> response = template.getForEntity("/rest/customers", String.class);     
//    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
  }

}
