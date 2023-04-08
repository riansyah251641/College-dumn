package list;

public class Mid extends List {

    // 8
    static List negateAll(List a) {
        /*
         * 1. a list with current negated element as the head save in templist
         * 2. then Save it in newList
         * 3. there have two case, first if current list is not empty give task to next
         * list and store list returned
         * 4. second if list is empty return list.nil()
         * 5. Last return data in templist
         */
        //
        List tempList = new List(-a.head, List.nil());
        List newList = List.nil();
        if (!a.empty) {
            newList = negateAll(a.tail);
        } else {
            return List.nil();
        }
        return ListOps.append(tempList, newList);
    }

    // 9
    static int find(int x, List a) {
        /*
         * 1. this function use to find a number in list
         * 2. then if find that number return the position of number in list
         * 3. start with 0,1,2,3,4,....
         * 4. but if a number is not exist in list or list empty return -1
         * 5. Do with recursive to check a number in list
         * 6. return the output with cekk+1 to know the position
         */
        if (!a.empty) {
            if (a.head == x)
                return 0;
            else {
                int cekk = find(x, a.tail);
                if (cekk == -1)
                    return -1;
                else
                    return cekk + 1;
            }
        }
        return -1;
    }

    // 10
    static boolean allPositive(List a) {
        /*
         * 1. there have three case
         * 2. case 1 if list is empty so return true
         * 3. case 2 if in list have a negative number return false
         * 4. case 3 if check number from head in list still positive do recurive tu
         * check next number in list
         * 5, it will be return true if all number in list is a positive number
         */
        if (a.empty) {
            return true;
        } else if (a.head < 0) {
            return false;
        } else {
            return allPositive(a.tail);
        }
    }

    // 11
    static List positives(List a) {
        /*
         * 1. make a new list to save a positive number
         * 2. check all number in list form head with recursive
         * 3. then if find a positive number save it in new list
         * 4. last return the list
         */
        if (a.empty())
            return new List();
        if (a.head >= 0)
            return new List(a.head, positives(a.tail()));
        return positives(a.tail());
    }

    // 12
    static boolean sorted(List a) {
        /*
         * 1. this function is use to display a list number who is smaller than next
         * number in list
         * 2. first, make a break with if a.tail.empty with return true
         * 3.then make a fuction to check if a number is smaller than next number in
         * list
         * 4. if true than number the list still include sorted then return true
         * 5. do a recursive to check next number
         * 6. but if else the list is not sorted
         */
        if (a.tail.empty) {
            return true;
        } else if (a.head <= a.tail.head && sorted(a.tail)) {
            return true;
        } else {
            return false;
        }
    }

    // 13
    static List merge(List a, List b) {
        /*
         * 1. this fuction will make sorting from two list be one list from small to
         * large
         * 2. with steps make a break with check two list a,b is empty
         * 3. then check from head between two list who is smaller
         * 4. then save it into new list
         * 5. do recursive to input all number in two list
         */
        if (a.empty())
            return b;
        else if (b.empty())
            return a;
        if (a.head <= b.head)
            return new List(a.head, merge(a.tail(), b));
        else
            return new List(b.head, merge(a, b.tail()));
    }

    // 14
    static List removeDuplicate(List a) {
        /*
         * 1. this fuction is make a list if have a two or more same number in list just
         * output one number
         * 2. with steps, make a break with if list a is empty return an empty list.
         * 3. make a temp list to save all number in element
         * 4. make a list namely list_one_number to save all number than no have
         * duplicate number
         * 5. use fuction skip to skip if current number is same with a number in
         * list_one_number
         * 6. but if different input in list_one_number
         * 7. do recursive to check all number
         * 8. Return the list_one_number
         */
        if (a.empty) {
            return List.nil();
        }
        List tempList = new List(a.head, List.nil());
        List list_one_number = a.tail;
        if (a.head == a.tail.head) {
            list_one_number = skip(a.head, a.tail);
        } else {
            list_one_number = a.tail;
        }
        list_one_number = removeDuplicate(list_one_number);
        return ListOps.append(tempList, list_one_number);
    }

    // 15
    static List skip(int x, List a) {
        /*
         * 1. this fuction will compare all number in list if a number has equal value
         * with number before it will skip to the next number.
         * 2. there have two case
         * 3. case 1 if all number is not have equal value, it will add all the number
         * in list
         * 4. case 2 if not equal it will add the current number into the new list
         * 5. do recursive to check all node
         */
        if (a.empty())
            return a;
        if (a.head != x)
            return new List(a.head, skip(x, a.tail()));
        return skip(x, a.tail());
    }
}