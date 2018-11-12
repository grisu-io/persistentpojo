package io.grisu.persistentpojo;

public class Index {

   public enum IndexType { DEFAULT, GEO_LOCATION };

   private IndexType type;

   public Index() {
      this.type = IndexType.DEFAULT;
   }

   public Index(IndexType indexType) {
      this.type = indexType;
   }

   public IndexType getType() {
      return type;
   }

   public Index setType(IndexType type) {
      this.type = type;
      return this;
   }

}
