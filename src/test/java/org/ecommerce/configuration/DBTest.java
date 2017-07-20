package org.ecommerce.configuration;

import org.ecommerce.services.EmailService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration()
@ContextConfiguration(classes = {HibernateConfiguration.class, AppConfig.class}, loader = AnnotationConfigWebContextLoader.class)
public class DBTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    EmailService emailService;

    @Test
    public void testDummy() throws SQLException {
        String schema = dataSource.getConnection().getCatalog();
        assertTrue("ecommerce".equalsIgnoreCase(schema));
    }

    @Test
    @Ignore
    public void testSendEmail() {
        emailService.sendEmail("admin@gmail.com", "Test Mail", "This is a test email.");
    }

}