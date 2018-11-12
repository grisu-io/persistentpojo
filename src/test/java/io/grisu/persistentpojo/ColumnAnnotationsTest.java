package io.grisu.persistentpojo;

import java.util.Collection;

import io.grisu.persistentpojo.supportingclasses.MyTestingClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColumnAnnotationsTest {

   @Test
   public void getPrimaryKeys() {
      MyTestingClass myTestingClass = new MyTestingClass();
      Collection<String> primaryKeys = myTestingClass.__getPrimaryKeys();
      assertEquals(1, primaryKeys.size());
      assertEquals("key", primaryKeys.toArray()[0]);
   }

}
