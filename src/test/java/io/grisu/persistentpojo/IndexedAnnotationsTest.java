package io.grisu.persistentpojo;

import java.util.Map;

import io.grisu.persistentpojo.supportingclasses.MyTestingClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IndexedAnnotationsTest {
   @Test
   public void getIndexes() {
      MyTestingClass myTestingClass = new MyTestingClass();
      Map<String, Index> indexes = myTestingClass.__getIndexes();
      assertEquals(1, indexes.size());
      assertEquals("value", indexes.keySet().toArray()[0]);
   }

}
