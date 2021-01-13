public class Radix{

  public static int nth(int n, int col) {
    return Math.abs((n / (int)Math.pow(10, col) % 10));
  }
// get nth digit of an int, where 0 is the ones column, 1 is the tens column etc.

//
// 2. public static int length(int n)
// return the number of digits in n.
// length(0) -> 1
// length(15) -> 2
// length(-10) -> 2
// length(5112) -> 4
// Second Part:
//
// 3. public static void merge(MyLinkedList original,MyLinkedList[]buckets)
// Merge all of the linked lists in the bucket array into your original linked list. The original may have elements, and those should be kept.
// This is O(buckets.length) which should be 10 when we use this later.
// The bucket[0] list will be merged first, then the bucket[1] etc.
// Write and thoroughly test these methods!

}
