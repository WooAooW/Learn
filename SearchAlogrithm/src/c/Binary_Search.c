#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <limits.h> 
#include "/home/logan/Documents/learn/Learn/SortingAlgorithm/src/c/BubbleSort.c"
#define  LENGTH 10
#define  true  1
#define  false  0
 /* 
 * Binary Search 
 * Core thing： compara to the middle of the array of ordered  at each  time 
 * Requried: the array is must be Sorted 
 * Success ASL : O(n log n)
 * Failed ASL : O(n log n)
 * */
/* this is a recursive */
int  Binary_Search_Recursive(int list[], int left, int right, int key)
{   
    int len = right - left;
    int mid = left + len/2;
    if  (left <= right)
    {    
        if  (list[mid] == key)
            return mid;
        else if  (key > list[mid])
            Binary_Search_Recursive(list, mid + 1, right, key);
        else 
            Binary_Search_Recursive(list, left, mid - 1, key);
    }
    else        
        return -1;
}

/* this is not a recursive */
int  Binary_Search(int list[], int left, int right, int key)
{   
    int mid = 0;

    while  (left <= right) /* the key is out the array */
   { 
        mid = (left + right)/2; /* (left + right)/2 == left + (right - left)/2*/

        if  (list[mid] == key)
            return mid;
        else if  (key > list[mid])
            left = mid + 1; /* search the right range of  array */
        else 
            right = mid - 1;/* search the left range of  array */
    }

    return -1;
}
/*
*int main()
*{
*    int list[10] = {2, 12, 39, 32, 25, 27, 36, 36, 35, 40};
*    BubbleSort(list, LENGTH);
*    list_for_each(list, LENGTH);
*    int key = 0;
*    int rs = -1;
*    int n = 0;
*    while((n =scanf("%d", &key)) == 1)
*    {
*        rs = Binary_Search(list, 0, 9,key );
*        if  (rs >= 0)
*            printf("find the result is %d \n ", rs);
*
*        else 
*            printf("error:the key  is not in the array");
*    }
*    return 0;
*}
*/

