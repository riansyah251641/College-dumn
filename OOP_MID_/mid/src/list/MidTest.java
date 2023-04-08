package list;

public class MidTest {

    public static void main(String[] args) {
        // --- 8. negateAll ---
        // Create a list, namely list1: 2, -5, 8, 0
        // Then create list2 which is the negation of the elements at list1
        // list1: 2, -5, 8, 0 --> list2 = -2, 5, -8, 0
        System.out.println("--- 8. [5 points] negateAll ---");
        List list1 = new List(-2, List.nil());
        list1 = ListOps.addtoendr(list1, 5);
        list1 = ListOps.addtoendr(list1, -8);
        list1 = ListOps.addtoendr(list1, 0);
        System.out.print("list1: ");
        ListOps.printList(list1);
        System.out.println();
        System.out.print("list2 is the negation of list1: ");
        List list2 = Mid.negateAll(list1);
        ListOps.printList(list2);
        System.out.println();
        System.out.println();
        // --- 8. negateAll ---

        // --- 9. find ---
        // Find the element 8 starting from 0 from list9
        // It is found at position 2
        System.out.println("--- 9. [5 points] find ---");
        List list3 = new List(7, List.nil());
        list3 = ListOps.addtoendr(list3, 5);
        list3 = ListOps.addtoendr(list3, 3);
        list3 = ListOps.addtoendr(list3, 8);
        System.out.print("list3: ");
        ListOps.printList(list3);
        System.out.println();
        System.out.print("Finding the position of the first 3 (starting from 0) in list3: ");
        System.out.println(Mid.find(3, list3));
        // Find the element 2 starting from 0 from list3
        // 2 is not found, so it returns -1
        System.out.print("Finding the position of the first 2 (starting from 0) in list3: ");
        System.out.println(Mid.find(2, list3));
        System.out.println();
        // --- 9. find ---

        // --- 10. allPositive ---
        // Check whether all of its elements are positive in list
        System.out.println("--- 10. [5 points] allPositive ---");
        System.out.print("Check whether all of its elements are positive in list1: ");
        System.out.println(Mid.allPositive(list1));
        System.out.print("Check whether all of its elements are positive in list3: ");
        System.out.println(Mid.allPositive(list3));
        System.out.println();
        // --- 10. allPositive ---

        // --- 11. positives ---
        // Find the positive elements in list
        System.out.println("--- 11. [10 points] positives ---");
        List list4 = new List(2, List.nil());
        list4 = ListOps.addtoendr(list4, 3);
        list4 = ListOps.addtoendr(list4, -5);
        list4 = ListOps.addtoendr(list4, 8);
        list4 = ListOps.addtoendr(list4, -2);
        System.out.print("list4: ");
        ListOps.printList(list4);
        System.out.println();
        System.out.print("list5 is the positive elements of list4: ");
        List list5 = Mid.positives(list4);
        ListOps.printList(list5);
        System.out.println();
        System.out.println();
        // --- 11. positives ---

        // --- 12. sorted ---
        // Check if list5 is sorted
        System.out.println("--- 12. [10 points] sorted ---");
        // list4: 2 3 -5 8 -2, so it is not sorted
        System.out.print("list4: ");
        ListOps.printList(list4);
        Boolean b = Mid.sorted(list4);
        String s = b ? "sorted" : "unsorted";
        System.out.print(". It is " + s);
        System.out.println(" (Increment Order).");
        // list5: 2 3 8, so it is sorted
        System.out.print("list5: ");
        ListOps.printList(list5);
        b = Mid.sorted(list5);
        s = b ? "sorted" : "unsorted";
        System.out.print(". It is " + s);
        System.out.println(" (Increment Order).");
        System.out.println();
        // --- 12. sorted ---

        // --- 13. merge ---
        // Merging two sorted lists, keep the duplicate copies
        System.out.println("--- 13. [10 points] merge ---");
        System.out.println("Merging two sorted lists");
        List list6 = new List(2, List.nil());
        list6 = ListOps.addtoendr(list6, 5);
        list6 = ListOps.addtoendr(list6, 5);
        list6 = ListOps.addtoendr(list6, 8);
        System.out.print("list6: ");
        ListOps.printList(list6);
        System.out.println();
        List list7 = new List(5, List.nil());
        list7 = ListOps.addtoendr(list7, 7);
        list7 = ListOps.addtoendr(list7, 8);
        list7 = ListOps.addtoendr(list7, 9);
        System.out.print("list7: ");
        ListOps.printList(list7);
        System.out.println();
        System.out.print("Merging list6 & list7 into list8: ");
        List list8 = Mid.merge(list6, list7);
        ListOps.printList(list8);
        System.out.println();
        List list9 = new List(9, List.nil());
        System.out.print("list9: ");
        ListOps.printList(list9);
        System.out.println();
        System.out.print("Merging list6 & list9 into list10: ");
        List list10 = Mid.merge(list6, list9);
        ListOps.printList(list10);
        System.out.println();
        System.out.println();
        // --- 13. merge ---

        // --- 14. removeDuplicate ---
        // Remove duplicate
        System.out.println("--- 14. [10 points] removeDuplicate ---");
        System.out.print("Remove all duplicate copies at list8 into list11: ");
        List list11 = Mid.removeDuplicate(list8);
        ListOps.printList(list11);
        System.out.println();
        System.out.println();
        // --- 14. removeDuplicate ---

        // --- 15. skip ---
        System.out.println("--- 15. [5 points] skip ---");
        System.out.print("Element 5 skipped at list8, assigned into list12: ");
        List list12 = Mid.skip(5, list8);
        ListOps.printList(list12);
        System.out.println();
        // --- 15. skip ---
    }
}