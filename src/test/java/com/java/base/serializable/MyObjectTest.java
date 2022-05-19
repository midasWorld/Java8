package com.java.base.serializable;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

class MyObjectTest {



  @Test
  void serializableWriteTest() throws IOException, ClassNotFoundException {
    byte[] serializedObject;

    // 직렬화
    // java.io.ObjectOutputStream
    //  - writeObject(Object object)
    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
      MyObject myObject = new MyObject(1);
      objectOutputStream.writeObject(myObject);
      serializedObject = byteArrayOutputStream.toByteArray();
    }
    assertThat(serializedObject).isNotEmpty();

    // 역직렬화
    // java.io.ObjectInputStream
    //  - readObject()
    try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedObject);
         ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
      MyObject read = (MyObject) objectInputStream.readObject();
      assertThat(read.value).isEqualTo(1);
    }
  }
}