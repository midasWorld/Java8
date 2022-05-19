package com.java.base.collection;

import com.java.base.collection.liter.MyIiterator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyCollection<T> {
  private List<T> list;

  public MyCollection(List<T> list) {
    this.list = list;
  }

  public MyCollection<T> filter(Predicate<T> predicate) {
    List<T> newList = new ArrayList<>();
    foreach(d -> {
      if (predicate.test(d)) newList.add(d);
    });
    return new MyCollection<>(newList);
  }

  public <U> MyCollection<U> map(Function<T, U> function) {
    List<U> newList = new ArrayList<>();
    foreach(d -> newList.add(function.apply(d)));
    return new MyCollection<>(newList);
  }

  public MyIiterator<T> iterator() {
    return new MyIiterator<T>() {
      private int index = 0;
      @Override
      public boolean hasNext() {
        return list.size() < index;
      }

      @Override
      public T next() {
        return list.get(index++);
      }
    };
  }

  public void foreach(Consumer<T> consumer) {
    for (T data : list) {
      consumer.accept(data);
    }
  }
}
