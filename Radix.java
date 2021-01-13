public class Radix{

// get nth digit of an int, where 0 is the ones column, 1 is the tens column etc.
  public static int nth(int n, int col) {
    return Math.abs((n / (int)Math.pow(10, col) % 10));
  }

// return the number of digits in n.
  public static int length(int n) {
    if (n == 0) {
      return 1;
    }
    return ((int) (Math.log10(Math.abs(n)) + 1));
  }


  // Merge all of the linked lists in the bucket array into your original linked list.
  // The original may have elements, and those should be kept.
  // This is O(buckets.length) which should be 10 when we use this later.
  // The bucket[0] list will be merged first, then the bucket[1] etc.
  // Write and thoroughly test these methods!
  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets) {
    for (int i = 0; i < buckets.length; i ++) {
      original.extend(buckets[i]);
    }
}

// Write a method that sorts non-negative integer values: [This part is the most important part, and I expect every student can complete it!]
// Assume there are no negative values.
// Use the algorithm described in class/class notes
  public static void radixSortSimple(SortableLinkedList data) {
    // Create bucket list
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i ++) {
      buckets[i] = new SortableLinkedList();
    }
  // find maxColumn
  int maxColumn = 0;
  int item = 0;
  int size = data.size();
  for (int i = 0; i < size; i ++) {
    if (Radix.length(data.get(i)) > maxColumn) {
      maxColumn = Radix.length(data.get(i));
    }
  }
  for (int col = 0; col < maxColumn; col ++) {
  while (data.size()>0) {
      item = data.remove(0);
      // System.out.print("item: ");
      // System.out.println(item);
      // System.out.print("Column: ");
      // System.out.println(col);
      buckets[Radix.nth(item, col)].add(item);
    }
    // for (int i = 0; i < 10; i ++) {
    //   System.out.println(buckets[i]);
    // }
    merge(data, buckets);
    // System.out.println(data);
  }
}

//   6. Write a method that sorts any integer values: [This part can be very easy or not as easy depending how you wrote the first method. It is the least important part, and I expect some students will not complete it.]
  public static void radixSort(SortableLinkedList data) {
    // Create bucket list
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i ++) {
      buckets[i] = new SortableLinkedList();
    }
    SortableLinkedList[] negbuckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i ++) {
      negbuckets[i] = new SortableLinkedList();
    }
    // find maxColumn
    int maxColumn = 0;
    int item = 0;
    int size = data.size();
    for (int i = 0; i < size; i ++) {
    if (Radix.length(data.get(i)) > maxColumn) {
      maxColumn = Radix.length(data.get(i));
    }
    }
    for (int col = 0; col < maxColumn; col ++) {
      while (data.size()>0) {
        item = data.remove(0);
        if (item >= 0) {
          buckets[Radix.nth(item, col)].add(item);
    }
        else {
          negbuckets[9-(Radix.nth(item,col))].add(item);
        }
  }
    merge(data, negbuckets);
    merge(data, buckets);
  }
 }
}
