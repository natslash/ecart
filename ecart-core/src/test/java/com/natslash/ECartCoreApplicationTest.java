/**
 * Copyright 2018 Orenes Grupo.
 */

package com.natslash;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
    classes = ECartCoreApplication.class)
public class ECartCoreApplicationTest {

  @Autowired
  DataSource dataSource;

  @Test
  public void testDummy() throws SQLException {
    final String schema = dataSource.getConnection().getCatalog();
    assertEquals("ecart", schema);
  }

}
