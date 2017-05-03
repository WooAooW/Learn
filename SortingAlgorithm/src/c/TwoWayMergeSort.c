#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <limits.h> 
#define  LENGTH 10
#define  true  1
#define  false  0

/*
 * Merge Sort 
 * Core thing： Recursive merge adjacent elements
 * at each  time 
 * Spacw complexity: O(n log n)
 * Time complexity： O(n)
 * */
void Merge_Sort_Recrusive(int list[], int arr[], int start, int end)
{
    if  (start >= end) 
        return;
    
    int len = end - start;
    int mid = (len >> 1) + start;

    int start1 = start;
    int end1 = mid;
    int start2 = mid + 1;
    int end2 = end;
    Merge_Sort_Recrusive(list, arr, start1, end1);
    Merge_Sort_Recrusive(list, arr, start2, end2);
    
    int k = start;
    while(start1 <= end1 && start2 <= end2) /* merge two way */
        arr[k++] = (list[start1] < list[start2]? list[start1++]: list[start2++]);

    while(start1 <= end1)/* the left way bigger than the right way */
        arr[k++] = list[start1++];

    while(start2 <= end2)/* the right way bigger than the left way */
        arr[k++] = list[start2++];

    for (k = start; k <= end; k++)
       list[k] = arr[k];
}

void MergeSort(int list[], int length)
{
    int arr[length];
    Merge_Sort_Recrusive(list, arr, 0, length - 1);
}


/* create a  array in heap memrory
 * parameter : length is the sizeof array
 * return :  return the address of array 
 * */
int*  CreateList(int length)
{   
    int *list  = (int *)malloc(sizeof(int) *  length);
    srand(time(NULL)); /* create a random value */
    int i;
    for(i = 0; i < LENGTH; i++)    
        list[i] = rand()%50;/* get a <50 de  random value */
    return list;
}
/*  print a int array */
void list_for_each(int * list, int length)
{
    int i;
    for(i = 0; i < length; i++)
        printf("%d ", list[i]);
    printf(" \n");
}


int main()
{
    int *list = CreateList(LENGTH);
//    int list[10] = {2, 12, 39, 32, 25, 27, 36, 36, 35, 40};
    list_for_each(list, LENGTH);
    MergeSort(list, LENGTH);
    list_for_each(list, LENGTH);
    return 0;
}

