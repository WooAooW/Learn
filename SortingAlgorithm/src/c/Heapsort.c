#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <limits.h> 
#define  LENGTH 10
#define  true  1
#define  false  0
void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

/*
 * Heap Sort 
 * Core thing： place the maximum on the top of heap
 * at each  time 
 * Spacw complexity: O(n log n)
 * Time complexity： O(1)
 * */
/* adjust the heap , place the maximum on the top of heap
 * this is a recursive method
 * */
void  Max_Heapify_Recursive(int list[], int node , int length)
{
    int son, r;
    son = node * 2 + 1;
    r = node * 2 + 2;
    
    if  (son < length)
    {
        if  (r < length && list[son] < list[r])/* place the bigger value on left child */
        {
            swap(&list[son], &list[r]);
            Max_Heapify_Recursive(list, r, length);
        }
        if  (list[node] < list[son])
        {
            swap(&list[node], &list[son]);
            Max_Heapify_Recursive(list, son, length);
        }    

    }

}
/* adjust the heap , place the maximum on the top of heap
 * this is a non recursive method
 * */
void  Max_Heapify(int list[], int node , int length)
{
    int son  = node * 2 + 1; /* start node left child */
    int dad = node; 
    while(son < length) 
    {
        /* place  son point to  bigger child */
        if  (son + 1 < length && list[son + 1] > list[son])
            son++;

        if  (list[dad] > list[son]) 
            return;
        else
        {   /* place dad store the  bigger child */
            swap(&list[dad], &list[son]);
            dad = son;
            son = dad * 2 +1;
        }    

    }

}

/*HeapSort
 * */
void HeapSort(int list[], int length)
{
    /* */
    int i;
    /* initialize the top heap , adjust all parental nodes forward and backward
     * i - 1 because of the root  node is 0 */
    for (i=length/2 - 1; i >= 0; i--)
//        Max_Heapify_Recursive(list, i, length);
        Max_Heapify(list, i, length);
   
    for(i = length -1; i > 0; i--)
    {   
        swap(&list[0], &list[i]);
        Max_Heapify(list, 0, i);
//        Max_Heapify_Recursive(list, 0, i);
    }

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
    HeapSort(list, LENGTH);
    list_for_each(list, LENGTH);
}

